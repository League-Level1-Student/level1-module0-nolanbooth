package _09_silent_effects_machine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class TheSilentMontage implements ActionListener {
	static String animal = "Tiny Cow";
	static String power = "Tiny Horns";
	static String chestLoot;
static int playerHealth;
static int bullyHealth;
static boolean doorFight;
	static boolean chestStuff;
	static boolean cowFriend;
	static boolean bunnyFriend;
	static boolean torch;
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

			int randoma1 = new Random().nextInt(3);
			if (randoma1 == 1) {
				JOptionPane.showMessageDialog(null, "You encountered a Fat Bunny!");
				animal = "Fat Bunny";
				power = "Tiny Teeth";
				encounter(animal, power);
			}
			String DYTT = JOptionPane.showInputDialog(null, "You see a torch on the wall. Do you take it? (yes/no)");
			if (DYTT.equalsIgnoreCase("yes")) {
				JOptionPane.showMessageDialog(null, "You take the torch, and are glad of its light");
				torch = true;
			} else {
				JOptionPane.showMessageDialog(null, "You decide to leave it there");
				torch = false;
			}
			if (torch == true) {
				JOptionPane.showMessageDialog(null, "You walk down the tunnel, looking for a way out."
						+ "the torch helps you see, and you are glad you took it");
				JOptionPane.showMessageDialog(null, "There are now two paths. Which way do you go?");
			} else {
				JOptionPane.showMessageDialog(null, "You walk in darkness until you hit a wall. "
						+ "Feeling your way, you realize there are two paths, one to the right and one to the left");
				JOptionPane.showMessageDialog(null, "Which path do you take?");
			}
			panel.remove(button1);
			panel.remove(button2);
			panel.add(button4);
			panel.add(button5);
			panel.add(button3);
			int randomb1 = new Random().nextInt(2);
			button5.setText("Right");
			button4.setText("Left");
			button3.setText("Random (I don't know!!)");
			String iCheck1 = JOptionPane.showInputDialog(null, "Do you want to have an inventory check? yes/no");
			if (iCheck1.equalsIgnoreCase("yes")) {
				if (torch == true) {
					JOptionPane.showMessageDialog(null, "You are carrying a...");
					JOptionPane.showMessageDialog(null, "torch");
					if (bunnyFriend == true) {
						JOptionPane.showMessageDialog(null, "fat bunny");
					}
				} else {
					if (bunnyFriend == true) {
						JOptionPane.showMessageDialog(null, "fat bunny");
					}
				}
			}

			int lrr = JOptionPane.showOptionDialog(null, "Left or Right or Random?", "Intersection", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Left", "Right", "Don't know" }, null);
			if (lrr == 0) {
				JOptionPane.showMessageDialog(null, "You went left");
				leftBackwards();
			}
			if (lrr == 1) {
				JOptionPane.showMessageDialog(null, "You went right");
				rightBackwards();
			}
			if (lrr == 2) {
				JOptionPane.showMessageDialog(null, "You didn't know which way to go so you spun"
						+ " around in a circle and went the way you faced");
				if (randomb1 == 1) {
					JOptionPane.showMessageDialog(null, "You faced left");
					leftBackwards();
				}
				if (randomb1 == 0) {
					JOptionPane.showMessageDialog(null, "You faced right");
					rightBackwards();
				}
			}

		}
	}

	public static void encounter(String c, String p) {
//setup
		int random2 = new Random().nextInt(2);
		int cowHealth = 2;
		playerHealth = 10;
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
					if (answer == 3) {
						JOptionPane.showMessageDialog(null, "You became " + c + "'s friend!!");
						if (animal.equalsIgnoreCase("Tiny Cow")) {
							cowFriend = true;
						}
						if (animal.equalsIgnoreCase("Fat Bunny")) {
							bunnyFriend = true;
						}
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
									int answer6 = JOptionPane.showOptionDialog(null, "What do you want to do?",
											"Encounter", 0, JOptionPane.INFORMATION_MESSAGE, null,
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
											JOptionPane.showMessageDialog(null,
													c + " doesn't want to be your friend!!");
											JOptionPane.showMessageDialog(null, c + " runs away!!");
										}
									}
								}
								if (answer5 == 3) {
									JOptionPane.showMessageDialog(null, c + " is your friend!!");
									if (answer == 3) {
										JOptionPane.showMessageDialog(null, "You became " + c + "'s friend!!");
										if (animal.equalsIgnoreCase("Tiny Cow")) {
											cowFriend = true;
										}
										if (animal.equalsIgnoreCase("Fat Bunny")) {
											bunnyFriend = true;
										}
									}

								}

							}

						}

					}
				}
