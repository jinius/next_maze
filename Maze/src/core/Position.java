package core;

public class Position
{	
	private int x;
	private int y;
	
	public Position( int x, int y )
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public Position getNext( Direction direction )
	{
		Position position = new Position( this.x, this.y );
		return position.move( direction );
	}
	
	public Position move( Direction direction )
	{
		this.x += direction.getX();
		this.y += direction.getY();
		
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( ! ( obj instanceof Position ) )
			return false;

		Position other = (Position) obj;
		return ( x == other.x ) && ( y == other.y );
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public int hashCode()
	{
		return toString().hashCode();
	}
}
