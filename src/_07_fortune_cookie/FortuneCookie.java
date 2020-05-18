package _07_fortune_cookie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
public class FortuneCookie {
public void showButton() {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	System.out.println("Button Pressed");
	frame.setVisible(true);
frame.setSize(700,700);
JButton theButton = new JButton();
	frame.add(theButton);
	frame.pack();
	//theButton.addActionListener(this);
	
	
	
	}
}

