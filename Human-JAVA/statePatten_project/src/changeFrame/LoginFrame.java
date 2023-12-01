package changeFrame;

import controller.Context;
import dto.CustomerDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame implements mainSettingInf, ActionListener {
    // 싱글톤 구간
    private LoginFrame(){}
    private static class holderInstance{ public static final LoginFrame INSTANCE = new LoginFrame();}
    public static LoginFrame getInstance(){ return holderInstance.INSTANCE;}

    // 멤버변수
    private JFrame frames;
    private Context contexts;
    private final JPanel background = mainSettingInf.getMainImg();
    private JPanel loginPanel;
    private JButton backBtn, loginBtn;
    private JTextField customerName, customerPhone;
    private JPasswordField customerPass;

    @Override
    public void transferActions(JFrame frame, Context context) {
        frame.getContentPane().add(background, BorderLayout.CENTER);
        this.frames = frame;
        this.contexts = context;
        System.out.println("LoginFrame");
        // 로그인 판넬 등록
        addLoginPanel();
        // 버튼 등록
        addButton();
        // 라벨 & 텍스트 필드 등록
        addTools();
        // 리스너등록
        addLiteners();
        frame.revalidate();
        frame.repaint();
    }

    // 리스너 등록
    private void addLiteners() {
        customerName.addActionListener(this);
        customerPhone.addActionListener(this);
        customerPass.addActionListener(this);
        backBtn.addActionListener(this);
        loginBtn.addActionListener(this);
    }

    // 리스너 클래스에 전달
    @Override
    public void actionPerformed(ActionEvent e) {
        CustomerDTO customer = CustomerDTO.getInstance();
        customer.setCustomerName(customerName.getText());
        customer.setCustomerPhone(customerPhone.getText());
        customer.setPassword(String.valueOf(customerPass.getPassword()));
        if (e.getSource() instanceof JButton) handler.handleButtonEvent((JButton) e.getSource(), frames, contexts);
    }

    // 라벨 & 텍스트 필드 등록
    private void addTools(){
        JLabel name = tool.settingLabel("예약자 성함");
        JLabel phone = tool.settingLabel("휴대폰 번호");
        JLabel pass = tool.settingLabel("비밀번호");
        customerName = tool.settingFiled(15);
        customerPhone = tool.settingFiled(15);
        customerPass = tool.setPasswordField(15);
        loginPanel.add(name);
        loginPanel.add(customerName);
        loginPanel.add(phone);
        loginPanel.add(customerPhone);
        loginPanel.add(pass);
        loginPanel.add(customerPass);
    }

    // 버튼 등록
    private void addButton() {
        backBtn = iBtn.leftImgButton("back");
        loginBtn = iBtn.rightImgButton("login");
        background.add(backBtn);
        background.add(loginBtn);
    }

    // 판넬 등록
    private void addLoginPanel(){
        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.LEFT,50,20));
        background.add(loginPanel);
        loginPanel.setBounds(200,350,400, 550);
        loginPanel.setBackground(new Color(255,0,0,0));
    }

    // getter
    public JButton getBackBtn() {return backBtn;}
    public JButton getLoginBtn() {return loginBtn;}
    public JTextField getCustomerName() {return customerName;}
    public JTextField getCustomerPhone() {return customerPhone;}
    public JPasswordField getCustomerPass() {return customerPass;}
}
