package DTO;

public class Rental_Success {
    private String car_number;
    private String lender_name;
    private String lender_start;
    private String lender_end;

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

    public String getLender_start() {
        return lender_start;
    }

    public void setLender_start(String lender_start) {
        this.lender_start = lender_start;
    }

    public String getLender_end() {
        return lender_end;
    }

    public void setLender_end(String lender_end) {
        this.lender_end = lender_end;
    }
}
