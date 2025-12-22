package changeFrame;

import javax.swing.*;
import java.awt.*;

public class Tools {
    private final String[] localList = {"서울특별시", "경기도", "강원도", "제주도"};

    // 싱글톤
    private Tools(){}
    private static class holderInstance{
        public static final Tools INSTANCE = new Tools();
    }
    public static Tools getInstance(){return holderInstance.INSTANCE;}


    // 폰트 설정 메서드
    private Font getBOLDfont(int size){
        return new Font("SUITE-ExtraBold", Font.BOLD, size);
    }
    Font getPlainfont(int size){
        return new Font("SUITE-ExtraBold", Font.PLAIN, size);
    }

    // 기능 메서드
    // 체크박스 생성
    JCheckBox getCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(getBOLDfont(35));
        return checkBox;
    }
    // 라벨추가
    JLabel createLabel(String text) {
        JLabel tmpLabel = new JLabel(text);
        tmpLabel.setFont(getBOLDfont(30));
        return tmpLabel;
    }

    // 지역 선택
    JComboBox addLocalCombo() {
        JComboBox tmpCombo = new JComboBox<>(localList);
        tmpCombo.setFont(getPlainfont(22));
        tmpCombo.setSize(new Dimension(200,150));
        return tmpCombo;
    }

    public JLabel settingLabel(String text){
        JLabel tmp = new JLabel(text);
        tmp.setFont(getPlainfont(18));
        return tmp;
    }

    public JLabel titleLabel(String text){
        JLabel tmp = new JLabel(text);
        tmp.setFont(getPlainfont(25));
        tmp.setSize(200,110);
        return tmp;
    }

    public JTextField settingFiled(int col){
        JTextField tmp = new JTextField(col);
        tmp.setFont(getPlainfont(20));
        tmp.setSize(200, 150);
        return tmp;
    }

    public JPasswordField setPasswordField(int col){
        JPasswordField tmp = new JPasswordField(col);
        tmp.setFont(getPlainfont(20));
        tmp.setSize(200, 150);
        return tmp;
    }

    public JComboBox settingCombo(){
        String[] payList = { "카드", "무통장입금", "모바일페이 "};
        JComboBox<String> tmp = new JComboBox<>(payList);
        tmp.setPreferredSize(new Dimension(230,30));
        tmp.setFont(getPlainfont(20));
        return tmp;
    }
}
