package SampleInf;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelB extends JPanel implements MainCenterInf{
	
	JButton btn = new JButton("Test");
	public PanelB() {
		this.add(btn);
		this.setBackground(Color.orange);
	}
}
