package changeFrame;

import controller.Context;
import dto.customerANDbookingList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MyReservationFrame implements mainSettingInf, ActionListener {

    // 싱글톤 선언
    private MyReservationFrame(){}
    private static class holderInstance{
        public static final MyReservationFrame INSTANCE = new MyReservationFrame();}
    public static MyReservationFrame getInstance(){ return holderInstance.INSTANCE;}

    // 매개변수 선언
    private JFrame frames;
    private Context contexts;
    private final JPanel background = mainSettingInf.getMainImg();
    private List<customerANDbookingList> reservationList;
    private JList<String> reservations;
    private JTextArea infomation;
    private JButton backBtn, cancelBtn;
    private String typeStr;
    private int findBookingNumber;
    private customerANDbookingList customer;
    private Image typeImage;

    // 오버라이드 선언
    @Override
    public void transferActions(JFrame frame, Context context) {
        frame.getContentPane().add(background, BorderLayout.CENTER);
        reservationList = handler.getReservationList();
        this.frames = frame;
        this.contexts = context;
        // 버튼 등록
        addJbutton();
        // 상단 리스트 등록
        addReservationList();
        // 하단 정보 등록
        addInfomationsPanel();
        // 리스너 등록
        JListActionListener();
        cancelBtn.addActionListener(this);
        backBtn.addActionListener(this);
        frame.revalidate();
        frame.repaint();
    }

    // 리스너 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();
            handler.handleButtonEvent(source, frames, contexts);
        }
    }

    // 리스트 리스너 등록
    private void JListActionListener() {
        reservations.addListSelectionListener(e -> {
            String tmp = reservations.getSelectedValue();
            if (tmp.contains("캠핑")) typeStr = "캠핑";
            else if (tmp.contains("펜션")) typeStr = "펜션";
            else if (tmp.contains("호텔")) typeStr = "호텔";
            String subTemp = tmp.substring(tmp.indexOf("BOOKING NUMBER") + "BOOKING NUMBER".length());
            findBookingNumber = Integer.parseInt(subTemp.replaceAll("[^0-9]", ""));
            JTextAreaPrint();
            addPhotoPanel(typeStr);
        });
    }

    // JList 클릭 리스너를 통한 JTextArea로 해당 업체의 정보 출력 메서드
    private void JTextAreaPrint() {
        StringBuilder roomInfoText = new StringBuilder("--------------------------------------\n\n");
        for (customerANDbookingList tmps : reservationList) {
            if ( tmps.getBookingNumber() == findBookingNumber) {
                customer = tmps;
                roomInfoText.append(" 숙소 이름 : ").append(tmps.getLodgingName()).append("\n");
                roomInfoText.append(" 숙소 주소 : ").append(tmps.getLodgingAddr()).append("\n");
                roomInfoText.append(" 숙소 전화 : ").append(tmps.getLodgingTel()).append("\n");
                roomInfoText.append(" 예약 번호 : ").append(tmps.getBookingNumber()).append("\n");
                roomInfoText.append(" 총 금액  : ").append(tmps.getPriceTotal()).append(" 원 \n");
                roomInfoText.append(" 총 숙박일 : ").append(tmps.getReservationDay()).append(" 일\n");
                roomInfoText.append(" 체크인 : ").append(tmps.getCheckIn()).append("\n");
                roomInfoText.append(" 체크아웃 : ").append(tmps.getCheckOut()).append("\n");
                roomInfoText.append("--------------------------------------\n\n");
                roomInfoText.append(" ✔ 입실 : 13시    ✔ 퇴실 : 12시\n");
                roomInfoText.append(" 1. 반려 동물들의 배변패드는 직접 준비하셔야 합니다 \n");
                roomInfoText.append(" 2. 반려견이 대형견 일 경우 미리 프론트에 알려주세요 \n");
                roomInfoText.append(" 3. 예약 취소시 수수료는 없습니다\n\n");
                roomInfoText.append("--------------------------------------");
                break;
            }
        }
        infomation.setText(roomInfoText.toString());
    }

    // 하단 사진 정보 판넬 등록
    private void addPhotoPanel(String type){
        Images img = Images.getInstance();
        switch (type) {
            case "캠핑":
                typeImage = img.lodgingTypeImg("camping").getImage();
                break;
            case "펜션":
                typeImage = img.lodgingTypeImg("penstion").getImage();
                break;
            case "호텔":
                typeImage = img.lodgingTypeImg("hotel").getImage();
                break;
        }
        JPanel typeImgPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (typeImage != null) { g.drawImage(typeImage, 0, 0, getWidth(), getHeight(), this); }
            }
        };
        background.add(typeImgPanel);
        typeImgPanel.setBounds(460, 480, 240, 350);
    }

    // 하단 정보 등록
    private void addInfomationsPanel() {
        this.infomation = new JTextArea(20, 40);
        infomation.setFont(tool.getPlainfont(16));
        infomation.setLineWrap(true); // 자동 줄바꿈 설정
        infomation.setEditable(false); // 읽기모드
        infomation.setBounds(100, 480, 350, 350);
        background.add(infomation);
    }

    // 상단 리스트 등록
    private void addReservationList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (customerANDbookingList tmp : reservationList) listModel.addElement("\t\t ⌦ LODGING NAME : " + tmp.getLodgingName() + "\t\t ⌦ BOOKING NUMBER : " + tmp.getBookingNumber());
        reservations = new JList<>(listModel);
        reservations.setFont(tool.getPlainfont(16));
        reservations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(reservations);
        background.add(scrollPane);
        scrollPane.setBounds(100,300,600,200);
    }

    // 버튼 등록
    private void addJbutton() {
        backBtn = iBtn.leftImgButton("back");
        cancelBtn = iBtn.rightImgButton("cancel");
        background.add(backBtn);
        background.add(cancelBtn);
    }

    // getter
    public JButton getBackBtn() { return backBtn;}
    public JButton getCancelBtn() {return cancelBtn;}
    public customerANDbookingList getCustomer() { return customer;}
}