//be friends!!
				if (answer == 3) {
					JOptionPane.showMessageDialog(null, "You became " + c + "'s friend!!");
					if (animal.equalsIgnoreCase("Tiny Cow")) {
						cowFriend = true;
					}
					if (animal.equalsIgnoreCase("Fat Bunny")) {
						bunnyFriend = true;
					}
				}
			}
		}

	}

	public static void leftBackwards() {
		if (torch == true) {
			JOptionPane.showMessageDialog(null, "You go down the left path until you see a drop.");
		} else {
			JOptionPane.showMessageDialog(null,
					"You walk blindly along the path until you suddenly drop down another " + "hole...");

		}

	}

	public static void rightBackwards() {
		if (torch == true) {
			chestLoot = JOptionPane.showInputDialog(null,
					"You walk down the path with your torch. Then, you see a chest. Open it? yes/no");
		} else {
			chestLoot = JOptionPane.showInputDialog(null,
					"You walk blindly down the path until you hit a chest, you can feel it. Open it? yes/no");
		}
		if (chestLoot.equalsIgnoreCase("yes")) {
			JOptionPane.showMessageDialog(null, "You open the chest, and you take the things inside. A lantern, "
					+ "a peice of armor, a Nerf gun and a backpack.");
			chestStuff = true;
		JOptionPane.showMessageDialog(null, "A sign on the chest says 'USE THIS TO DESTROY THE NOIGROR'");
		JOptionPane.showMessageDialog(null,  "???");
		String doorPath = JOptionPane.showInputDialog(null, "Do you want to go through the door on your right or go back? yes/no");
		if(doorPath.equalsIgnoreCase("yes")) {
		JOptionPane.showMessageDialog(null,  "You go through the door with the Nerf gun in your hand... "
				+ "hmmm... I guess it would help a bit??");
		
		}
		} else {
			JOptionPane.showMessageDialog(null, "You decide to leave the chest there.");
			String doorPath = JOptionPane.showInputDialog(null, "Do you want to go through the door on your right or go back? yes/no");
			if(doorPath.equalsIgnoreCase("yes")) {
			JOptionPane.showMessageDialog(null,  "You go through the door with your fist held up... "
					+ "hmmm... I guess it would help a bit??");
			
			}
		}

	}
public static void bullyEncounter() {
	JOptionPane.showMessageDialog(null,  "You go through the door and a fist punches out at you, dealing 2 damage!");
	playerHealth-=2;
	if(playerHealth == 0|| playerHealth < 0) {
	JOptionPane.showMessageDialog(null,  "You fainted!! Game over!!");
	}else {
	
		if(chestStuff == true) {
		
		int bullyDefence =	JOptionPane.showOptionDialog(null, "What do you want to do?",
				"Encounter", 0, JOptionPane.INFORMATION_MESSAGE, null,
				new String[] { "Fire Nerf Gun", "Punch", "Escape" }, null);
		if(bullyDefence == 0) {
			JOptionPane.showMessageDialog(null,  "You fired the nerf gun at bully!!");
		JOptionPane.showMessageDialog(null,  "You dealt 5 damage!!");
		}
		
		
		
		
		
		}
		else {
		int bullyDefence2 =	JOptionPane.showOptionDialog(null, "What do you want to do?",
				"Encounter", 0, JOptionPane.INFORMATION_MESSAGE, null,
				new String[] { "Punch", "Escape" }, null);
		
		
		
		
		
		}
	
	}
	
	
	
	
	
	
	
	

	}	
}
