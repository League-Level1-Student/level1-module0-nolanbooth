package _10_cuteness_tv;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;

public class Video_Thing implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();

	public void run() {
		frame.setSize(500, 500);
		frame.add(panel);
		button1.setText("Ducks");
		button2.setText("Frogs");
		button3.setText("Unicorns??");
		panel.add(button1);
		button3.addActionListener(this);
		button2.addActionListener(this);
		button1.addActionListener(this);
		panel.add(button2);
		panel.add(button3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed == button1) {
showDucks();
		}
		if (buttonPressed == button2) {
showFrog();
		}
		if (buttonPressed == button3) {
showFluffyUnicorns();
		}

	}

	void showDucks() {
		playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
		playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
		playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	}

	void playVideo(String videoID) {

		// Workaround for Linux because "Desktop.getDesktop().browse()" doesn't
		// work on some Linux implementations
		try {
			if (System.getProperty("os.name").toLowerCase().contains("linux")) {
				if (Runtime.getRuntime().exec(new String[] { "which", "xdg- open" }).getInputStream().read() != -1) {
					Runtime.getRuntime().exec(new String[] { "xdg-open", videoID });
				}
			} else {
				URI uri = new URI(videoID);
				java.awt.Desktop.getDesktop().browse(uri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
