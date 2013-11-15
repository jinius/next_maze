package game;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import core.PositionStack;

public class Game
{
	
	private Maze maze;
	private Player player;

	public Game( int direction )
	{
		maze = new Maze( direction );
		player = new Player();
		player.enterMaze( maze );
	}
	
	public void run()
	{
		System.out.println( maze.toString() );
		while( player.update() ) ;
	}

	public static void main(String[] args) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream instream = new FileInputStream("maze.properties");
		prop.load(instream);
		String direction = prop.getProperty("direction");

		Game game = new Game( Integer.parseInt( direction ) );
		game.run();
		System.out.println( "Stack use count : " + PositionStack.getUseCount() );
	}

}
