package inheritance_study;
import javax.swing.*;

public class Admin extends JFrame{
    JButton button = new JButton("난 버튼이얌 눌러보고싶지않니");
    JTextField textBox = new JTextField();
    // JFrame 상속받음
    public Admin(){
        this.add(button,"North");
        this.add(textBox,"South");
        // 시작 위치값 , 창의 크기 설정
        this.setBounds(100,200,300,400);
        // 보여줄것인지 아닐것인지 선택하는 것
        this.setVisible(true);

    }
}
