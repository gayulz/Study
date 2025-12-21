package controller;

import changeFrame.*;
import javax.swing.*;


public class Context  {
    private mainSettingInf currentState;
    private JFrame frame;
    private static JButton actionBtn;
    public Context(mainSettingInf ini, JFrame frame){
        this.currentState = ini;
        this.frame = frame;
    }

    public void setSate(mainSettingInf state){
        this.currentState = state;
    }

    public void request(){
        frame.getContentPane().removeAll();
        currentState.transferActions(frame, this);
    }

    public static void setActionBtn(JButton transferBtn) {
        actionBtn = transferBtn;
//        actionBtn.removeActionListener(actionBtn.getAction());
    }
}