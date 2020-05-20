package _09_silent_effects_machine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class TheSilentMontage implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();	
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();


public  void run() {
	//setup
	
	//setup
	frame.setVisible(true);	
panel.add(button1);	
panel.add(button2);
panel.add(button3);
panel.add(button4);
panel.add(button5);
frame.add(panel);
//code
frame.setSize(900,900);
int w = 100;
int h = 50;
button1.setSize(w, h);
button2.setSize(w, h);
button3.setSize(w, h);
button4.setSize(w, h);
button5.setSize(w, h);
button1.setText("button #1");
button2.setText("button #2");
button3.setText("button #3");
button4.setText("button #4");
button5.setText("button #5");
button1.addActionListener(this);
button2.addActionListener(this);
button3.addActionListener(this);
button4.addActionListener(this);
button5.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	JButton buttonPressed = (JButton) arg0.getSource();
	if(buttonPressed == button1) {
		
	}
	
	
	
	
	
	
	
	
	
}	
}
