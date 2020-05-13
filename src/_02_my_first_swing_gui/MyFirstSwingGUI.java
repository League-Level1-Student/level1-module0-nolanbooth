package _02_my_first_swing_gui;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Dimension;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFirstSwingGUI {
	public void run() {

		// 1. Declare and initialize an object of the JFrame class
JFrame thingy = new JFrame();
		// 2. Set your JFrame object to be visible
thingy.setVisible(true);
thingy.setPreferredSize(new Dimension (500,500));
		// 3. Open MyFirstSwingGUIRunner and run your program. Do you see your window? It's probably very
		// small.

		// 4. Use your JFrame to call setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
thingy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 5. Declare and initialize an object of the JPanel class
JPanel thingy2 = new JPanel();
		// 6. Declare and initialize an object of the JLabel class
JLabel thingy3 = new JLabel();
		// 7. Set the text of the JLabel to a lovely greeting
thingy3.setText("HELLO I'm MICHAEL ROSEN");
		// 8. Add the JPanel object to the JFrame
thingy.add(thingy2);
		
// 9. Add the JLabel object to the JPanel
thingy2.add(thingy3);
		// 10. Pack your JFrame
thingy.pack();
		// 11. Run your program again. Do you see your message?

		// 12. Use your JLabel to call setIcon(loadImage())
thingy3.setIcon(loadImage());
		// 13. Re-pack the JFrame object
thingy.pack();
		// 14. Run the program one more time. Do you see the image?

	}

	public ImageIcon loadImage() {
		try {
			return new ImageIcon(ImageIO.read(new MyFirstSwingGUI().getClass().getResourceAsStream("java.png")));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
