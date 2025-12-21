package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener,MouseListener{
    //JFrame 자원은 컨테이너의  성격을 가지고 있다. 컨테이너는 컴포넌트를 배치시킨다.
    //컴포넌트
    JLabel title = new JLabel("휴먼교육센터");
    List ls = new List();
    JTextField jf = new JTextField();
    JTextField jfkor = new JTextField();
    JPanel jp = new JPanel();  //컨테이너와 컴포넌트의 속성을 갖는다.
    //border layout에서는 한 곳이 하나의 컴포넌트만 배치 시킬수 있다.
    //여러개의 컴포넌트를 border layout에 배치시키려면 패널을 만들어서
    //패널에 컴포넌트를 배치시키고 패널을 border layout에 배치하면 해결 가능하다.
    JButton savebtn = new JButton("Save");
    public MainFrame() {
        this.setBounds(100,100,300,500);
        jp.setLayout(new BorderLayout());
        jp.add(jf,"North");
        jp.add(jfkor,"Center");
        jp.add(savebtn,"East");
        //title 컴포넌트를 jframe에 배치
        //이때 , jframe은 layout을 기준으로 배치
        //jframe의 기본 layout은 borderLayout이다.
        //border Layout은 다음과 같이 구성된다.
        //      North
        //West Center East
        //      South
        //title 컴포넌트를 North에 배치

        title.setForeground(Color.red);
        this.add(title,"North");

        // ls를 Center에 위치
        ls.setBackground(Color.pink);
        ls.add("노래1");
        ls.add("노래2");
        this.add(ls,"Center");
        this.add(jp,"South");
        // 리스너 처리해 주세요..이벤트 발생시키는 대상 컴포너느를 등록
        savebtn.addActionListener(this);
        //this는 이벤트를 처리해 줄 객체. 즉 ActionListener를
        //구현 받은 객체의 주소
        jf.addActionListener(this);
        savebtn.addMouseListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==savebtn) {
            System.out.println("버튼");
            System.out.println(e.getSource()+"이번트  발생");
            String eng = jf.getText();
            String kor = jfkor.getText();
            ls.add(eng +" : " + kor);
        }else if(e.getSource()==jf) {
            System.out.println(jf.getText());
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //Object jj = e.getSource();
        JButton j = (JButton)e.getSource();
        j.setOpaque(false);
        j.setBackground(Color.blue);
        j.setBorderPainted(false);
    }
    @Override
    public void mouseEntered(MouseEvent e) {


    }
    @Override
    public void mouseExited(MouseEvent e) {
        JButton j = (JButton)e.getSource();
        j.setBackground(Color.red);

    }
    @Override
    public void mousePressed(MouseEvent e) {


    }
    @Override
    public void mouseReleased(MouseEvent e) {


    }
}