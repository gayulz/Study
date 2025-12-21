package actions;

import changeFrame.*;
import controller.Context;
import dao.AddReservationDAO;
import dao.cancelReservationDAO;
import dao.ReturnCustomerInfo;
import dto.CustomerDTO;
import dto.customerANDbookingList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


public class ActionHandler extends Component {
    private java.awt.event.ActionListener ActionListener;

    public ActionHandler() {}

    // 멤버변수
    private final AddReservationDAO referencesAddDao = AddReservationDAO.getInstance();
    private final cancelReservationDAO referencesCancelDao = cancelReservationDAO.getInstance();
    private final CheckRoutine check = CheckRoutine.getInstance();
    private List<customerANDbookingList> reservationList;
    private CustomerDTO customerObject;
    private JFrame tempFrame;
    private Context tempContext;
    private JButton tempBtn;

    //  버튼 핸들러
    public void handleButtonEvent(JButton source, JFrame frame, Context context) {
        System.out.println("핸들러 클래스로 진입완료");
        // 멤버변수로 주소 복사
        tempContext = context;
        tempFrame = frame;
        // 진입된 버튼에 대한 리스너를 초기화 하기 위함으로 Context 클래스로 해당 버튼의 주소를 넘겨준다
        tempBtn = source;

        // 숙소검색 버튼 클릭
        if (tempBtn == SearchFrame.getInstance().getSearchBtn()) searchBtnProcess();
        // 내 예약 검색 버튼 클릭
        else if (tempBtn == SearchFrame.getInstance().getMyInfoBtn()) myInfoBtnProcess();
        // booking 버튼 클릭시
        else if (tempBtn == RoomViewFrame.getInstance().getBookingBtn()) bookingBtnProcess();
        // 예약 완료 버튼 클릭시
        else if (tempBtn == BookingFrame.getInstance().getSummitBtn()) summitBtnProcess();
        // 로그인 버튼 클릭시
        else if (tempBtn == LoginFrame.getInstance().getLoginBtn()) loginBtnProcess();
        // 예약 취소 버튼 클릭시
        else if (tempBtn == MyReservationFrame.getInstance().getCancelBtn())cancelBtnProcess();
        // 모든 버튼이 아닐 때
        else backBtnProcess();
    }

    // 핸들러 통한 프로세스 처리 메서드
    // Search Frame에 숙소 검색 버튼 처리로직
    private void searchBtnProcess() {
        CheckRoutine check = CheckRoutine.getInstance();
        if (check.validateSearchObject()) {
            tempContext.setSate(RoomViewFrame.getInstance());
            tempContext.request();
        } else JOptionPane.showMessageDialog(this, "모든 필드를 입력하세요. ", "오류", JOptionPane.ERROR_MESSAGE);
    }

    // Search Frame에 내예약조회 버튼 처리로직
    public void myInfoBtnProcess(){
        tempBtn.removeActionListener(tempBtn.getAction());
        tempContext.setSate(LoginFrame.getInstance());
        tempContext.request();
    }

    // booking Frame에 예약하기 버튼 처리로직
    public void bookingBtnProcess(){
        tempBtn.removeActionListener(tempBtn.getAction());
        tempContext.setSate(BookingFrame.getInstance());
        tempContext.request();
    }

    // booking Frame에 예약완료 버튼 처리로직
    public void summitBtnProcess(){
        tempBtn.removeActionListener(tempBtn.getAction());
        SwingUtilities.invokeLater(() -> {
            check.summitCheckRoutine();
            int bookingNumber = referencesAddDao.reservationNumberReturn();
            System.out.println("예약 번호 : :" + bookingNumber);

            System.out.println("예약번호 : " + bookingNumber);
//                JOptionPane.showMessageDialog(this, "예약번호 : " + bookingNumber + "\n예약 번호를 모르시더라도 예약자정보로 조회가능합니다", "예약완료", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(this,  "예약완료!!!!!!!", "예약완료", JOptionPane.PLAIN_MESSAGE);
            tempContext.setSate(SearchFrame.getInstance());
            tempContext.request();

//                else errorMessagePop();
        });
    }

    // Login Frame에 로그인 버튼 처리로직
    public void loginBtnProcess(){
        tempBtn.removeActionListener(tempBtn.getAction());
        SwingUtilities.invokeLater(() -> {
            if (check.loginCheckRoutine()) {
                customerObject = check.getCustomerObject();
                reservationList = ReturnCustomerInfo.getInstance().userReservationReturn(customerObject);
                tempContext.setSate(MyReservationFrame.getInstance());
                tempContext.request();
            } else noResultPop();
        });
    }

    // MyReservation Frame에 예약 취소 버튼 처리로직
    public void cancelBtnProcess(){
        tempBtn.removeActionListener(tempBtn.getAction());

        SwingUtilities.invokeLater(() -> {
            if (cancelCheckRoutine()) {
                cancelPop();
                tempContext.setSate(SearchFrame.getInstance());
                tempContext.request();
            } else errorMessagePop();
        });
    }

    // 모든 프레임에 back btn 버튼 처리로직
    public void backBtnProcess(){
        tempBtn.removeActionListener(tempBtn.getAction());

        SwingUtilities.invokeLater(() -> {
            tempContext.setSate(SearchFrame.getInstance());
            tempContext.request();
        });
    }

    // 조회되는 정보 없음 팝업
    private void noResultPop() {
        JOptionPane.showMessageDialog(this, "조회되는 정보가 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
    }

    // 에러  팝업
    private void errorMessagePop() {
        JOptionPane.showMessageDialog(this, "오류입니다\n관리자에게 문의하세요", "오류", JOptionPane.ERROR_MESSAGE);
    }

    // 예약 취소 팝업
    private void cancelPop() {
        JOptionPane.showMessageDialog(this, "예약이 취소되었습니다", "예약취소", JOptionPane.PLAIN_MESSAGE);
    }



    // 예약 취소 완료 절차
    private boolean cancelCheckRoutine() {
        customerANDbookingList customer = MyReservationFrame.getInstance().getCustomer();
        return referencesCancelDao.deleteUserReservation(customer);
    }

    // Getter
    public List<customerANDbookingList> getReservationList() {
        return reservationList;
    }

}
