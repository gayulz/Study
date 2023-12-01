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
import java.util.List;


public class ActionHandler extends Component {
    // 싱글톤
    public ActionHandler() {
    }

    // 멤버변수
    private final AddReservationDAO referencesAddDao = AddReservationDAO.getInstance();
    private final cancelReservationDAO referencesCancelDao = cancelReservationDAO.getInstance();
    private final CheckRoutine check = CheckRoutine.getInstance();
    private List<customerANDbookingList> reservationList;
    private CustomerDTO customerObject;

    //  버튼 핸들러
    public void handleButtonEvent(JButton source, JFrame frame, Context context) {
        // 숙소검색 버튼 클릭
        // 내 예약 검색 버튼 클릭
        if (source == SearchFrame.getInstance().getSearchBtn())
            SwingUtilities.invokeLater(() -> searchBtnProcess(frame, context));
        else if (source == SearchFrame.getInstance().getMyInfoBtn()) {
            SwingUtilities.invokeLater(() -> {
                context.setSate(LoginFrame.getInstance());
                context.request();
            });
            // booking 버튼 클릭시
        } else if (source == RoomViewFrame.getInstance().getBookingBtn()) {
            SwingUtilities.invokeLater(() -> {
                context.setSate(BookingFrame.getInstance());
                context.request();
            });
            // 예약 완료 버튼 클릭시
        } else if (source == BookingFrame.getInstance().getSummitBtn()) {
            SwingUtilities.invokeLater(() -> {
                check.summitCheckRoutine();
                int bookingNumber = referencesAddDao.reservationNumberReturn();
                System.out.println("예약 번호 : :" + bookingNumber);

                System.out.println("예약번호 : " + bookingNumber);
//                JOptionPane.showMessageDialog(this, "예약번호 : " + bookingNumber + "\n예약 번호를 모르시더라도 예약자정보로 조회가능합니다", "예약완료", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(this,  "예약완료!!!!!!!", "예약완료", JOptionPane.PLAIN_MESSAGE);
                context.setSate(SearchFrame.getInstance());
                context.request();

//                else errorMessagePop();
            });
        }
        // 로그인 버튼 클릭시
        else if (source == LoginFrame.getInstance().getLoginBtn()) {
            SwingUtilities.invokeLater(() -> {
                if (check.loginCheckRoutine()) {
                    customerObject = check.getCustomerObject();
                    reservationList = ReturnCustomerInfo.getInstance().userReservationReturn(customerObject);
                    context.setSate(MyReservationFrame.getInstance());
                    context.request();
                } else noResultPop();
            });
        }
        // 예약 취소 버튼 클릭시
        else if (source == MyReservationFrame.getInstance().getCancelBtn()) {
            SwingUtilities.invokeLater(() -> {

                if (cancelCheckRoutine()) {
                    cancelPop();
                    context.setSate(SearchFrame.getInstance());
                    context.request();
                } else errorMessagePop();
            });
        }
        // back 버튼 클릭시
        else if (source == BookingFrame.getInstance().getBackBtn() ||
                source == RoomViewFrame.getInstance().getBackBtn() ||
                source == MyReservationFrame.getInstance().getBackBtn() ||
                source == LoginFrame.getInstance().getBackBtn()) {
            System.out.println("Back button clicked. Setting state to SearchFrame.");
            backBtnActions(context);
        }
        // 이도 저도 아닐 때
        else System.out.println("No button clicked.");
    }

    // back 버튼 클릭시
    private void backBtnActions(Context context) {
        SwingUtilities.invokeLater(() -> {
            context.setSate(SearchFrame.getInstance());
            context.request();
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

    // 숙소 검색시 버튼 클릭
    private void searchBtnProcess(JFrame frame, Context context) {
        CheckRoutine check = CheckRoutine.getInstance();
        if (check.validateSearchObject()) {
            context.setSate(RoomViewFrame.getInstance());
            context.request();
        } else JOptionPane.showMessageDialog(this, "모든 필드를 입력하세요. ", "오류", JOptionPane.ERROR_MESSAGE);
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
