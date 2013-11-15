package core;

import java.util.ArrayList;
import java.util.HashSet;

public class Navigator
{
	private Position position;
	private Position destination;
	private PositionStack stack = new PositionStack(64);
	private HashSet<Position> visited = new HashSet<Position>();
	
	public void setPosition( Position position )
	{
		this.position = position;
		stack.push( position );
		visited.add( position );
	}
	
	public void setDestination( Position destination )
	{
		this.destination = destination;
	}
	
	public Position getNextMove( ArrayList<Direction> available )
	{
		if ( position.equals( destination ) )
			return position;

		ArrayList<Direction> directions = sortForDestination( available );
		
		for ( Direction direction : directions )
			if ( ! visited.contains( position.getNext( direction ) ) )
				return position.getNext( direction );
		
		stack.pop();
		return stack.pop();
	}
	
	private ArrayList<Direction> sortForDestination( ArrayList<Direction> directions )
	{
		// Maximum 8 element on list... just use bubble sort.
		for( int i = 0; i < directions.size(); ++i )
		{
			for( int j = i + 1; j < directions.size(); ++j )
			{
				if ( directions.get(i).getFactor( destination.getX(), destination.getY() )
						< directions.get(j).getFactor( destination.getX(), destination.getY() ) )
				{
					Direction temp = directions.get(i);
					directions.set( i, directions.get(j) );
					directions.set( j, temp );
				}
			}
		}

		return directions;
	}
}
