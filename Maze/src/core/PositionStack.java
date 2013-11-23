package core;

public class PositionStack
{
	private static int	pushCount = 0;
	private static int	popCount = 0;

	private Position[]	stack;
	private int			size;
	private int			top;
	
	PositionStack( int size )
	{
		this.size = size;
		stack = new Position[size];
		top = 0;
	}
	
	boolean push( Position position )
	{
		if ( top >= size )
			return false;

		stack[top] = position;
		top++;
		
		pushCount++;
		return true;
	}
	
	Position pop()
	{
		if ( top == 0 )
			throw null;
		
		top--;
		popCount++;
		return stack[top];
	}

	public static String getUseCount()
	{
		return "(push:" + pushCount + ", pop:" + popCount + ")";
	}
}
