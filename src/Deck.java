import java.util.*;
public class Deck {
	public ArrayList <PlayingCard> deck;
	
	public Deck()
	{
		deck = new ArrayList <PlayingCard>();
		for (int i = 1; i <= 13; i++)
		{
			deck.add(new PlayingCard(i, "Hearts"));
		}
		for (int i = 1; i <= 13; i++)
		{
			deck.add(new PlayingCard(i, "Diamonds"));
		}
		for (int i = 1; i <= 13; i++)
		{
			deck.add(new PlayingCard(i, "Spades"));
		}
		for (int i = 1; i <= 13; i++)
		{
			deck.add(new PlayingCard(i, "Clubs"));
		}
		deck.add(new PlayingCard(0, "Big Joker"));
		deck.add(new PlayingCard(0, "Small Joker"));
	}
	public ArrayList <PlayingCard> getDeck()
	{
		return deck;
	}
	public int size()
	{
		return deck.size();
	}
	public PlayingCard drawCard ()
	{
		int rand = (int) (deck.size()*Math.random());
		return deck.remove(rand);
	}
	
}
