package rentalInfo;

import java.util.ArrayList;
import DAO.RentContractDAO;
import DTO.Rental_contractDTO;
import DTO.payDTO;

public class Rental_contract extends Rental_contractDTO {
    private static Rental_contract self = null;
    private Rental_contract() {
    }
    public static Rental_contract getInstance() {
        if (self == null) self = new Rental_contract();
        return self;
    }
    public void Rental_contract() {
        RentContractDAO rcDAO = RentContractDAO.getInstance();
        Rental_contract rentTmp = new Rental_contract();
        System.out.println("차량 예약 메뉴 입니다");
        System.out.println("면허종류는 1종대형(승합전용), 1종보통(SUV, 승용), 2종보통(SUV, 승용) 입니다");
        try {
            rentTmp.setLender_licenseType(programInfo.textIO("종류"));
            rcDAO.licenseTpyeCars(rentTmp.getLender_licenseType());
            super.contract_list = rcDAO.getList();
            if (!contract_list.isEmpty()) {
                prt(contract_list);
                rentTmp.setLender_name(programInfo.textIO("계약자 이름"));
                rentTmp.setLender_age(programInfo.textIO("계약자 나이"));
                rentTmp.setLender_phone(programInfo.textIO("계약자 번호"));
                rentTmp.setLender_start(programInfo.textIO("대여 시작시간"));
                rentTmp.setLender_time(Integer.parseInt(programInfo.textIO("대여 시간")));
                rentTmp.setLender_pass(programInfo.textIO("대여자 비밀번호"));
                rentTmp.setCar_number(programInfo.textIO("대여 차량번호"));
                rentTmp.setLender_licenseNum(programInfo.textIO("운전면허 번호"));
                // 총 지불금액 처리 후 대입
                int cost = calc_cost(rcDAO.get_Cost(rentTmp.getCar_number()), rentTmp.getLender_time());
                rentTmp.setTotal_price(cost);
                self = rentTmp;
                rcDAO.setSqlquery_DAO();
//                rcDAO.status_change(rentTmp.getCar_number());
            } else throw new Exception("잘못된 입력입니다");
        } catch (Exception e) {}
    }

    // 차량 조회시 출력문
    public static void prt(ArrayList<payDTO> list) {
        for (payDTO m : list) {
            System.out.println("차량 번호 :" + m.car_number);
            System.out.println("차량 모델 :" + m.car_title);
            System.out.println("차량 제조사 :" + m.car_mnfct);
            System.out.println("차량 연료 :" + m.car_fuel);
            System.out.println("하루 요금 :" + m.getDay_price());
            System.out.println("초과 요금 :" + m.getOver_price());
        }
    }
    // 총 비용 계산 메서드
    public int calc_cost(payDTO payTable, int time){
        int result_cost = 0;
        try {
            int day_cost = payTable.getDay_price();
            int over_cost = payTable.getOver_price();
            int tmpTime = time - 24;
            if (tmpTime <= 0) return result_cost = day_cost;
            else if (tmpTime >= 0 && tmpTime <= 24) return result_cost = day_cost + (over_cost * tmpTime);
            else if (tmpTime >= 24 && tmpTime <= 48) return result_cost = (day_cost * 2) + ((tmpTime - 24) * over_cost);
            else throw new Exception("계산되지 않는 시간입니다 관리자에게 문의하세요");
        } catch (Exception e){}
        return result_cost;
    }
}
