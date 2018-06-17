import java.util.Arrays;
import java.util.List;
public class Game{

	private String roundWind;
		//String representing the current wind. This can be derived from  the currentRound
	private Integer prevWinner;
		//tracks previous winner. When the Player class is finished, we can change this to be of type player
	private Integer winCounter; 
		//keeps tracks of how many consecutive wins there have been by the same player
		//modifies scoring once we have implemented that functionality
	private Integer currentRound;
		//keeps track of current round. To start, we will most likely
	private Integer currentHand;
		//keeps track of current hand. This will change each time a round ends and the current dealer did NOT win the hand
	private Integer currentPlayer;
		//tracks current player. When the Player class is finished, we can change this to be of type player
	private Integer currentDealer;
		//tracks current dealer. When the Player class is finished, we can change this to be of type player
		//this will initially be the east player
	private List<Integer> players;
		//list of players. When the Player class is finished, we can change this to be of type List<Player>
	private Integer rounds;
		//rounds to play
	public Game(){

	}

	public Game(List<Integer> players, Integer rounds){
		this.roundWind = "East";
		this.prevWinner = -1; 
		this.winCounter = 0;
		this.currentRound = 1;
		this.currentHand = 1;
		this.currentPlayer = 1;
		this.currentDealer = 1;
		this.rounds = rounds;
		this.players = players;
	}

	public String getRoundWind(){
		return roundWind;
	}
	public void setRoundWind(String roundWind){
		this.roundWind = roundWind;
	}

	public Integer getPrevWinner(){
		return prevWinner;
	}
	public void setPrevWinner(Integer prevWinner){
		this.prevWinner = prevWinner;
	}

	public Integer getCurrentRound(){
		return currentRound;
	}
	public void setCurrentRound(Integer currentRound){
		this.currentRound = currentRound;
	}

	public Integer getCurrentPlayer(){
		return currentPlayer;
	}
	public void setCurrentPlayer(Integer currentPlayer){
		this.currentPlayer = currentPlayer;
	}

	public Integer getCurrentDealer(){
		return currentDealer;
	}
	public void setCurrentDealer(Integer currentDealer){
		this.currentDealer = currentDealer;
	}

	public Integer getCurrentHand(){
		return currentHand;
	}
	public void setCurrentHand(Integer currentHand){
		this.currentHand = currentHand;
	}

	public Integer getWinCounter(){
		return winCounter;
	}
	public void setWinCounter(Integer winCounter){
		this.winCounter = winCounter;
	}

	public List<Integer> getPlayers(){
		return players;
	}
	public void setPlayers(List<Integer> players){
		this.players = players;
	}

	public Integer getRounds(){
		return rounds;
	}
	public void setRounds(Integer rounds){
		this.rounds = rounds;
	}
	//TODO implement the following variables after the relevant classes have been created
	//private Long id;
	//private Player activePlayer;
		//tracks current turn
	//private List<Player> players;
	//private Ruleset ruleset;
		//will primarily be used to score/validate hands
	//private Tileset tileset;
		//tileset will need to be divided into several groups
		//tiles in active wall
		//tiles in dead wall
			//dead wall will have the 10 dora/uradora and a set of 4 tiles
			//these 4 tiles can be drawn when a user calls a Kan
		//tiles in hands
		//tiles in discards

	//other getters/setters
	/*public Long getId(){
		return id;
	}*/
}