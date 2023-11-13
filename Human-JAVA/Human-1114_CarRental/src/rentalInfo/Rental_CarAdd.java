package rentalInfo;
import DAO.RentCarDAO;
import DTO.Rental_Car;

public class Rental_CarAdd extends Rental_Car {
    // todo : 차량 등록 클래스
    private Rental_CarAdd(){};
    private static Rental_CarAdd self;
    public static Rental_CarAdd getInstance(){
        if ( self == null ) self = new Rental_CarAdd();
        return self;
    }
    public String owner_name;
    public String owner_phone;

    public void set_RentalCar(){
        System.out.println("차량 등록 서비스입니다");
        Rental_CarAdd newCar = new Rental_CarAdd();
        newCar.car_number = programInfo.textIO("차량 번호");
        newCar.owner_name = programInfo.textIO("차량 소유자 성함");
        newCar.owner_phone = programInfo.textIO("소유자 휴대폰 번호");
        newCar.car_title = programInfo.textIO("차량 모델명");
        System.out.println("차종은 승용/SUV/승합(11인승이상) 가능합니다");
        newCar.car_type = programInfo.textIO("차종 입력");
        newCar.car_mnfct = programInfo.textIO("제조사");
        newCar.car_fuel = programInfo.textIO("연료 타입");
        new RentCarDAO(newCar);
    }
}
