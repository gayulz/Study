package DTO;

import java.util.ArrayList;

public class Rental_contractDTO {
    public ArrayList<payDTO> contract_list;
    private String lender_name =null;
    private String lender_age =null;
    private String lender_phone =null;
    private String lender_start =null;
    private int lender_time = 0;
    private String lender_pass =null;
    private String lender_licenseType =null;
    private String lender_licenseNum =null;
    private String car_number=null;

    public int getTotal_price() { return total_price;}

    public void setTotal_price(int total_price) { this.total_price = total_price;}

    private int total_price=0;

    public String getCar_number() {
        return car_number;
    }
    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }
    public String getLender_name() {
        return lender_name;
    }
    public void setLender_name(String lender_name) {
        this.lender_name = lender_name;
    }
    public String getLender_age() {
        return lender_age;
    }
    public void setLender_age(String lender_age) {
        this.lender_age = lender_age;
    }
    public String getLender_phone() {
        return lender_phone;
    }
    public void setLender_phone(String lender_phone) {
        this.lender_phone = lender_phone;
    }
    public String getLender_start() {
        return lender_start;
    }
    public void setLender_start(String lender_start) {
        this.lender_start = lender_start;
    }
    public int getLender_time() {
        return lender_time;
    }
    public void setLender_time(int lender_time) {
        this.lender_time = lender_time;
    }
    public String getLender_pass() {
        return lender_pass;
    }
    public void setLender_pass(String lender_pass) {
        this.lender_pass = lender_pass;
    }
    public String getLender_licenseType() {
        return lender_licenseType;
    }
    public void setLender_licenseType(String lender_licenseType) {
        this.lender_licenseType = lender_licenseType;
    }
    public String getLender_licenseNum() {
        return lender_licenseNum;
    }
    public void setLender_licenseNum(String lender_licenseNum) {
        this.lender_licenseNum = lender_licenseNum;
    }
}
