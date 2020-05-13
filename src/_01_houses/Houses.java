package _01_houses;
import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;
 
public class Houses {
	static Robot bill = new Robot();
	public void run() {
		JOptionPane.showMessageDialog(null, "Hello", "greeting",JOptionPane.INFORMATION_MESSAGE);
		bill.setSpeed(15);
		bill.penDown();
		bill.miniaturize();
		bill.setX(10);
		bill.setY(550);
		bill.turn(90);
		bill.setPenColor(Color.GREEN);	
		
		
		
		for(int i =0; i < 10; i++) {
			int answer = JOptionPane.showOptionDialog(null, "How tall do you want your house to be?", 
					"Messege", 0, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] {"VERRRY small", "Small", "Medium", "Tall", "Mega", "Gigantic","Unmeasurable"}, null);
		                                    
			drawHouse(answer);	
		}
		
	
		
		
	}public static void drawHouse(int answer) {
//setup things
		int tallness = 30;
		if(answer == 0) {
		tallness = 10;
		}else if(answer == 1) {
			tallness = 50;
		}else if (answer == 2) {
			tallness = 100;
		}else if(answer == 3) {
			tallness = 200;
		}else if (answer == 4) {
			tallness = 300;
		}else if (answer == 5) {
			tallness = 450;
		}else if (answer == 6) {
			tallness = 900;
		}
				//house drawing
				bill.setPenColor(Color.GREEN);
				bill.move(40);
				bill.setRandomPenColor();
				bill.turn(-90);
				bill.move(tallness);
				bill.turn(90);
				bill.move(30);
				bill.turn(90);
				bill.move(tallness);
				bill.turn(-90);
				
				
	
		
	
	
	
	}
}
