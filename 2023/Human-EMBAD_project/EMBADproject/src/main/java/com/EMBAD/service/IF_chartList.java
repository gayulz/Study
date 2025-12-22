package com.EMBAD.service;

import com.EMBAD.vo.EmergencyChart;

import java.util.List;

public interface IF_chartList {
    public void inserChart(EmergencyChart chart);
    public List<EmergencyChart> selectAll(String email);
    public List<EmergencyChart> selectDutyChart(String hpid);
    public EmergencyChart oneChartDetail(int ptntNumber);
    public void deleteChartOne(int ptntNumber);
}
