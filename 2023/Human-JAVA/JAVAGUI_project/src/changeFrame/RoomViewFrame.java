package changeFrame;

import controller.Context;
import dao.SendSearchDAO;
import dto.RoomInfo;
import dto.UserNeedsRoomSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RoomViewFrame implements mainSettingInf , ActionListener {
    // 싱글톤 구간
    private RoomViewFrame(){}
    private static class holderInstance{ public static final RoomViewFrame INSTANCE = new RoomViewFrame();}
    public static RoomViewFrame getInstance(){return holderInstance.INSTANCE;}


    // 멤버변수
    private static List<RoomInfo> userNeedsRooms;
    private static JList<String> localList;
    private static Image typeImage = null;
    private JFrame frames;
    private Context contexts;
    private RoomInfo choiceRoomInfo;
    private JTextArea roomInfo;
    private static UserNeedsRoomSearch sendObject;
    private final JPanel background = mainSettingInf.getMainImg();
    private JButton bookingBtn;
    private JButton backBtn;
    private int findRoomNumber;
    private String typeStr;


    // 오버라이드 구간
    @Override
    public void transferActions(JFrame frame, Context context) {
        frame.getContentPane().add(background, BorderLayout.CENTER);
        this.frames = frame;
        this.contexts = context;
        if (sendObject == null) sendObject = SearchFrame.getSendObject();
        userNeedsRooms = SendSearchDAO.getInstance().searchRoom(sendObject);
        // 상단 List 생성 및 등록
        addList();
        // 하단 텍스트구간 생성 및 등록
        addTextArea();
        // 하단 버튼 생성 및 등록
        addBtns();
        // JList 리스너 개별 등록
        JListActionListener();
        // 다시그리기 설정
        frame.revalidate();
        frame.repaint();
    }

    // 리스너 구간
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) handler.handleButtonEvent((JButton) e.getSource(),frames,contexts);
    }

    // JList 에 목록 클릭 리스너
    public void JListActionListener() {
        localList.addListSelectionListener(e -> {
            String tmp = localList.getSelectedValue();
            if (tmp.contains("캠핑")) typeStr = "캠핑";
            else if (tmp.contains("펜션")) typeStr = "펜션";
            else if (tmp.contains("호텔")) typeStr = "호텔";
            String roomNumberSubstring = tmp.substring((tmp.indexOf("방번호")) + "방번호".length());
            findRoomNumber = Integer.parseInt(roomNumberSubstring.replaceAll("[^0-9]", ""));
            JTextAreaPrint();
            photoPrint(typeStr);
        });
    }

    // 리스너에서 호출함 / 업종별 사진 출력
    private void photoPrint(String type) {
        if (type.equals("캠핑")) typeImage = img.lodgingTypeImg("camping").getImage();
        else if (type.equals("펜션")) typeImage = img.lodgingTypeImg("penstion").getImage();
        else if (type.equals("호텔")) typeImage = img.lodgingTypeImg("hotel").getImage();
        JPanel typeImgPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (typeImage != null) {
                    g.drawImage(typeImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        background.add(typeImgPanel);
        typeImgPanel.setBounds(420, 530, 310, 370);
    }

    // JList 클릭 리스너를 통한 JTextArea로 해당 업체의 정보 출력 메서드
    private void JTextAreaPrint() {
        Funtions fn = Funtions.getInstance();
        StringBuilder roomInfoText = fn.printLodgingInfo(userNeedsRooms);
        roomInfo.setText(roomInfoText.toString());
    }

    // 하단 이미지 버튼 생성 및 등록
    private void addBtns() {
        bookingBtn = iBtn.rightImgButton("booking");
        backBtn = iBtn.leftImgButton("back");
        background.add(bookingBtn);
        background.add(backBtn);
        bookingBtn.addActionListener(this);
        backBtn.addActionListener(this);
    }

    // TextArea 배치
    private void addTextArea() {
        this.roomInfo = new JTextArea(20, 40);
        roomInfo.setFont(tool.getPlainfont(16));
        roomInfo.setLineWrap(true); // 자동 줄바꿈 설정
        roomInfo.setEditable(false); // 읽기모드
        roomInfo.setBounds(70, 530, 350, 370);
        background.add(roomInfo);
    }

    // 상단 리스트 등록메서드
    private void addList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (RoomInfo tmp : userNeedsRooms) {
            listModel.addElement("⥤ ⥤\t\t숙소명 :  " + tmp.getLodgingName()
                    + "\t✔ 방번호 : " + tmp.getRoomNumber() + "\t✔ " + tmp.getRoomName());
        }
        localList = new JList<>(listModel);
        localList.setFont(tool.getPlainfont(16));
        localList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(localList);
        background.add(scrollPane);
        scrollPane.setBounds(70, 270, 660, 250);
    }

    // Getter
    public JButton getBookingBtn() {
        return bookingBtn;
    }
    public static UserNeedsRoomSearch getSendObject() { return sendObject;}
    public JButton getBackBtn() {
        return backBtn;
    }
    public RoomInfo getChoiceRoomInfo() { return choiceRoomInfo;}
    public void setChoiceRoomInfo(RoomInfo choiceRoomInfo) { this.choiceRoomInfo = choiceRoomInfo; }
    public int getFindRoomNumber() { return findRoomNumber;}
    public static List<RoomInfo> getUserNeedsRooms() { return userNeedsRooms;}
}
