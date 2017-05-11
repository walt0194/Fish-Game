
public class PlayingCard 
{
	private int number;
	private String suit;
	private String halfSuit;

	public PlayingCard (int n, String s) 
	{
		number = n;
		suit = s;
		if (n < 7 && n > 0)
			halfSuit = "Low "+suit;
		else if (n > 7)
			halfSuit = "High "+suit;
		else
			halfSuit = "7's and Jokers";
	}
	public int getNumber() 
	{
		return number;
	}
	public String getSuit() 
	{
		return suit;
	}
	public String getHalfSuit()
	{
		return halfSuit;
	}
	public String toString()
	{
		if (number == 0)
			return suit;
		else
			return suit.charAt(0)+""+number;
	}
}
