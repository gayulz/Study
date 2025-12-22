package com.EMBAD.service;

import com.EMBAD.dao.ChartDAOImpl;
import com.EMBAD.vo.EmergencyChart;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ChartServiceImpl implements IF_chartList{

    @Inject
    private ChartDAOImpl emchart;

    /**
     * 구급대원 직원분이 환자 차트 작성 후 병원에 접수하는 메서드*/
    @Override
    public void inserChart(EmergencyChart chart) {
        emchart.insertChartOne(chart);
    }

    @Override
    public List<EmergencyChart> selectAll(String staffNumber) {
        return emchart.myChartAll(staffNumber);
    }

    @Override
    public List<EmergencyChart> selectDutyChart(String hpid) {
        return emchart.dutyChart(hpid);
    }

    @Override
    public EmergencyChart oneChartDetail(int ptntNumber) {
        return emchart.selectChartDetail(ptntNumber);
    }

    @Override
    public void deleteChartOne(int ptntNumber) {
        emchart.deleteChartOne(ptntNumber);
    }

}

