import java.util.ArrayList;
import javax.swing.*;

public class Fish
{
	static ArrayList<Player> playerList;
	static boolean changeTurn = false;
	
	public static void main(String[] args)
	{
		Deck d = new Deck();
		
		playerList = new ArrayList<Player>();
		
		for(int i=0; i<6; i++)
		{
			playerList.add(new Player("Player"+(i+1)));
			playerList.get(i).drawHand(d);
		}
		
		GUIWindow window = new GUIWindow();
		window.setSize(600, 400);
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Player currentPlayer = playerList.get(0);
		int turn = 0;
		
		boolean gameOver = false;
		Player playerAsked;
		PlayingCard cardRequested;
		
		while(!gameOver)
		{
			window.clearWindows();
			window.displayHand(currentPlayer);
			
			while(!changeTurn)
			{}
			
			changeTurn = false;
			turn++;
			currentPlayer = playerList.get(turn%6);
		}
	}
}
