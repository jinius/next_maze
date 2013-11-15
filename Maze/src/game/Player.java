package game;

import core.Navigator;
import core.Position;

public class Player
{
	private Maze maze;
	private Position position;
	private Position destination;
	private Navigator navigator = new Navigator();
	private int moveStep = 0;

	public void enterMaze( Maze maze )
	{
		this.maze = maze;

		position = maze.getStartPosition();
		destination = maze.getExitPosition();

		navigator.setPosition( position );
		navigator.setDestination( destination );
	}

	public boolean update()
	{
		if ( position.equals( destination ) )
		{
			System.out.println( "Exit! (MoveStep:" + moveStep + ")" );
			return false;
		}

		Position nextMove = navigator.getNextMove( maze.getAvailable( position ) );
		
		if ( nextMove == null )
		{
			System.out.println( "Can't reach exit position." );
			return false;
		}

		System.out.println( "Move to " + nextMove );
		position = nextMove;
		navigator.setPosition( position );
		moveStep++;

		return true;
	}

}
