package game;

import java.util.ArrayList;

import core.Direction;
import core.Position;

public class Maze
{
	private int directionType;
	
	public Maze( int directionType )
	{
		this.directionType = directionType;
	}
	
	public enum Tile
	{
		PATH("_"), WALL("X");
		public	String toString()		{ return value; }
		private String value;	
		private Tile( String value )	{ this.value = value; }
	}
	
	private Tile[][] tiles = {
		{ Tile.PATH, Tile.WALL, Tile.WALL, Tile.WALL, Tile.PATH, Tile.WALL, Tile.WALL, Tile.WALL },
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.WALL, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.WALL, Tile.WALL, Tile.PATH, Tile.PATH, Tile.PATH, Tile.WALL, Tile.PATH, Tile.WALL },
		{ Tile.WALL, Tile.WALL, Tile.PATH, Tile.WALL, Tile.WALL, Tile.WALL, Tile.PATH, Tile.WALL },
		{ Tile.WALL, Tile.PATH, Tile.PATH, Tile.WALL, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.WALL, Tile.WALL, Tile.WALL, Tile.PATH, Tile.WALL, Tile.WALL, Tile.WALL },
		{ Tile.WALL, Tile.PATH, Tile.WALL, Tile.WALL, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.WALL, Tile.WALL, Tile.PATH, Tile.WALL, Tile.WALL, Tile.WALL, Tile.PATH },
	};
	
	public Position getStartPosition()
	{
		return new Position( 0, 0 );
	}

	public Position getExitPosition()
	{
		return new Position( 7, 7 );
	}

	public String toString()
	{
		StringBuilder buffer = new StringBuilder();
		
		for ( Tile[] row : tiles )
		{
			for ( Tile tile : row )
				buffer.append( tile );
			buffer.append( "\n" );
		}
		
		return buffer.toString();
	}
	
	public ArrayList<Direction> getAvailable( Position position )
	{
		ArrayList<Direction> available = new ArrayList<Direction>();
		
		for ( Direction direction : Direction.values( directionType ) )
		{
			if ( direction == Direction.C )
				continue;

			if ( isAvailable( position.getNext( direction ) ) )
			{
				available.add( direction );
			}
		}
		
		return available;
	}
	
	private boolean isAvailable( Position position )
	{
		int x = position.getX();
		int y = position.getY();

		if ( isValidPosition( position ) && tiles[y][x] == Tile.PATH )
			return true;
		
		return false;
	}
	
	private boolean isValidPosition( Position position )
	{
		int x = position.getX();
		int y = position.getY();

		if ( x < 0 || x >= 8 )
			return false;
		if ( y < 0 || y >= 8 )
			return false;
		
		return true;
	}
}
