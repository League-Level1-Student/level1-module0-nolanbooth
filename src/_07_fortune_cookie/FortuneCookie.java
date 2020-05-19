package _07_fortune_cookie;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
public class FortuneCookie implements ActionListener {
public void showButton() {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	System.out.println("Button Pressed");
	frame.setVisible(true);
frame.add(panel);
	frame.setSize(700,700);
JButton theButton = new JButton();
panel.add(theButton);
panel.setSize(700,200);
theButton.setSize(700, 200);
theButton.setText("Get your Fortune!");
	theButton.addActionListener(this);
	


		
	
	
	

}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	int random = new Random().nextInt(5);
	int random2  = new Random().nextInt(5);
	JOptionPane.showMessageDialog(null, "Woohoo, here is your fortune!");
	System.out.print(random);
	System.out.println(random2);
	
	if(random == 0 && random2 == 0) {	
		JOptionPane.showMessageDialog(null, "You will turn into a pig");	
	}if (random == 1) {
		JOptionPane.showMessageDialog(null, "You will get 50 bucks");
	}if(random == 2) {
		JOptionPane.showMessageDialog(null,  "You will get a slap in the face (metiphorically)");
	}if(random == 3) {
		JOptionPane.showMessageDialog(null,  "You will lose 50 bucks");
	}if(random == 4) {
		JOptionPane.showMessageDialog(null, "You will... WIN THE LOTTERY (good luck...)");
	}if (random == 0) {
		JOptionPane.showMessageDialog(null,  "You will have a nice day");
	}

}
}

