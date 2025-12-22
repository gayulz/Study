package com.EMBAD.dao;

import com.EMBAD.vo.EmergencyChart;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ChartDAOImpl implements IF_chartDAO {

    //factory mapping정보
    private static String basicsQuery="com.EMBAD.dao";

    @Inject
    private SqlSession sqlSession;

    @Override
    public void insertChartOne(EmergencyChart emchart) {
        sqlSession.insert(basicsQuery+".chartInsert", emchart);
    }

    @Override
    public List<EmergencyChart> myChartAll(String staffNumber) {
        List<EmergencyChart> mylist = sqlSession.selectList(basicsQuery+".myChartAll", staffNumber);
        return mylist;
    }

    @Override
    public List<EmergencyChart> dutyChart(String hpid) {
        List<EmergencyChart> dutyList = sqlSession.selectList(basicsQuery+".dutyReceptionList", hpid);
        return dutyList;
    }

    // 차트 상세보기
    @Override
    public EmergencyChart selectChartDetail(int ptntNumber) {
        return sqlSession.selectOne(basicsQuery+".chartOne", ptntNumber);
    }

    @Override
    public void deleteChartOne(int ptntNumber) {
        sqlSession.delete(basicsQuery+".deleteChart", ptntNumber);
    }
}
