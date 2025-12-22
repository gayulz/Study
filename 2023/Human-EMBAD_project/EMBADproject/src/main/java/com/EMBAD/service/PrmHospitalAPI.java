package com.EMBAD.service;

import com.EMBAD.vo.EgytBassInfoInqireVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.inject.Inject;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@PropertySource("classpath:application.properties")
@Service
public class PrmHospitalAPI {
    // API KEY 정보
    @Value("${HOSPITAL.APIKEY}")
    private String hospitalKEY;

    @Value("${HOSPITAL.APIURL3}")
    private String hospitalURL3;

    @Inject
    HospitalDataAPI hospitalDataAPI;


    // 구급구조대 노드 조립하여 객체 생성함
    private EgytBassInfoInqireVO returnEgyVO(Document parsingData) {
        // item 태그에 해당하는 NodeList를 가져옵니다.
        NodeList items = parsingData.getElementsByTagName("item");
        Element item = (Element) items.item(0);
        EgytBassInfoInqireVO vo = new EgytBassInfoInqireVO();
        // 각 필드에 해당하는 태그의 값을 가져와 VO에 설정합니다.
        vo.setHpid(getTagValue("hpid", item));
        vo.setWgs84Lon(getTagValue("wgs84Lon", item));
        vo.setWgs84Lat(getTagValue("wgs84Lat", item));
        vo.setDutyname(getTagValue("dutyName", item));
        vo.setDutytel1(getTagValue("dutyTel1", item));
        vo.setDutytel3(getTagValue("dutyTel3", item));
        vo.setDutyAddr(getTagValue("dutyAddr", item));
        return vo;
    }

    // 특정 태그의 값을 가져오는 헬퍼 메소드 , 구급 구조대 노드 재조합시 필요
    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList != null && nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }

    // 구급구조대 필요한 데이터로 파싱
    // dom : api로 받아온 데이터를 document로 재조립된 객체
    // resultData : 사용자 니즈가 들어가있는 객체 / Key 값이 사용자가 요구하는 값
    public List<String> returnMatchHospital(Document dom, HashMap<String, Object> resultData) {
        List<String> matchedHpid = new ArrayList<>();
        try {
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            // 모든 item 요소 가져오기
            NodeList items = (NodeList) xpath.evaluate("//item", dom, XPathConstants.NODESET);

            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                boolean allMatch = true;

                // 각 사용자 요구 사항 확인
                for (String key : resultData.keySet()) {
                    String value = xpath.evaluate(key, item);

                    // 값이 Y이거나 숫자이고 1 이상인 경우 검사
                    if (!value.equals("Y") && !(isNumeric(value) && Integer.parseInt(value) >= 1)) {
                        allMatch = false;
                        break;
                    }
                }
                // 일치하는 기관의 hpid 값만 가져옴
                if (allMatch) {
                    String hpid = xpath.evaluate("hpid", item);
                    matchedHpid.add(hpid);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matchedHpid;
    }

    // 숫자인지 확인하는 헬퍼 메소드
    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // join이후 (서울/경기도)데이터 합쳐진 객체들을 조회 후 객체 만들기
    public List<EgytBassInfoInqireVO> resultHospitalList(List<String> hpidMap) {
        List<EgytBassInfoInqireVO> resultList = new ArrayList<>();
        try {
            for (int i = 0; i < hpidMap.size(); i++) {
                // 1. URL 생성
                StringBuilder urlBuilder = new StringBuilder(String.valueOf(hospitalURL3));
                urlBuilder.append("?" + "serviceKey=" + hospitalKEY); // 서비스키
                urlBuilder.append("&" + URLEncoder.encode("HPID", "UTF-8") + "=" + URLEncoder.encode(hpidMap.get(i), "UTF-8")); // 병원hpid
                urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); //페이지건수
                urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*목록 건수*/

                // URL 매핑
                URL url = new URL(urlBuilder.toString());

                // URL 전송
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                //api응답값 - xml
                BufferedReader resultData;

                // 응답값 확인
                if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
                    // 응답헤더가 정상이라면 DOM 구조로 파싱하기위해 대입
                    resultData = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } else {
                    // 응답헤더가 에러라면 에러응답값 대입
                    resultData = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }
                // 응답으로 온 resultData를 라인별로 재조합한다
                StringBuilder recombination = new StringBuilder();
                String line;
                while ((line = resultData.readLine()) != null) {
                    recombination.append(line);
                }
                // io 리소스 반납
                resultData.close();
                connection.disconnect();

//                EgytBassInfoInqireVO temp = returnEgyVO(hospitalDataAPI.returnDomData(recombination));
                resultList.add(returnEgyVO(hospitalDataAPI.returnDomData(recombination)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
