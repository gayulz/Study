package controller;

import changeFrame.StartFrame;
import changeFrame.mainSettingInf;
import javax.swing.*;

public class RemoteControl {
    public RemoteControl(){
        JFrame remoteFrame = new JFrame("make__yuuri");
        remoteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        remoteFrame.setSize(800, 1220);
        remoteFrame.setLocationRelativeTo(null);
        remoteFrame.setResizable(false);
        mainSettingInf ini = StartFrame.getInstance();
        Context context = new Context(ini, remoteFrame);
        context.request();
        remoteFrame.setVisible(true);
    }
}
