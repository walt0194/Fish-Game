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
	JButton sevenSpades = new JButton("seven of spades");
	JButton sevenHearts = new JButton("seven of hearts");
	JButton sevenClubs = new JButton("seven of clubs");
	JButton sevenDiamonds = new JButton("seven of diamonds");
	
	JPanel handPanel;
	JLabel hand;

	JPanel eventText;
	JLabel text;
	
	JPanel actionButtons;
	JButton declareSet;

	public GUIWindow()
	{
		super("Fish");
		
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
		suitOptions.setBackground(Color.cyan);
		
		cardOptions = new JPanel(new GridBagLayout());
		add(cardOptions);
		cardOptions.setBackground(Color.magenta);
		
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
			text.setText("You pressed Declare Half-Suit!"); 
			
		if(e.getSource() == player1)
		{
			options.setText("Requesting a card from Player One");
			Fish.playerAsked = 0;
			displaySuitOptions();
		}
		if(e.getSource() == player2)
		{
			options.setText("Requesting a card from Player Two");
			Fish.playerAsked = 1;
			displaySuitOptions();
		}
		if(e.getSource() == player3)
		{
			options.setText("Requesting a card from Player Three");
			Fish.playerAsked = 2;
			displaySuitOptions();
		}
		if(e.getSource() == player4)
		{
			options.setText("Requesting a card from Player Four");
			Fish.playerAsked = 3;
			displaySuitOptions();
		}
		if(e.getSource() == player5)
		{
			options.setText("Requesting a card from Player Five");
			Fish.playerAsked = 4;
			displaySuitOptions();
		}
		if(e.getSource() == player6)
		{
			options.setText("Requesting a card from Player Six");
			Fish.playerAsked = 5;
			displaySuitOptions();
		}
		
		//** Suit Buttons **//
		if(e.getSource() == spades)
		{ 
			options.setText(options.getText() + "; Suit chosen: spades");
			Fish.suitRequested = "Spades";
			displayCardOptions(spades);
		}
		if(e.getSource() == hearts)
		{ 
			options.setText(options.getText() + "; Suit chosen: hearts");
			Fish.suitRequested = "Hearts";
			displayCardOptions(hearts);
		}
		if(e.getSource() == clubs)
		{ 
			options.setText(options.getText() + "; Suit chosen: clubs");
			Fish.suitRequested = "Clubs";
			displayCardOptions(clubs);
		}
		if(e.getSource() == diamonds)
		{ 
			options.setText(options.getText() + "; Suit chosen: diamonds");
			Fish.suitRequested = "Diamonds";
			displayCardOptions(diamonds);
		}
		if(e.getSource() == jokersAnd7s)
		{ 
			options.setText(options.getText() + "; Suit chosen: Jokers and 7s");
			displayCardOptions(jokersAnd7s);
		}
		
		//** Card Value Buttons **//
		if(e.getSource() == ace)
			updatePush(1);
		if(e.getSource() == two)
			updatePush(2);
		if(e.getSource() == three)
			updatePush(3);
		if(e.getSource() == four)
			updatePush(4);
		if(e.getSource() == five)
			updatePush(5);
		if(e.getSource() == six)
			updatePush(6);
		if(e.getSource() == eight)
			updatePush(8);
		if(e.getSource() == nine)
			updatePush(9);
		if(e.getSource() == ten)
			updatePush(10);
		if(e.getSource() == jack)
			updatePush(11);
		if(e.getSource() == queen)
			updatePush(12);
		if(e.getSource() == king)
			updatePush(13);
		if(e.getSource() == sevenSpades)
			updatePush(7);
		if(e.getSource() == sevenHearts)
			updatePush(7);
		if(e.getSource() == sevenClubs)
			updatePush(7);
		
		if(e.getSource() == sevenDiamonds)
			updatePush(7);
		if(e.getSource() == smallJoker)
		{
			Fish.suitRequested = "Small Joker";
			updatePush(0);
		}
		if(e.getSource() == bigJoker)
		{
			Fish.suitRequested = "Big Joker";
			updatePush(0);
		}
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
		clearWindow();
		
		GridBagConstraints c = new GridBagConstraints();
		
		if(b == jokersAnd7s)
		{
			cardOptions.add(sevenSpades);
			sevenSpades.addActionListener(this);
			cardOptions.add(sevenHearts);
			sevenHearts.addActionListener(this);
			cardOptions.add(bigJoker);
			bigJoker.addActionListener(this);
			c.gridy = 1;
			cardOptions.add(sevenClubs ,c);
			sevenClubs.addActionListener(this);
			c.gridy = 1;
			cardOptions.add(sevenDiamonds, c);
			sevenDiamonds.addActionListener(this);
			c.gridy = 1;
			cardOptions.add(smallJoker, c);
			smallJoker.addActionListener(this);
		}
		else
		{
			c.gridy = 0;
			cardOptions.add(ace, c);
			ace.addActionListener(this);

			cardOptions.add(two, c);
			two.addActionListener(this);

			cardOptions.add(three, c);
			three.addActionListener(this);

			cardOptions.add(four, c);
			four.addActionListener(this);

			cardOptions.add(five, c);
			five.addActionListener(this);

			cardOptions.add(six, c);
			six.addActionListener(this);

			c.gridy = 1;
			cardOptions.add(eight, c);
			eight.addActionListener(this);

			cardOptions.add(nine, c);
			nine.addActionListener(this);

			cardOptions.add(ten, c);
			ten.addActionListener(this);

			cardOptions.add(jack, c);
			jack.addActionListener(this);

			cardOptions.add(queen, c);
			queen.addActionListener(this);

			cardOptions.add(king, c);
			king.addActionListener(this);
		}	
	}

	public void printNoCard(Player p, PlayingCard c)
	{
		options.setText(p.getName() + " does not have " + c);
	}
	
	public void printNotInSuit()
	{
		options.setText("You don't have the half-suit of the card you requested");
	}
	
	public void printSameTeam()
	{
		options.setText("Player"+(Fish.playerAsked+1)+" is on your team!");
	}
	
	public void clearWindow()
	{
		suitOptions.removeAll();
		cardOptions.removeAll();
	}

	public void updatePush(int value)
	{
		System.out.println(value);
		Fish.cardValueRequested = value;
		Fish.moveOn = true;
		synchronized(Fish.lock1)
		{
			Fish.lock1.notifyAll();
		}
	}

}
