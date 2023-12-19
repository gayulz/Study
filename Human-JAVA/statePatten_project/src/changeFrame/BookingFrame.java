package changeFrame;

import controller.Context;
import dto.CustomerDTO;
import dto.RoomInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookingFrame implements mainSettingInf, ActionListener {
    // 싱글톤 구간
    private BookingFrame(){}
    private static class holderInstance{
        public static final BookingFrame INSTANCE = new BookingFrame(); }
    public static BookingFrame getInstance() {return holderInstance.INSTANCE;}

    // 멤버변수 선언부
    private JFrame frames;
    private Context contexts;
    private final JPanel background = mainSettingInf.getMainImg();
    private static JComboBox payCombo;
    private static JTextField nameIn, phoneIn;
    private static JPasswordField passIn;
    private JPanel eastPan;
    private JPanel westPan;
    private JLabel customerInfo, name, phone, pass, payment, selectRoomInfo;
    private JTextArea bookingRoomInfo;
    private JButton backBtn;
    private JButton summitBtn;

    private CustomerDTO customer;

    // 오버라이드
    @Override
    public void transferActions(JFrame frame, Context context) {
        frame.getContentPane().add(background, BorderLayout.CENTER);
        this.frames = frame;
        this.contexts = context;
        westPanelSetting();
        EastPanelSetting();
        addButtons();
        addListeners();
        frame.revalidate();
        frame.repaint();
    }

    // 리스너 클래스로 전달
    @Override
    public void actionPerformed(ActionEvent e) {
        customer = CustomerDTO.getInstance();
        customer.setCustomerName(nameIn.getText());
        customer.setCustomerPhone(phoneIn.getText());
        customer.setPassword(passIn.getText());
        customer.setPaymentInfo(payCombo.getSelectedItem().toString());
        if (e.getSource() instanceof JButton)
            handler.handleButtonEvent((JButton) e.getSource(), frames, contexts);
    }

    // 버튼 등록 메서드
    private void addButtons() {
        summitBtn = iBtn.rightImgButton("booking");
        backBtn = iBtn.leftImgButton("back");
        background.add(summitBtn);
        background.add(backBtn);
    }

    // 리스너 등록
    private void addListeners() {
        nameIn.addActionListener(this);
        phoneIn.addActionListener(this);
        passIn.addActionListener(this);
        payCombo.addActionListener(this);
        backBtn.addActionListener(this);
        summitBtn.addActionListener(this);
    }

    // East Penel 등록
    private void EastPanelSetting() {
        eastPan = new JPanel();
        selectRoomInfo = tool.titleLabel("선택 숙소정보");
        background.add(eastPan);
        background.add(selectRoomInfo);
        selectRoomInfo.setBounds(370, 280, 200, 100);
        eastPan.setBounds(350, 400, 400, 470);
        bookingRoomInfo = new JTextArea(30, 25);
        bookingRoomInfo.setFont(tool.getPlainfont(16));
        bookingRoomInfo.setLineWrap(true); // 자동 줄바꿈 설정
        bookingRoomInfo.setEditable(false); // 읽기모드
        JTextAreaPrint();
        eastPan.add(bookingRoomInfo, "Center");
        eastPan.setBackground(new Color(255, 0, 0, 0));
    }

    // 숙소 정보 출력 기능 메서드
    private void JTextAreaPrint() {
        Funtions fn = Funtions.getInstance();
        List<RoomInfo> userNeedsRooms = RoomViewFrame.getUserNeedsRooms();
        String roomInfoText = String.valueOf(fn.printLodgingInfo(userNeedsRooms));
        bookingRoomInfo.setText(roomInfoText);
    }

    // west Panel 등록
    private void westPanelSetting() {
        westPan = new JPanel();
        westPan.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 20));
        customerInfo = tool.titleLabel("예약 정보 등록");
        name = tool.settingLabel("예약자 성함");
        phone = tool.settingLabel("예약자 연락처");
        pass = tool.settingLabel("예약 비밀번호");
        payment = tool.settingLabel("결제 선택");
        payCombo = tool.settingCombo();
        payCombo.setOpaque(true);
        nameIn = tool.settingFiled(13);
        phoneIn = tool.settingFiled(13);
        passIn = tool.setPasswordField(13);
        westPan.add(name);
        westPan.add(nameIn);
        westPan.add(phone);
        westPan.add(phoneIn);
        westPan.add(pass);
        westPan.add(passIn);
        westPan.add(payment);
        westPan.add(payCombo);
        background.add(customerInfo);
        background.add(westPan);
        customerInfo.setBounds(75, 280, 150, 100);
        westPan.setBounds(75, 400, 250, 470);
        westPan.setBackground(new Color(255, 0, 0, 0));
    }

    // getter
    public JButton getBackBtn() {return backBtn;}
    public JButton getSummitBtn() {return summitBtn;}
    public CustomerDTO getCustomer() { return customer; }
}
