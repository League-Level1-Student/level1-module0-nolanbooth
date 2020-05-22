package _09_silent_effects_machine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class TheSilentMontage implements ActionListener {
	String animal = "Tiny Cow";
	String power = "Tiny Horns";

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();

	public void run() {

		// setup
		frame.setVisible(true);
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
//code
		JOptionPane.showMessageDialog(null, "You fall in a hole.");
		JOptionPane.showMessageDialog(null,
				"In front of you there is a path, it is dark. behind you there is another path");
		JOptionPane.showMessageDialog(null, "Which path do you take?");
		frame.setSize(300, 300);
		int w = 100;
		int h = 50;
		button1.setSize(w, h);
		button2.setSize(w, h);
		button3.setSize(w, h);
		button4.setSize(w, h);
		button5.setSize(w, h);
		button1.setText("Forward");
		button2.setText("Backward");
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
		if (buttonPressed == button1) {
			JOptionPane.showMessageDialog(null, "You selected forwards");
			panel.remove(button1);
			panel.remove(button2);

			int random = new Random().nextInt(2);
			if (random == 1) {
				JOptionPane.showMessageDialog(null, "You encountered a Tiny Cow");
				encounter(animal, power);
			} else {
				JOptionPane.showMessageDialog(null, "You got to a wall. There are three butttons");
			}
		}
		if (buttonPressed == button2) {
			JOptionPane.showMessageDialog(null, "You selected backwards");
		}
		if (buttonPressed == button3) {
			JOptionPane.showMessageDialog(null, "You clicked button three");
		}
		if (buttonPressed == button4) {
			JOptionPane.showMessageDialog(null, "You clicked button four");
		}
		if (buttonPressed == button5) {
			JOptionPane.showMessageDialog(null, "You clicked button five");
		}

	}

	public static void encounter(String c, String p) {
//setup
		int random2 = new Random().nextInt(2);
		int cowHealth = 2;
		int playerHealth = 10;
		// code
		int answer = JOptionPane.showOptionDialog(null, "What do you want to do?", "Encounter", 0,
				JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Fight", "Scare", "Escape", "Be Friends" }, null);
//FIGHT!!
		if (answer == 0) {
			JOptionPane.showMessageDialog(null, "You smacked " + c + "!");
			if (random2 == 1) {
				cowHealth -= 2;
				JOptionPane.showMessageDialog(null, "You dealt 2 damage!");
			} else {
				cowHealth -= 1;
				JOptionPane.showMessageDialog(null, "You dealt 1 damage!");
			}
			if (cowHealth == 0) {
				JOptionPane.showMessageDialog(null, c + " fainted!!");
			} else {
				JOptionPane.showMessageDialog(null, c + " poked you with his " + p + "!!");
				JOptionPane.showMessageDialog(null,
						"Tiny Cow dealt 1 damage! You have " + playerHealth + " health left");
				int answer2 = JOptionPane.showOptionDialog(null, "What do you want to do?", "Encounter", 0,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Fight", "Scare", "Escape", "Be Friends" }, null);
				if (answer2 == 0) {
					JOptionPane.showMessageDialog(null, "You smacked " + c + "!!");
					cowHealth--;
					JOptionPane.showMessageDialog(null, c + " fainted!!");
				}
				if (answer2 == 1) {
					JOptionPane.showMessageDialog(null, "You scared " + c + "!!");
					JOptionPane.showMessageDialog(null, c + " fainted!!");
				}
				if (answer2 == 2) {
					if (random2 == 0) {
						JOptionPane.showMessageDialog(null, "You escaped successfully!!");
					}
					if (random2 == 1) {
						JOptionPane.showMessageDialog(null,
								"You wouldn't have escaped, but " + c + " is too tired to chase you!!");
					}
				}
				if (answer2 == 3) {
					JOptionPane.showMessageDialog(null, c + " doesn't want to be your friend!!");
					JOptionPane.showMessageDialog(null, c + " runs away!!");
				}

			}

		}
//SCARE!!
		if (answer == 1) {
			JOptionPane.showMessageDialog(null, "You scared " + c + "!!");
			if (random2 == 0) {
				JOptionPane.showMessageDialog(null, c + " fainted!!");
			}
			if (random2 == 1) {
				JOptionPane.showMessageDialog(null, c + " seems scared, but doesn't faint");
				JOptionPane.showMessageDialog(null, c + " poked you with his " + p + "!!");
				JOptionPane.showMessageDialog(null, c + " dealt 1 damage!");
				playerHealth--;
				JOptionPane.showMessageDialog(null, "You have " + playerHealth + " health left!");
				int answer3 = JOptionPane.showOptionDialog(null, "What do you want to do?", "Encounter", 0,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Fight", "Scare", "Escape", "Be Friends" }, null);
				if (answer3 == 0) {
					JOptionPane.showMessageDialog(null, "You smacked " + c + "!!");
					JOptionPane.showMessageDialog(null, c + " fainted!");
				}
				if (answer3 == 1) {
					JOptionPane.showMessageDialog(null, "You scared " + c + "!!");
					JOptionPane.showMessageDialog(null, c + " fainted!!");
				}
				if (answer3 == 2) {
					JOptionPane.showMessageDialog(null,
							"You escaped successfully because " + c + " is scared of you!!");
				}
				if (answer3 == 3) {
					JOptionPane.showMessageDialog(null, c + " is scared that if he refuses, you will make him faint"
							+ ", so he becomes your friend");
					JOptionPane.showMessageDialog(null, "You learn that " + c + " is really nice!!");
				}

			}

		}
//ESCAPE!!
		if (answer == 2) {
			JOptionPane.showMessageDialog(null, "You tried to escape!!");
			if (random2 == 1) {
				JOptionPane.showMessageDialog(null, "You escaped successfully!!");
			} else {
				JOptionPane.showMessageDialog(null, "You failed to escape!!");
				JOptionPane.showMessageDialog(null, c + " poked you with his " + p + "!!");
				JOptionPane.showMessageDialog(null, c + " dealt 1 damage!!");
				playerHealth--;
				JOptionPane.showMessageDialog(null, "You now have " + playerHealth + " health left!!");
				int answer4 = JOptionPane.showOptionDialog(null, "What do you want to do?", "Encounter", 0,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Fight", "Scare", "Escape", "Be Friends" }, null);
				if (answer4 == 0) {
					JOptionPane.showMessageDialog(null, "You smacked " + c + "!!");
					if (random2 == 1) {
						JOptionPane.showMessageDialog(null, "You dealt 2 damage!!");
						cowHealth -= 2;
						JOptionPane.showMessageDialog(null, c + " fainted!!");
					} else {
						JOptionPane.showMessageDialog(null, "You dealt 1 damage!");
						cowHealth--;
						JOptionPane.showMessageDialog(null, c + " has " + cowHealth + " health left!!");
						JOptionPane.showMessageDialog(null, c + " poked you with his " + p + "!!");
						JOptionPane.showMessageDialog(null, c + " dealt 1 damage!");
						playerHealth--;
						JOptionPane.showMessageDialog(null, "You have " + playerHealth + " health left!!");
						int answer5 = JOptionPane.showOptionDialog(null, "What do you want to do?", "Encounter", 0,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Fight", "Scare", "Escape", "Be Friends" }, null);
						if (answer5 == 0) {
							JOptionPane.showMessageDialog(null, "You smacked " + c + "!!");
							JOptionPane.showMessageDialog(null, "You dealt 1 damage!!");
							cowHealth--;
							JOptionPane.showMessageDialog(null, c + " fainted!!");
						}
						if (answer5 == 1) {
							JOptionPane.showMessageDialog(null, "You scared " + c + "!!");
							JOptionPane.showMessageDialog(null, c + " is really scared!!");
							JOptionPane.showMessageDialog(null, c + " fainted!!");
						}
						if (answer5 == 2) {
							JOptionPane.showMessageDialog(null, "You tried to escape!!");
							if (random2 == 1) {
								JOptionPane.showMessageDialog(null, "You escaped succesfully!!");
							} else {
								JOptionPane.showMessageDialog(null, "You failed to escape!");
								JOptionPane.showMessageDialog(null, c + " poked you with his " + p + "!!");
								JOptionPane.showMessageDialog(null, c + " dealt 1 damage!!");
								playerHealth--;
								JOptionPane.showMessageDialog(null, "You have " + playerHealth + " health left!!");
								int answer6 = JOptionPane.showOptionDialog(null, "What do you want to do?", "Encounter",
										0, JOptionPane.INFORMATION_MESSAGE, null,
										new String[] { "Fight", "Scare", "Escape", "Be Friends" }, null);
								if (answer6 == 0) {
									JOptionPane.showMessageDialog(null, "You smacked " + c + "!!");
									JOptionPane.showMessageDialog(null, c + " fainted!!");
									if (answer6 == 1) {
										JOptionPane.showMessageDialog(null, "You scared " + c + "!!");
										JOptionPane.showMessageDialog(null, c + " fainted!!");
									}
									if (answer6 == 2) {
										JOptionPane.showMessageDialog(null, "You escaped successfully!!");
									}
									if (answer6 == 3) {
										JOptionPane.showMessageDialog(null, c + " doesn't want to be your friend!!");
										JOptionPane.showMessageDialog(null, c + " runs away!!");
									}
								}
							}
							if (answer5 == 3) {

							}

						}

					}

				}

			}
		}

	}

}
