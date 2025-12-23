package z99;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import SampleInf.MainCenterInf;
import SampleInf.PanelA;
import SampleInf.PanelB;
import SampleInf.PanelC;

public class Main implements ActionListener{
	
	MainCenterInf nowPanel = null;
	JFrame mainCon = new JFrame();
	
		
	
	JPanel np = new JPanel();
	JButton b1 = new JButton("A");
	JButton b2 = new JButton("B");
	JButton b3 = new JButton("C");

	Main() {		
		np.add(b1);
		np.add(b2);
		np.add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		mainCon.add(np, "North");
		
		selectCenterPanel("b1");
		mainCon.setBounds(100, 100, 200, 400);
		mainCon.setVisible(true);
		mainCon.setDefaultCloseOperation(mainCon.EXIT_ON_CLOSE);

	}


	PanelA pa = new PanelA();
	PanelB pb = new PanelB();
	PanelC pc = new PanelC();


	public void selectCenterPanel(String type) {
		
		if(nowPanel != null) {
			mainCon.remove((Component) nowPanel);
		}
				
		if(type.equals("b2")) {
			nowPanel = pb;
		}else if(type.equals("b3")) {
			nowPanel = pc;
		}else {
			nowPanel=pa;
		}
		
		mainCon.add((Component) nowPanel,"Center");
		mainCon.repaint();	
		mainCon.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b2) {
			selectCenterPanel("b2");
		}else if(e.getSource() == b3) {
			selectCenterPanel("b3");
		}else if(e.getSource() == b1) {
			selectCenterPanel("b1");
		}
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
