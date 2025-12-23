package SampleInf;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelA extends JPanel implements MainCenterInf{
	
	JLabel title = new JLabel("RED AREA");
	
	public PanelA() {
		
		this.add(title);
		this.setBackground(Color.red);
	}

}
