package com.EMBAD.dao;

import com.EMBAD.vo.EmergencyChart;

import java.util.List;

public interface IF_chartDAO {
    public void insertChartOne(EmergencyChart emchart);
    public List<EmergencyChart> myChartAll(String email);
    public List<EmergencyChart> dutyChart(String hpid);
    public EmergencyChart selectChartDetail(int ptntNumber);
    public void deleteChartOne(int ptntNumber);
}
