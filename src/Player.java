import java.util.*;
public class Player {
	
	private ArrayList<PlayingCard> hand;
	private String name;
	private String team;
	private static int nextTeam = 0;
	
	public Player (String n)
	{
		name = n;
		hand = new ArrayList <PlayingCard>();
		if (nextTeam % 2 == 0)
			team = "Evens";
		else
			team = "Odds";
		nextTeam++;
	}
	
	public ArrayList <PlayingCard> getHand()
	{
		return hand;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTeam()
	{
		return team;
	}
	
	public void drawHand(Deck d)
	{
		for (int i = 0; i < 9; i++)
		{
			hand.add(d.drawCard());
		}
		sortHand();
	}
	
	public void setHand(ArrayList <PlayingCard> h)
	{
		hand = h;
	}
	
	public void sortHand()
	{
		int count = 0;
		
		for (int i = 0; i < hand.size(); i++)
		{
			if (hand.get(i).getSuit().equals("Spades") && hand.get(i).getNumber() != 7)
			{
				hand.add(count, hand.remove(i));
				count++;
			}
		}
		int spades = count;
		
		for (int i = spades; i < hand.size(); i++)
		{
			if (hand.get(i).getSuit().equals("Hearts") && hand.get(i).getNumber() != 7) 
			{
				hand.add(count, hand.remove(i));
				count++;
			}
		}
		int hearts = count - spades;
		
		for (int i = hearts + spades; i < hand.size(); i++)
		{
			if (hand.get(i).getSuit().equals("Clubs") && hand.get(i).getNumber() != 7)
			{
				hand.add(count, hand.remove(i));
				count++;
			}
		}
		int clubs = count - spades - hearts;
		
		for (int i = spades + hearts + clubs; i < hand.size(); i++)
		{
			if (hand.get(i).getSuit().equals("Diamonds") && hand.get(i).getNumber() != 7)
			{
				hand.add(count, hand.remove(i));
				count++;
			}
		}
		int diamonds = count - spades - hearts - clubs;
		
		//insertion sort within suits
		for (int i = 0; i < spades; i++) 
		{
			int min = hand.get(i).getNumber();
			int minPosition = i;
			for (int scan = i+1; scan < spades; scan++)
			 {
				 if (hand.get(scan).getNumber() < min)
				 {
					 min = hand.get(scan).getNumber();
					 minPosition = scan;
				 }
			 }
			 PlayingCard temp = hand.get(i);
			 hand.set(i, hand.get(minPosition));
			 hand.set(minPosition, temp);
		}
		for (int i = spades; i < spades+hearts; i++) 
		{
			int min = hand.get(i).getNumber();
			int minPosition = i;
			for (int scan = i+1; scan < spades+hearts; scan++)
			 {
				 if (hand.get(scan).getNumber() < min)
				 {
					 min = hand.get(scan).getNumber();
					 minPosition = scan;
				 }
			 }
			 PlayingCard temp = hand.get(i);
			 hand.set(i, hand.get(minPosition));
			 hand.set(minPosition, temp);
		}
		for (int i = spades+hearts; i < spades+hearts+clubs; i++) 
		{
			int min = hand.get(i).getNumber();
			int minPosition = i;
			for (int scan = i+1; scan < spades+hearts+clubs; scan++)
			 {
				 if (hand.get(scan).getNumber() < min)
				 {
					 min = hand.get(scan).getNumber();
					 minPosition = scan;
				 }
			 }
			 PlayingCard temp = hand.get(i);
			 hand.set(i, hand.get(minPosition));
			 hand.set(minPosition, temp);
		}
		for (int i = spades+hearts+clubs; i < hand.size(); i++) 
		{
			int min = hand.get(i).getNumber();
			int minPosition = i;
			for (int scan = i+1; scan < count; scan++)
			 {
				 if (hand.get(scan).getNumber() < min)
				 {
					 min = hand.get(scan).getNumber();
					 minPosition = scan;
				 }
			 }
			 PlayingCard temp = hand.get(i);
			 hand.set(i, hand.get(minPosition));
			 hand.set(minPosition, temp);
		}
	}
	
	public void addCard(PlayingCard c)
	{
		hand.add(c);
	}
	
	public void removeCard(PlayingCard c)
	{
		for(int i = 0; i< hand.size(); i++)
		{
			if(c.equals(hand.get(i)))
			{
				hand.remove(i);
				break;
			}
		}
	}
	
	public String toString ()
	{
		String result = "";
		for (int i = 0; i < hand.size(); i++)
		{
			result += hand.get(i) + " ";
		}
		return "Your hand is: "+result;
	}
	
	public boolean hasCard(PlayingCard c)
	{
		for(int i = 0; i < hand.size(); i++)
		{
			if(c.equals(hand.get(i)))
				return true;
		}
		return false;
	}
	
	public boolean hasHalfSuit (PlayingCard c)
	{
		String halfSuit = c.getHalfSuit();
		for (int i = 0; i < hand.size(); i++)
		{
			System.out.println(hand.get(i).getHalfSuit());
			if (hand.get(i).getHalfSuit().equals(halfSuit))
				return true;
		}
		return false;
	}
	
	public void askCard (PlayingCard c, Player p)
	{
		if (hasHalfSuit(c) && !p.getTeam().equals(team))
		{
			if (p.hasCard(c))
			{
				System.out.println("They have the card!");
				System.out.println(p.getName()+"gives you "+c);
				p.removeCard(c);
				addCard(c);
				sortHand();
			}
		}
		else
		{
			System.out.println("You clown, learn the rules");
		}
	}
	
}