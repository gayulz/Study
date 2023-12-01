package changeFrame;

import actions.ActionHandler;
import actions.CheckRoutine;
import controller.Context;

import javax.swing.*;
import java.awt.*;

public interface mainSettingInf {
    Tools tool = Tools.getInstance();
    Images iBtn = Images.getInstance();
    void transferActions(JFrame frame, Context context);
    ActionHandler handler = new ActionHandler();
    Images img = Images.getInstance();
    CheckRoutine check = CheckRoutine.getInstance();

    // 배경화면 가져오기
    static JPanel getMainImg(){
        Image backgroundImage = new ImageIcon("src/image/subBackground.jpg").getImage();
        JPanel background = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, this);
            }
        };
        background.setLayout(null);
        return background;
    }


}
