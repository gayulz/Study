package DTO;

public class Rental_Car {
    // todo : Super Class
    public String car_number;
    public String car_title;
    public String car_type;
    public String car_mnfct;
    public String car_fuel;
    public String car_status;

    public void rental_default_prt(){
        System.out.println("차량 번호 : " + this.car_number);
        System.out.println("모델명 : " + this.car_title);
        System.out.println("차종 : " + this.car_type);
        System.out.println("제조사 : " + this.car_mnfct);
        System.out.println("연료타입 : " + this.car_fuel);
        System.out.println("대여 상태 : " + this.car_status);
    }
}
