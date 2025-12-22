package changeFrame;

import javax.swing.*;
import java.awt.*;
public class Images {
    // todo : 이미지 버튼 생성하는 클래스
    // 싱글톤
    private Images(){}
    private static class holderInstance{ public static final Images INSTANCE = new Images(); }
    public static Images getInstance(){
        return holderInstance.INSTANCE;
    }

    //업종별 사진 출력 기능 메서드
    ImageIcon lodgingTypeImg(String path){
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/"+ path +".jpg"));
        if (icon != null) return icon;
        else System.err.println("Lodging Type Image not found");
        return null;
    }

    // 왼쪽 버튼 생성 path 에 이미지 이름 입력하면 됨
    JButton leftImgButton(String path){
        JButton tmp = new JButton();
        tmp.setPreferredSize(new Dimension(544, 172));
        tmp.setFocusPainted(false);
        tmp.setBorderPainted(false);
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/image/"+ path +".jpg"));
            if (icon != null) {
                tmp.setIcon(icon);
            } else {
                System.err.println("Left Button Image not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tmp.setBounds(120, 930, 300, 120);
        return tmp;
    }

    // 오른쪽 버튼 생성 path 에 이미지 이름 입력하면 됨
    JButton rightImgButton(String path){
        JButton tmp = new JButton();
        tmp.setPreferredSize(new Dimension(544, 172));
        tmp.setFocusPainted(false);
        tmp.setBorderPainted(false);
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/image/"+ path +".jpg"));
            if (icon != null) tmp.setIcon(icon);
            else System.err.println("Right Button Image not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        tmp.setBounds(420, 930, 300, 120);
        return tmp;
    }
}