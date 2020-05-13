package _03_photo_quiz;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public void run() throws Exception {

		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);
		// This will make sure the program exits when you close the window
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
int score = 0;
		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image Address”)
String URL = "https://m.media-amazon.com/images/I/71uIImpdmBL._SS500_.jpg";
		// 2. create a variable of type "Component" that will hold your image
Component URL2;
		// 3. use the "createImage()" method below to initialize your Component
URL2 = createImage(URL);
		// 4. add the image to the quiz window
quizWindow.add(URL2);
		// 5. call the pack() method on the quiz window
quizWindow.pack();
		// 6. ask a question that relates to the image
String quiz = JOptionPane.showInputDialog("How heavy is this rabbit in pounds? (there are mulitple answers)");
int answer = Integer.parseInt(quiz);
// 7. print "CORRECT" if the user gave the right answer
if (answer >= 1000000) {
	JOptionPane.showMessageDialog(null, "Correct");
score++;
}else if (answer < 1000000) {
	JOptionPane.showMessageDialog(null, "WRONG");
}
		// 8. print "INCORRECT" if the answer is wrong

		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
quizWindow.remove(URL2);
		// 10. find another image and create it (might take more than one line
		// of code)
String URL3 = "https://i.ytimg.com/vi/c4YktzqJO3Y/hqdefault.jpg";
Component URL4;		
URL4 = createImage(URL3);
// 11. add the second image to the quiz window
quizWindow.add(URL4);
		// 12. pack the quiz window
quizWindow.pack();
		// 13. ask another question
String userAnswer = JOptionPane.showInputDialog(null,"What game is this");
		// 14+ check answer, say if correct or incorrect, etc.
if (userAnswer.equalsIgnoreCase("starblast")) {
	JOptionPane.showMessageDialog(null, "Correct");
score++;
}else {
	JOptionPane.showMessageDialog(null, "WRONG");
}
System.out.println(score);
	}

	private Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
