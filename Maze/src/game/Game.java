package game;

public class Game {
	
	private Maze maze;
	private Player player;

	public Game()
	{
		maze = new Maze();
		player = new Player();
		player.enterMaze( maze );
	}
	
	public boolean run()
	{
		System.out.println( maze.toString() );
		return false;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}

}
