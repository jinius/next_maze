package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import core.Direction;
import core.Navigator;
import core.Position;

public class NavigatorTest
{
	private Navigator navigator;
	private ArrayList<Direction> directions;
	
	@Before
	public void setUp()
	{
		navigator = new Navigator();
		navigator.setPosition( new Position(0, 0) );

		directions = new ArrayList<Direction>();
		for ( Direction direction : Direction.values() )
			if ( Direction.C != direction ) directions.add( direction );
	}

	@Test
	public void testGetNextMove() {
		navigator.setDestination( new Position( 0, 0 ) );
		assertEquals( Direction.C, navigator.getNextMove( directions ) );
		navigator.setDestination( new Position( 1, 3 ) );
		assertEquals( Direction.E, navigator.getNextMove( directions ) );
		navigator.setDestination( new Position( 2, 3 ) );
		assertEquals( Direction.SE, navigator.getNextMove( directions ) );
		navigator.setDestination( new Position( 3, 2 ) );
		assertEquals( Direction.SE, navigator.getNextMove( directions ) );
		navigator.setDestination( new Position( 3, 1 ) );
		assertEquals( Direction.S, navigator.getNextMove( directions ) );
	}

}
