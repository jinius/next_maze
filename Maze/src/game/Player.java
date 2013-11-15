package game;

import core.Navigator;

public class Player {
	
	private Maze maze;
	private Navigator navigator;

	public void enterMaze( Maze maze )
	{
		this.maze = maze;
		navigator.setPosition( maze.getStartPosition() );
		navigator.setDestination( maze.getExitPosition() );
	}

}
