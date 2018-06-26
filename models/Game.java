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
	private Integer kanCounter;
		//keeps track of kans called during a round
		//if this ever exceeds 4, or reaches 4 with multiple players calling at least one kan,
		//the round ends
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
		this.kanCounter = 0;
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
	public Integer getKanCounter(){
		return kanCounter;
	}
	public void setKanCounter(Integer kanCounter){
		this.kanCounter = kanCounter;
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

	//private List<Tile> wall;
	//private List<Tile> deadWall; //contains the 10 potential dora/ura dora and 4 tiles that can be drawn from Kans
		//tiles in hands // stored in Player classes
		//tiles in discards // stored in Player classes

	//other getters/setters
	/*public Long getId(){
		return id;
	}*/




	//non-getter/setter functions

	/*public List<Player> checkPlayerWaits(Tile tile){
		List <Player> claims = new ArrayList<>();
		for(Player player : players){
			if(player == this.activePlayer){
				continue;
			}
			else if (player.checkIfTileInWait(tile)){
				claims.add(player);
			}
		}
		return claims;
	}


	public void startGame(){
		setupGame();
		draw(currentPlayer);
		playerTurn(currentPlayer);
	}
	public void setupGame(){
		this.wall = tileset.getTiles();
		Collections.shuffle(this.wall);
		breakWall();
		dealHands();
	}
	public void dealHands(){
		for (Player player : players){ // deal 13 tiles to each player
			for (int i = 0; i < 13; i++){
				draw(player);
			}
		}
	}

	public void breakWall(){
		for (int i = 0; i < 14; i++){ //deal 14 tiles to the dead wall
			this.deadWall.add(this.wall.get(this.wall.size()-1));
			this.wall.remove(this.wall.size()-1);
		}
	}

	public static boolean isValidWinningHand(Hand hand){
		if (hand.getTiles().size() >= 14){ 
			//the size of the list of all tiles in hand must be at least 14 or the hand cannot possibly be a winning hand
			Hand test = hand;
		}
		return false;
	}

	public void draw(Player player){
		player.drawTile(this.wall.get(this.wall.size()-1));
		this.wall.remove(this.wall.size()-1);
	}
	public void drawFromDeadWall(Player player){
		player.drawTile(this.deadWall.get(10)); //draw the 11th tile from the dead wall (the first 10 are dora/ura dora)
		this.deadWall.remove(this.deadWall.get(10));
	}
	public void playerTurn(Player player){
		//TODO: check for player to declare Tsumo or a concealed Kan
		//TODO: create "actionsAvailable" variable to check if player can declare kan or tsumo
		//while(actionsAvailable){ 
			//do stuff
			if (playerDeclaresTsumo){
				actionsAvailable = false;
				endHand(player);
			}
			else if (playerDeclaresKan){
				this.setKanCounter(this.getKanCounter+1);
				if (this.getKanCounter() > 4){
					actionsAvailable = false;
					endHand(player);
				}
				else{
					drawFromDeadWall(player);
				}
			}
			else{
				actionsAvailable = false;
			}
		}
		if(player.getHand().isWinner()){ //end the game (and break this loop)
			endHand(Player player);
		}
		else{
		//TODO: check for player to discard, set variable "discardedTile" to be that discard
			List<Player> claims = checkPlayerWaits(discardedTile)
			if (claims.size() != null){
				//TODO: check if players claim tile
				if (tile claimed){
					this.setCurrentPlayer(claimingPlayer);
				}
				else{
					this.setCurrentPlayer(nextPlayer);
					draw(this.currentPlayer);
				}
			}
			else{
				this.setCurrentPlayer(nextPlayer);
				draw(this.currentPlayer);
			}
			playerTurn(this.currentPlayer);
		}
	}
	public List<List<Tile>> handPermutations(List<Tile> tiles){
		if (tiles.size() < 2){
			return tiles;
		}

		List<List<Tile>> permutations = new ArrayList<ArrayList<Tile>>();

		for (var i = 0; i < tiles.size(); i++){
			Tile tile = tiles.get(i);

			if (tiles.indexOf(tile) != i){
				continue;
			}
		

			List<Tile> remaining = new ArrayList<Tile>;
			for (var j = 0; j < tiles.size(); j++){
				if (j.equals(i)){
					continue;
				}
				else{
					remaining.add(tiles.get(j));
				}
			}


			for (List<Tile> handPermutation of handPermutations(remaining)){
				List<Tile> newPerm = newArrayList<Tile>();
				newPerm.add(tile);
				newPerm.addAll(handPermutation);
				permutations.push(newPerm);
			}
		}
		return permutations;
	}
	*/
}