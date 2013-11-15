package game;

import core.Position;

public class Maze {
	
	public enum Tile
	{
		PATH("_"), WALL("X");
		public	String toString()		{ return value; }
		private String value;	
		private Tile( String value )	{ this.value = value; }
	}
	
	private Tile[][] tiles = {
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
		{ Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH, Tile.PATH },
	};
	
	public Position getStartPosition() {
		return new Position( 0, 0 );
	}

	public Position getExitPosition() {
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
}
