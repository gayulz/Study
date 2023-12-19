package changeFrame;

import controller.Context;
import dto.UserNeedsRoomSearch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class SearchFrame implements mainSettingInf, ActionListener {
    // 싱글톤 구간
    private SearchFrame(){}

    private static class holderInstance{
        public static final SearchFrame INSTANCE = new SearchFrame();
    }
    public static SearchFrame getInstance(){
        return holderInstance.INSTANCE;
    }

    // 멤버변수
    private static UserNeedsRoomSearch sendObject;
    private JPanel checkInCalendar;
    private JPanel checkOutCalendar;
    private JComboBox localComboBox;
    private JLabel localLabel, checkInLabel, checkOutLabel;
    private JButton myInfoBtn, searchBtn;
    private JCheckBox camping, pention, hotel;
    private JFrame frames;
    private Context contexts;
    private final JPanel background = mainSettingInf.getMainImg();


    // 오버라이드 구간
    @Override
    public void transferActions(JFrame frame, Context context) {
        frame.getContentPane().add(background,BorderLayout.CENTER);
        this.frames = frame;
        this.contexts = context;
        System.out.println("SearchFrame");
        // 체크박스 생성
        addJCheckBoxs();
        // 라벨 생성
        addLabels();
        // 콤보박스 생성
        addLocalCombo();
        // 날짜 선택 캘린더 생성
        addCalendars();
        // 내예약버튼 & 숙소검색 버튼 생성
        addButtons();
        // 모든 자원 등록
        addAllThings();
        // 액션 리스너 등록
        addListeners();
        frame.revalidate();
        frame.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JCheckBox ) { handleCheckBoxEvent((JCheckBox) e.getSource());}
        else if (e.getSource() instanceof JComboBox) {handleComboBoxEvent((JComboBox<?>) e.getSource());}
        else if (e.getSource() instanceof JButton) {
            System.out.println("SearchFrame : 핸들러 클래스로 이동");
            handler.handleButtonEvent((JButton) e.getSource(), frames, contexts);
        }
    }

    // SearchFrame -> 체크박스 핸들러
    void handleCheckBoxEvent(JCheckBox checkBox) {
        JCheckBox camping = SearchFrame.getInstance().getCamping();
        JCheckBox pention = SearchFrame.getInstance().getPention();
        JCheckBox hotel = SearchFrame.getInstance().getHotel();
        sendObject = SearchFrame.getSendObject();
        if (checkBox.isSelected()) {
            // 1개만 체크가능하도록 진행함
            camping.setSelected(checkBox == camping);
            pention.setSelected(checkBox == pention);
            hotel.setSelected(checkBox == hotel);
        }
        if (camping.isSelected()) sendObject.setLodgingType("캠핑");
        if (pention.isSelected()) sendObject.setLodgingType("펜션");
        if (hotel.isSelected()) sendObject.setLodgingType("호텔");
    }

    // SearchFrame -> 콤보박스 핸들러
    void handleComboBoxEvent(JComboBox<?> comboBox) {
        sendObject = SearchFrame.getSendObject();
        // 선택된 텍스트를 Object로 대입
        sendObject.setLodgingAddr(Objects.requireNonNull(comboBox.getSelectedItem()).toString());
    }

    // 모든 자원 등록
    private void addAllThings() {
        background.add(searchBtn);
        background.add(myInfoBtn);
        background.add(camping);
        background.add(pention);
        background.add(hotel);
        background.add(localComboBox);
        background.add(localLabel);
        background.add(checkInLabel);
        background.add(checkOutLabel);
        background.add(checkInCalendar);
        background.add(checkOutCalendar);
    }

    // 리스너 등록
    private void addListeners() {
        camping.addActionListener(this);
        pention.addActionListener(this);
        hotel.addActionListener(this);
        localComboBox.addActionListener(this);
        myInfoBtn.addActionListener(this);
        searchBtn.addActionListener(this);
    }

    // 이미지 버튼 생성
    private void addButtons() {
        searchBtn = iBtn.rightImgButton("search");
        myInfoBtn = iBtn.leftImgButton("my");
        background.add(searchBtn);
        background.add(myInfoBtn);
    }

    // 캘린더 등록
    private void addCalendars() {
        checkInCalendar = new JPanel();
        checkOutCalendar = new JPanel();
        checkInCalendar.setBounds(230,470,350,200);
        checkInCalendar.setBackground(new Color(255,0,0,0));
        checkOutCalendar.setBounds(230,730,350,200);
        checkOutCalendar.setBackground(new Color(255,0,0,0));
        SwingCalendar checkIn = new SwingCalendar("checkIndate");
        SwingCalendar checkOut = new SwingCalendar("checkOutdate");
        checkInCalendar.add(checkIn);
        checkOutCalendar.add(checkOut);
        background.add(checkInCalendar);
        background.add(checkOutCalendar);
    }

    // 콤보박스 추가 메서드
    private void addLocalCombo() {
        localComboBox = tool.addLocalCombo();
        localComboBox.setBounds(290, 330, 250, 150);
        background.add(localComboBox);
    }

    // 라벨 추가 메서드
    private void addLabels() {
        localLabel = tool.createLabel("지역 선택");
        checkInLabel = tool.createLabel("체크인 날짜");
        checkOutLabel = tool.createLabel("체크아웃 날짜");
        localLabel.setBounds(350, 300, 170, 100);
        checkInLabel.setBounds( 330, 400, 170, 100);
        checkOutLabel.setBounds(330, 660, 170, 100);
        background.add(localLabel);
        background.add(checkInLabel);
        background.add(checkOutLabel);
    }

    // 체크박스 추가 메서드
    private void addJCheckBoxs() {
        camping = tool.getCheckBox("캠핑");
        pention = tool.getCheckBox("펜션");
        hotel = tool.getCheckBox("호텔");
        camping.setBounds(190, 220, 150, 120);
        pention.setBounds(360, 220, 150, 120);
        hotel.setBounds(520, 220, 150, 120);
        background.add(camping);
        background.add(pention);
        background.add(hotel);
    }


    //getter, setter
    public static UserNeedsRoomSearch getSendObject() {
        if (sendObject == null) sendObject = UserNeedsRoomSearch.getInstance();
        return sendObject;
    }
    public static void setSendObject(UserNeedsRoomSearch send){
        sendObject = send;
    }
    public JButton getMyInfoBtn() {
        return myInfoBtn;
    }
    public JButton getSearchBtn() {
        return searchBtn;
    }
    public JCheckBox getCamping() {
        return camping;
    }
    public JCheckBox getPention() {
        return pention;
    }
    public JCheckBox getHotel() {
        return hotel;
    }
}
