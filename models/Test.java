import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Test{
	public static void main(String[] args){
        
        List<Player> players = new ArrayList<Player>();
		for (Integer i = 0; i < 4; i++){
			String name = "test".concat(i.toString());
            Player newPlayer = new Player(null, null, i, name, false);
            players.add(newPlayer);
        }
        
		Game game = new Game(players, 1);
		for (Player player : game.getPlayers()){
            player.setGameInstance(game);
            Hand hand = new Hand();
            hand.setTiles(new ArrayList<Tile>());
            hand.setPlayer(player);
            player.setHand(hand);
            hand.setPlayer(player);
            player.setDiscards(new ArrayList<Tile>());
		}
        System.out.println(players);
        System.out.println("Round Wind: ".concat(game.getRoundWind().toString()));
		System.out.print("Previous Winner: ");
		System.out.println(game.getPrevWinner());
		System.out.println("Win Counter: ".concat(game.getWinCounter().toString()));
		System.out.println("Current Round: ".concat(game.getCurrentRound().toString()));
		System.out.println("Current Hand: ".concat(game.getCurrentHand().toString()));
		System.out.print("Current Player: ");
		System.out.println(game.getCurrentPlayer());
		System.out.print("Current Dealer: ");
        System.out.println(game.getCurrentDealer());
		System.out.print("Players: ");
		System.out.println(game.getPlayers());
        System.out.println("Rounds: ".concat(game.getRounds().toString()));
        
        game.startGame();
        System.out.print("Wall:");
        System.out.println(Arrays.deepToString(game.getWall().toArray()));
        System.out.print("Wall Size:");
        System.out.println(game.getWall().size());
       // System.out.println("-=-=-Test discard-=-=-");
       // System.out.println(game.getCurrentPlayer().getHand().discardByIndex(1));
    }
}