package com.EMBAD.service;

import com.EMBAD.vo.HospitalReturnVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:application.properties")
@Service
public class HospitalDataAPI {
    // API KEY 정보
    @Value("${HOSPITAL.APIKEY}")
    private String hospitalKEY;
    @Value("${HOSPITAL.APIURL}")
    private String hospitalURL;


    /**
     * 공공데이터포털 API 1번째 항목 :: 도시명 기준 병원 명 기관ID 를 리턴함
     * @param : 사용자 입력 도시이름
     * @return : xml형식 파싱을 처리하도록 StringBuilder로 리턴
     *  */
    public StringBuilder getHospitalData(HospitalReturnVO hospitalReturnVO) {
        try {
            // 1. URL 생성
            StringBuilder urlBuilder = new StringBuilder(String.valueOf(hospitalURL));
            urlBuilder.append("?" + "serviceKey=" + hospitalKEY);
            urlBuilder.append("&" + URLEncoder.encode("STAGE1", "UTF-8") + "=" + URLEncoder.encode(hospitalReturnVO.getCity(), "UTF-8")); /*주소(시도)*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*목록 건수*/
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

            return recombination;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 재조합된 데이터를 파싱을 하기 위해 DOM구조로 재구성 후 리턴
     * @param : xml문서 그대로 가져옴
     * @return : dom 객체로 재 조립 후 반환
     * */
    public Document returnDomData(StringBuilder recombination) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new InputStreamReader(new ByteArrayInputStream(recombination.toString().getBytes("utf-8")))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 회원 가입 용 노드 재조립 메서드
     * @param : xml에서 dom으로 조립된 객체
     * @return : {@link HospitalReturnVO} 의 dutyName , hpid 을 요소 추출 후 대입하고 리턴 */
    public List<HospitalReturnVO> returnSignupHospitalData(Document parsingData) {
        List<HospitalReturnVO> list = new ArrayList<>();
        // NODE를 기준 데이터를 추출
        NodeList dutyNameNodes = parsingData.getElementsByTagName("dutyName");
        NodeList hpidNodes = parsingData.getElementsByTagName("hpid");

        // 원하는 List<HospitalReturnVO>구조로 재조립
        for (int i = 0; i < dutyNameNodes.getLength(); i++) {
            HospitalReturnVO temp = new HospitalReturnVO();
            Element dutyNameElement = (Element) dutyNameNodes.item(i);
            Element hpidElement = (Element) hpidNodes.item(i);
            temp.setDutyName(dutyNameElement.getTextContent());
            temp.setHpid(hpidElement.getTextContent());
            list.add(temp);
        }
        return list;
    }

}
