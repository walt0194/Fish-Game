import java.util.ArrayList;
import javax.swing.*;

public class Fish 
{
	public static void main(String[] args)
	{
		Deck d = new Deck();
		
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		for(int i=0; i<6; i++)
		{
			playerList.add(new Player("Player"+(i+1)));
			playerList.get(i).drawHand(d);
		}
		
		GUIWindow window = new GUIWindow();
		window.setSize(600, 400);
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		window.displayHand(playerList.get(0));
	}
}
