package core;

public class Navigator {

	private Position position;
	private Position destination;

	public void setPosition( Position position )
	{
		this.position = position;
	}
	
	public void setDestination( Position destination )
	{
		this.destination = destination;
	}
	
	public Direction getNextMove( PositionInfo positionInfo )
	{
		return Direction.SE;
	}

	public void move( Direction direction )
	{
		// position = position.move( direction );
	}
}
