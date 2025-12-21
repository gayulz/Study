package rentalInfo;

import DAO.RentSuccessDAO;
import DTO.Rental_Car;

import java.util.ArrayList;

public class Rental_Success extends Rental_Car {
    // todo : 렌트 계약이 완료된 목록을 보여주는 클래스
    private Rental_Success() {}
    private static Rental_Success self = null;

    public static Rental_Success getinstance() {
        if (self == null) self = new Rental_Success();
        return self;
    }

    public void get_SuccessRental() {
        System.out.println("예약 완료된 차량 리스트 메뉴입니다");
        RentSuccessDAO rsd = RentSuccessDAO.getInstance();
        rsd.setSqlquery_DAO();
        ArrayList<DTO.Rental_Success> list = rsd.getList();
        try {
            if (list.size() != 0) rental_default_prt(list);
            else throw new Exception();
        } catch (Exception e) {
            System.out.println("확인되는 차량이 없습니다");
        }
    }

    public void rental_default_prt(ArrayList<DTO.Rental_Success> list) {
        for (DTO.Rental_Success tmp : list) {
            System.out.println("차량번호\t: " + tmp.getCar_number());
            System.out.println("계약자이름\t : " + tmp.getLender_name());
            System.out.println("대여시작시간\t : " + tmp.getLender_start());
            System.out.println("대여종료시간\t : " + tmp.getLender_end());
        }
    }

}
