import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class GUIWindow extends JFrame implements ActionListener
{
private static final long serialVersionUID = 1L;
	
	JButton declareSet;
	JButton player1;
	JButton player2;
	JButton player3;
	JButton player4;
	JButton player5;
	JButton player6;
	
	JLabel options;
	JLabel text;
	JLabel hand;

	public GUIWindow()
	{
		super("Fish");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));	

		JPanel instructions = new JPanel();
		options = new JLabel("Click on a player to request a card");
		
		instructions.add(options);
		add(instructions);
		
		JPanel playerButtons = new JPanel(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();
		
		player1 = new JButton("Player 1");
		player2 = new JButton("Player 2");
		player3 = new JButton("Player 3");
		player4 = new JButton("Player 4");
		player5 = new JButton("Player 5");
		player6 = new JButton("Player 6");
		
		c.gridx = 4;
		c.gridy = 0;
		playerButtons.add(player1, c);
		
		c.gridx = 5;
		c.gridy = 1;
		playerButtons.add(player2, c);
		
		c.gridx = 4;
		c.gridy = 2;
		playerButtons.add(player3, c);
		
		c.gridx = 3;
		c.gridy = 2;
		playerButtons.add(player4, c);
		
		c.gridx = 2;
		c.gridy = 1;
		playerButtons.add(player5, c);
		
		c.gridx = 3;
		c.gridy = 0;
		playerButtons.add(player6, c);
		add(playerButtons);
		
		JPanel handPanel = new JPanel();
		hand = new JLabel("Your hand: ");
		handPanel.add(hand);
		add(handPanel);
		
		JPanel eventText = new JPanel();
		text = new JLabel("You haven't pressed Declare Half-Suit");
		eventText.add(text);
		add(eventText);
		
		JPanel buttons = new JPanel();
		declareSet = new JButton("Declare Half-Suit");
		declareSet.addActionListener(this);
		buttons.add(declareSet);	
		
		add(buttons);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == declareSet)
			text.setText("You pressed Declare Half-Suit!");		
	}
	
}
