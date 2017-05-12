import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIWindow extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	JPanel instructions;
	JLabel options;
	
	JPanel playerButtons;
	JButton player1;
	JButton player2;
	JButton player3;
	JButton player4;
	JButton player5;
	JButton player6;
	
	JPanel suitOptions;
	JButton spades = new JButton("spades");
	JButton hearts = new JButton("hearts");
	JButton clubs = new JButton("clubs");
	JButton diamonds = new JButton("diamonds");
	JButton jokersAnd7s = new JButton("jokers and 7s");
	JLabel choice;
	
	JPanel cardOptions;
	JButton ace = new JButton("ace");
	JButton two = new JButton("two");
	JButton three = new JButton("three");
	JButton four = new JButton("four");
	JButton five = new JButton("five");
	JButton six = new JButton("six");
	JButton seven = new JButton("seven");
	JButton eight = new JButton("eight");
	JButton nine = new JButton("nine");
	JButton ten = new JButton("ten");
	JButton jack = new JButton("jack");
	JButton queen = new JButton("queen");
	JButton king = new JButton("king");
	JButton bigJoker = new JButton("big joker");
	JButton smallJoker = new JButton("small joker");
	
	JPanel handPanel;
	JLabel hand;

	JPanel eventText;
	JLabel text;
	
	JPanel actionButtons;
	JButton declareSet;
	
	//ArrayList<Player> playerList;

	public GUIWindow()
	{
		super("Fish");
		
		//this.playerList = playerList;
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));	

		instructions = new JPanel();
		options = new JLabel("Click on a player to request a card");
		
		instructions.add(options);
		add(instructions);
		instructions.setBackground(Color.green);
		instructions.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		playerButtons = new JPanel(new GridBagLayout());
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
		player1.addActionListener(this);
		
		c.gridx = 5;
		c.gridy = 1;
		playerButtons.add(player2, c);
		player2.addActionListener(this);
		
		c.gridx = 4;
		c.gridy = 2;
		playerButtons.add(player3, c);
		player3.addActionListener(this);
		
		c.gridx = 3;
		c.gridy = 2;
		playerButtons.add(player4, c);
		player4.addActionListener(this);
		
		c.gridx = 2;
		c.gridy = 1;
		playerButtons.add(player5, c);
		player5.addActionListener(this);
		
		c.gridx = 3;
		c.gridy = 0;
		playerButtons.add(player6, c);
		player6.addActionListener(this);
		
		playerButtons.setBackground(Color.yellow);
		add(playerButtons);
		
		suitOptions = new JPanel();
		add(suitOptions);
		suitOptions.setBackground(Color.CYAN);
		
		cardOptions = new JPanel();
		add(cardOptions);
		cardOptions.setBackground(Color.MAGENTA);
		
		handPanel = new JPanel();
		hand = new JLabel("Your hand: ");
		handPanel.add(hand);
		add(handPanel);
		handPanel.setBackground(Color.blue);
		
		eventText = new JPanel();
		text = new JLabel("You haven't pressed Declare Half-Suit");
		eventText.add(text);
		add(eventText);
		eventText.setBackground(Color.red);
		
		actionButtons = new JPanel();
		declareSet = new JButton("Declare Half-Suit");
		declareSet.addActionListener(this);
		actionButtons.setBackground(Color.orange);
		actionButtons.add(declareSet);	
		
		add(actionButtons);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == declareSet)
			text.setText("You pressed Declare Half-Suit!"); displaySuitOptions();
			
		if(e.getSource() == player1)
			options.setText("Requesting a card from Player One"); displaySuitOptions();
		if(e.getSource() == player2)
			options.setText("Requesting a card from Player Two"); displaySuitOptions();
		if(e.getSource() == player3)
			options.setText("Requesting a card from Player Three"); displaySuitOptions();
		if(e.getSource() == player4)
			options.setText("Requesting a card from Player Four"); displaySuitOptions();
		if(e.getSource() == player5)
			options.setText("Requesting a card from Player Five"); displaySuitOptions();
		if(e.getSource() == player6)
			options.setText("Requesting a card from Player Six"); displaySuitOptions();
			
		if(e.getSource() == spades)
			displayCardOptions(spades);
	}
	
	public void displayHand(Player p)
	{
		hand.setText(p.toString());
	}
	
	public void displaySuitOptions()
	{
		suitOptions.add(spades);
		spades.addActionListener(this);
		suitOptions.add(hearts);
		hearts.addActionListener(this);
		suitOptions.add(clubs);
		clubs.addActionListener(this);
		suitOptions.add(diamonds);
		diamonds.addActionListener(this);
		suitOptions.add(jokersAnd7s);
		jokersAnd7s.addActionListener(this);
	}
	
	public void displayCardOptions(JButton b)
	{
		suitOptions.remove(spades);
		suitOptions.remove(hearts);
		suitOptions.remove(clubs);
		suitOptions.remove(diamonds);
		suitOptions.remove(jokersAnd7s);
	}
}
