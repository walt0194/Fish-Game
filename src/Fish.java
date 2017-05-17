import java.util.ArrayList;
import javax.swing.*;

public class Fish
{
	static ArrayList<Player> playerList;
	static boolean changeTurn = false;
	static boolean moveOn = false;
	static int playerAsked;
	static String suitRequested = "";
	static int cardValueRequested;
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	public static void main(String[] args) throws InterruptedException
	{
		Deck d = new Deck();
		
		playerList = new ArrayList<Player>();
		
		for(int i=0; i<6; i++)
		{
			playerList.add(new Player("Player "+(i+1)));
			playerList.get(i).drawHand(d);
		}
		
		GUIWindow window = new GUIWindow();
		window.setSize(600, 400);
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Player currentPlayer = playerList.get(0);
		int turn = 0;
		
		boolean gameOver = false;
		
		while(!gameOver)
		{
			window.clearWindow();
			window.displayHand(currentPlayer);

			synchronized(lock1)
			{ 
				while(!moveOn)
				{
					lock1.wait();
				}
			}
			
			PlayingCard card = new PlayingCard(cardValueRequested, suitRequested);
			
			if(currentPlayer.getTeam().equals(playerList.get(playerAsked).getTeam()))
			{
				window.printSameTeam();
			}
			else if(!currentPlayer.hasHalfSuit(card))
			{
				window.printNotInSuit();
			}
			else if(!playerList.get(playerAsked).hasCard(card))
			{
				window.printNoCard(playerList.get(playerAsked), card);
			}
			else 
			{
				playerList.get(playerAsked).removeCard(card);
				currentPlayer.addCard(card);
			}

			window.displayHand(currentPlayer);
			
			while(!changeTurn)
			{}
			
			changeTurn = false;
			turn++;
			currentPlayer = playerList.get(turn%6);
		}
	}
}
