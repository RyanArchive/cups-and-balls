// A game where the user needs to find the ball among the three (cups)
// Cups are only represented as rectangular buttons

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CupsAndBalls extends JFrame{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {					// This is to avoid necessary crashes
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		CupsAndBalls f = new CupsAndBalls("Java UI");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(f.getContentPane());
		f.setSize(350,200);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public CupsAndBalls (String name) {
		super(name);
	}

	public static void addComponentsToPane(final Container pane) {
		// Instantiating variables
		final JPanel panel = new JPanel();
		final JLabel lblHeader = new JLabel("Where's the ball?");
		final JButton btnCup1 = new JButton("Cup 1");
		final JButton btnCup2 = new JButton("Cup 2");
		final JButton btnCup3 = new JButton("Cup 3");
		final JLabel lblFeedback = new JLabel("");
		final JButton btnNew = new JButton("New");
		final Randoming r = new Randoming();

		// Setting the bounds (x, y, width, height)
		lblHeader.setBounds(109, 20, 140, 26);
		btnCup1.setBounds(25, 55, 90, 30);
		btnCup2.setBounds(123, 55, 90, 30);
		btnCup3.setBounds(220, 55, 90, 30);
		lblFeedback.setBounds(25, 100, 200, 36);
		btnNew.setBounds(220, 105, 90, 30);

		Color color1 = new Color(140, 232, 152);
		Color color2 = new Color(247, 177, 187);
		Color color3 = new Color(163, 201, 224);
		Color color4 = new Color(255, 212, 84);

		// Setting the font
		lblHeader.setFont(new Font("Helvetica", 1, 14));
		btnCup1.setFont(new Font("Helvetica", 1, 12));
		btnCup2.setFont(new Font("Helvetica", 1, 12));
		btnCup3.setFont(new Font("Helvetica", 1, 12));
		lblFeedback.setFont(new Font("Helvetica", 1, 13));
		btnNew.setFont(new Font("Helvetica", 1, 12));

		btnCup1.setBackground(color1);
		btnCup2.setBackground(color2);
		btnCup3.setBackground(color3);
		btnNew.setBackground(color4);

		// Adding the components to pane
		pane.setLayout(null);
		pane.add(lblHeader);
		pane.add(btnCup1);
		pane.add(btnCup2);
		pane.add(btnCup3);		
		pane.add(lblFeedback);
		pane.add(btnNew);

		// Adding actions
		btnCup1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCup1.setEnabled(false);
				btnCup2.setEnabled(false);
				btnCup3.setEnabled(false);

				if (r.getNum() == 1) {
					lblFeedback.setText("Correct. It is in " + r.getCups());
				} else {
					lblFeedback.setText("Wrong. The correct is " + r.getCups());
				}
			}
		});

		btnCup2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCup1.setEnabled(false);
				btnCup2.setEnabled(false);
				btnCup3.setEnabled(false);

				if (r.getNum() == 2) {
					lblFeedback.setText("Correct. It is in " + r.getCups());
				} else {
					lblFeedback.setText("Wrong. The correct is " + r.getCups());
				}
			}
		});

		btnCup3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCup1.setEnabled(false);
				btnCup2.setEnabled(false);
				btnCup3.setEnabled(false);

				if (r.getNum() == 3) {
					lblFeedback.setText("Correct. It is in " + r.getCups());
				} else {
					lblFeedback.setText("Wrong. The correct is " + r.getCups());
				}
			}
		});

		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCup1.setEnabled(true);
				btnCup2.setEnabled(true);
				btnCup3.setEnabled(true);
				r.newCup();
				lblFeedback.setText("");
			}
		});
	}
}

// Storage of data
class Randoming {
	Random random = new Random();
	int num;
	String cups = "";

	public Randoming() {
		newCup();
	}

	public void newCup() {
		num = random.nextInt(3) + 1;

		if (num == 1) {
			cups = "Cup 1";
		} else if (num == 2) {
			cups = "Cup 2";
		} else if (num == 3) {
			cups = "Cup 3";
		}
	}

	public void setNum(int i) {
		num = i;
	}

	public int getNum() {
		return num;
	}
	public String getCups() {
		return cups;
	}
}