package com.EMBAD.vo;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class EmergencyChartTest {

    @Test
    void setPtntDateTest() {
        EmergencyChart chart = new EmergencyChart();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        chart.setPtntDate(timestamp);
        assertNotNull(chart.getPtntDate());
        assertEquals(new java.util.Date(timestamp.getTime()), chart.getPtntDate());
    }
}