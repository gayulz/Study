package actions;

import changeFrame.BookingFrame;
import changeFrame.LoginFrame;
import changeFrame.RoomViewFrame;
import changeFrame.SearchFrame;
import dao.AddReservationDAO;
import dao.ReturnCustomerInfo;
import dto.CustomerDTO;
import dto.RoomInfo;
import dto.UserNeedsRoomSearch;

public class CheckRoutine {
    // 싱글톤 선언
    private CheckRoutine(){}
    private static class holderInstance{
        public static final CheckRoutine INSTANCE = new CheckRoutine();}
    public static CheckRoutine getInstance(){ return holderInstance.INSTANCE;}

    public CustomerDTO getCustomerObject() {
        return customerObject;
    }

    private CustomerDTO customerObject;
    // 희망 숙소 검색시 모든 필드에 데이터가 입력되었는지 확인 후 리턴
    boolean validateSearchObject() {
        UserNeedsRoomSearch userNeedsRoomSearch = SearchFrame.getSendObject();
        return userNeedsRoomSearch.getLodgingAddr() != null &&
                userNeedsRoomSearch.getLodgingType() != null &&
                userNeedsRoomSearch.getCheckIn() != null &&
                userNeedsRoomSearch.getCheckOut() != null && userNeedsRoomSearch.getLodgingType() != null;
    }

    // 예약 등록시 체크
    void summitCheckRoutine(){
        RoomInfo choiceRoom = RoomViewFrame.getInstance().getChoiceRoomInfo();
        CustomerDTO customer = BookingFrame.getInstance().getCustomer();
        UserNeedsRoomSearch searchData = RoomViewFrame.getSendObject();
        customer.setRoomNumber(choiceRoom.getRoomNumber());
        customer.setCheckIn(searchData.getCheckIn());
        customer.setCheckOut(searchData.getCheckOut());
        AddReservationDAO dao = AddReservationDAO.getInstance();
        dao.addReservation(customer);
    }


    // 로그인 시 확인절차
    boolean loginCheckRoutine(){
        ReturnCustomerInfo returnDao = ReturnCustomerInfo.getInstance();
        LoginFrame login = LoginFrame.getInstance();
        customerObject = CustomerDTO.getInstance();
        customerObject.setCustomerName(login.getCustomerName().getText());
        customerObject.setCustomerPhone(login.getCustomerPhone().getText());
        customerObject.setPassword(login.getCustomerPass().getText());
        return returnDao.isUserInfo(customerObject);
    }


}
