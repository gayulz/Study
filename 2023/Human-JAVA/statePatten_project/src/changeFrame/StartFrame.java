package changeFrame;

import controller.Context;
import javax.swing.*;
import java.awt.*;

public class StartFrame implements mainSettingInf{
    // 싱글톤
    private StartFrame(){}
    private static class holderInstance{
        public static final StartFrame INSTANCE = new StartFrame();
    }
    public static StartFrame getInstance(){return holderInstance.INSTANCE;}

    // 멤버변수
    JButton searchBtn;

    // 오버라이드 구간
    @Override
    public void transferActions(JFrame frame, Context context) {
        System.out.println("StartFrame");
        JPanel background = getMainImg();
        background.setLayout(new BorderLayout());
        frame.getContentPane().add(background);
        searchBtn = new JButton();
        background.add(searchBtn, BorderLayout.CENTER);
        searchBtn.setOpaque(false);
        searchBtn.setContentAreaFilled(false); // 내용 영역을 채우지 않도록 설정
        searchBtn.setBorderPainted(false);
        frame.revalidate();
        buttonListener(context);
    }

    // 리스너등록
    private void buttonListener(Context context){
        searchBtn.addActionListener(e -> {
            context.setSate(SearchFrame.getInstance());
            context.request();
        });
    }

    // 바탕이미지
    static JPanel getMainImg(){
        Image backgroundImage = new ImageIcon("src/image/mainBackground.gif").getImage();
        JPanel panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, this);
            }
        };
        panel.setLayout(null);
        return panel;
    }
}