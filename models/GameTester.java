import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GameTester{
	public static void main(String[] args){
		Player[] p = new ArrayList<Player>();
		for (Integer i = 0; i < 4; i++){
			String name = "test".concat(i.toString());
			Player newPlayer = new Player(null, null, i, name, false);
		}
		List<Player> players = Arrays.asList(p);

		String[] winds = {"East", "South", "West", "North"};
		Game game = new Game(players, 1);
		for (Player player : game.getPlayers()){
			player.setGameInstance(game);
		}
		System.out.println("Round Wind: ".concat(game.getRoundWind().toString()));
		System.out.println(game.getPrevWinner());
		System.out.println(game.getWinCounter());
		System.out.println(game.getCurrentRound());
		System.out.println(game.getCurrentHand());
		System.out.println(game.getCurrentPlayer());
		System.out.println(game.getCurrentDealer());
		System.out.println(game.getPlayers());
		System.out.println(game.getRounds());

		//simulate a hand being won. Win counter and currentHand will change.
		//prevWinner, currentRound, currentPlayer, currentDealer, and roundWind may all change
		//prevWinner will be set to the winner of the round. For the sake of simplicity, we will only track one though there could be multiple.
		//if prevWinner is the round's currentDealer, that player remains the dealer.
		//otherwise, currentDealer advances to the next player in turn order from the current dealer. Player winds rotate (South becomes east, etc)
		//if round would change and this would set currentRound to be greater than rounds, the game ends
		//otherwise, advance roundWind to next wind  (Order: 1-4, E-S-W-N)
		//Typically, japanese games would end at the end of the South round (2nd)
		//currentPlayer will then be set to currentDealer

		Integer winner = 2;
		System.out.println("Game won by player: " + winner);
		game.setCurrentHand(game.getCurrentHand()+1);
		if (winner == game.getPrevWinner()){
			game.setWinCounter(game.getWinCounter()+1);
		}
		else{
			game.setWinCounter(1);
			game.setPrevWinner(game.getPlayers().get(winner-1));
		}

		if (game.getPrevWinner() == game.getCurrentDealer()){
			System.out.println("Hand won by dealer. Rounds remain the same.");
		}
		else{ //game advances
			if (game.getCurrentDealer().equals(game.getPlayers().get(3))){ //round over
				if (game.getCurrentRound() == game.getRounds()){
					System.out.println("Game over");
				}
				else{
					game.setCurrentDealer(game.getPlayers().get(0));
					game.setCurrentRound(game.getCurrentRound() +1);
					game.setRoundWind(winds[game.getCurrentRound()]);
					System.out.println("Final hand of round won by someone other than dealer. Starting new round.");
				}
			}
			else{
				Integer dealerIdx = game.getPlayers().indexOf(game.getCurrentDealer());
				game.setCurrentDealer(index+1);
				System.out.println("hand won by player other than dealer. Winds rotate.");
			}
		}
		game.setCurrentPlayer(game.getCurrentDealer());

		System.out.println(game.getRoundWind());
		System.out.println(game.getPrevWinner());
		System.out.println(game.getWinCounter());
		System.out.println(game.getCurrentRound());
		System.out.println(game.getCurrentHand());
		System.out.println(game.getCurrentPlayer());
		System.out.println(game.getCurrentDealer());
		System.out.println(game.getPlayers());
		System.out.println(game.getRounds());
	}

}