package com.EMBAD.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EgytBassInfoInqireVO {
    // 기관코드
    private String hpid;
    // 경도
    private String wgs84Lon;
    // 위도
    private String wgs84Lat;
    // 병원이름
    private String dutyname;
    // 병원 대표전화
    private String dutytel1;
    // 응급실 전화번호
    private String dutytel3;
    // 병원주소
    private String dutyAddr;
}
