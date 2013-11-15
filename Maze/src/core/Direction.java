package core;

public enum Direction
{
	C(0, 0), N(0, -1), NW(-1, -1), W(-1, 0), SW(-1, 1),
	S(0, 1), SE(1, 1), E(1, 0), NE(1, -1);

	private static Direction[] nwse = { N, W, S, E };
	private int x;
	private int y;

	private Direction( int x, int y )
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public double getFactor( int x, int y )
	{
		if ( x == 0 && y == 0 )
			return (double)( this.x * x + this.y * y );

		return ( (double)( this.x * x + this.y * y ) )
			/ Math.sqrt( this.x * this.x + this.y * this.y );
	}
	
	public static Direction[] values( int direction )
	{
		if ( direction == 4 ) return nwse;
		return values();
	}
}
