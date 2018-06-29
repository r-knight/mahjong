 //package com.mahjong.mvc.models;
 
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import java.util.Scanner;


public class Game{

	private String roundWind;
		//String representing the current wind. This can be derived from  the currentRound
	private Player prevWinner;
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
	private Integer currentTurn;
		//keeps track of current turn. This will change after each discard
	private Player currentPlayer;
		//tracks current player. When the Player class is finished, we can change this to be of type player
	private Player currentDealer;
		//tracks current dealer. When the Player class is finished, we can change this to be of type player
		//this will initially be the east player
	private List<Player> players;
		//list of players. When the Player class is finished, we can change this to be of type List<Player>
	private Integer rounds;
		//rounds to play

	private volatile boolean waitingForDiscard;
	public Game(){

	}

	public Game(List<Player> players, Integer rounds){
		this.roundWind = "east";
		this.prevWinner = null;
		this.tileSet = new TileSet();
		this.winCounter = 0;
		this.kanCounter = 0;
		this.currentRound = 1;
		this.currentHand = 1;
		this.currentTurn = 1;
		this.rounds = rounds;
		this.players = players;
		this.currentPlayer = players.get(0);
		this.currentDealer = players.get(0);
		this.waitingForDiscard = false;
	}

	public String getRoundWind(){
		return roundWind;
	}
	public void setRoundWind(String roundWind){
		this.roundWind = roundWind;
	}

	public Player getPrevWinner(){
		return prevWinner;
	}
	public void setPrevWinner(Player prevWinner){
		this.prevWinner = prevWinner;
	}

	public Integer getCurrentRound(){
		return currentRound;
	}
	public void setCurrentRound(Integer currentRound){
		this.currentRound = currentRound;
	}

	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer){
		this.currentPlayer = currentPlayer;
	}

	public Player getCurrentDealer(){
		return currentDealer;
	}
	public void setCurrentDealer(Player currentDealer){
		this.currentDealer = currentDealer;
	}

	public Integer getCurrentHand(){
		return currentHand;
	}
	public void setCurrentHand(Integer currentHand){
		this.currentHand = currentHand;
	}
	public Integer getCurrentTurn(){
		return currentTurn;
	}
	public void setCurrentTurn(Integer currentTurn){
		this.currentTurn = currentTurn;
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

	public List<Player> getPlayers(){
		return players;
	}
	public void setPlayers(List<Player> players){
		this.players = players;
	}

	public Integer getRounds(){
		return rounds;
	}
	public void setRounds(Integer rounds){
		this.rounds = rounds;
	}

	public boolean getWaitingForDiscard(){
		return waitingForDiscard;
	}
	public boolean setWaitingForDiscard(boolean waitingForDiscard){
		return this.waitingForDiscard = waitingForDiscard;
	}
	//TODO implement the following variables after the relevant classes have been created
	//private Long id;
	//private Player activePlayer;
		//tracks current turn
	//private List<Player> players;
	//private Ruleset ruleset;
		//will primarily be used to score/validate hands
	private TileSet tileSet;
		//tileset will need to be divided into several groups

	private List<Tile> wall;
	private List<Tile> deadWall; //contains the 10 potential dora/ura dora and 4 tiles that can be drawn from Kans
		//tiles in hands // stored in Player classes
		//tiles in discards // stored in Player classes

	//other getters/setters
	/*public Long getId(){
		return id;
	}*/

	public TileSet getTileSet(){
		return this.tileSet;
	}

	public void setTileSet(TileSet tileSet){
		this.tileSet = tileSet;
	}
	public List<Tile> getWall(){
		return this.wall;
	}

	public void setWall(List<Tile> wall){
		this.wall = wall;
	}
	public List<Tile> getDeadWall(){
		return this.deadWall;
	}

	public void setDeadWall(List<Tile> deadWall){
		this.deadWall = deadWall;
	}


	//non-getter/setter functions

	public List<Player> checkPlayerWaits(Tile tile){
		List <Player> claims = new ArrayList<>();
		/*for(Player player : players){
			if(player == this.currentPlayer){
				continue;
			}
			else if (player.getHand().getWaitTitles().size() > 0){
				for (Tile t : player.getHand().getWaitTitles()){
					if (t.equals(tile)){
						claims.add(player);
						break;
					}
				}
			}
		}*/
		return claims;
	}

	public void startGame(){
		Collections.shuffle(this.players);
		assignWindsAndSeats();
		setupGame();
		System.out.println("=-=-=-=-=-=-=-STARTING FIRST TURN - PLAYER: " + this.getCurrentPlayer() + "-=-=-=-=-=-=-=");
		draw(currentPlayer);
		System.out.println("=-=-=-=-=-=-=-TILE DRAWN-=-=-=-=-=-=-=");
		playerTurn(currentPlayer); //player turn functions as a game loop
	}
	public void setupGame(){
		System.out.println(tileSet.getAllTiles().size());
		this.wall = tileSet.getAllTiles();
		this.deadWall = new ArrayList<Tile>();
		System.out.println(this.wall.size());
		Collections.shuffle(this.wall);
		breakWall();
		dealHands();
	}
	public void assignWindsAndSeats(){
		//String[] windsArr = {"east", "south", "west", "north"};
		//List<String> winds = new ArrayList<String>(Arrays.asList(windsArr));
		for (int i = 0; i < 4; i++){
			players.get(i).setSeat(i);
		}
		this.setCurrentPlayer(players.get(0));
		this.setCurrentDealer(players.get(0));
	}
	public void rotateWinds(){
		for (int i = 0; i < 4; i++){
			Player player = players.get(i);
			Integer playerWind = player.getSeat();
			switch(playerWind){ // wind rotation is set, so a switch case can handle this in a straightforward way
				case 0:
					player.setSeat(3);
					break;
				case 1:
					player.setSeat(0);
					this.setCurrentPlayer(player);	//East wind will be the dealer (and current player)
					this.setCurrentDealer(player);
					break;
				case 2:
					player.setSeat(1);
					break;
				case 3:
					player.setSeat(2);
					break;
				default:
					//should not occur
					System.out.println("Invalid Player Wind Attribute:");
					System.out.println(playerWind);
					break;
			}
		}
	}
	public void dealHands(){
		for (Player player : players){ // deal 13 tiles to each player
			for (int i = 0; i < 13; i++){
				draw(player);
			}
			player.getHand().sortHand();
		}
	}

	public void breakWall(){
		for (int i = 0; i < 14; i++){ //deal 14 tiles to the dead wall
			Tile tile = this.wall.get(this.wall.size()-1);
			System.out.print(tile.getName() + " ");
			System.out.println(tile.getSuite());
			this.deadWall.add(this.wall.get(this.wall.size()-1));
			this.wall.remove(this.wall.size()-1);
		}
	}
	/*
	public static boolean isValidWinningHand(Hand hand){
		if (hand.getTiles().size() >= 14){ 
			//the size of the list of all tiles in hand must be at least 14 or the hand cannot possibly be a winning hand
			Hand test = hand;
		}
		return false;
	}
	*/
	public void draw(Player player){
		player.draw();
		this.wall.remove(this.wall.size()-1);
	}
	
	public void drawFromDeadWall(Player player){
		player.getHand().drawTile(this.deadWall.get(10)); //draw the 11th tile from the dead wall (the first 10 are dora/ura dora)
		this.deadWall.remove(this.deadWall.get(10));
	}

	public void playerActionsPhase(Player player){
		//TODO: check for player to declare Tsumo or a concealed Kan
		//TODO: create "actionsAvailable" variable to check if player can declare kan or tsumo
		boolean actionsAvailable = false;
		while(actionsAvailable){ 
			//do stuff
			boolean playerDeclaresTsumo = false;
			boolean playerDeclaresKan = false;
			if (playerDeclaresTsumo){
				actionsAvailable = false;
				endHand(player);
			}
			else if (playerDeclaresKan){
				this.setKanCounter(this.getKanCounter()+1);
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
	}
	public Tile playerTileDiscardPhase(Player player){
		Tile discardedTile;
		boolean isHuman = player.isHuman(); // TODO: change to check if player.isHuman() later
		int randomNum  = ThreadLocalRandom.current().nextInt(0, player.getHand().getTiles().size());
		if (isHuman){
			//TODO: check for player to discard, set variable "discardedTile" to be that discard
			waitForPlayerDiscard();
			//discardedTile = humanPlayerSelectDiscard(player, randomNum);
			discardedTile = player.getDiscards().get(player.getDiscards().size()-1);
		}
		else{
			discardedTile = player.getHand().discard((player.getHand().getTiles().get(randomNum)));
			this.waitingForDiscard = false;
		}
		this.currentTurn +=1;
		return discardedTile;
	}
	public void waitForPlayerDiscard(){
		while (waitingForDiscard){ // waits for player input on site, API call will toggle this attribute so the game can progress
			try{
				Thread.sleep(1000);
				System.out.println("Waiting...");
				System.out.println("Number of tiles in hand:" + this.currentPlayer.getHand().getTiles().size());
			}
			catch(Exception e){
				System.out.println("Thread was interrupted");
			}
		}
		try        
		{
			Thread.sleep(100);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	}
	public Tile humanPlayerSelectDiscard(Player player, int randomNum){
		Tile discardedTile = null;
		int maxHandIndex = player.getHand().getTiles().size()-1;
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		Integer n;
		
		do{
			System.out.println("Enter a number between 0 and " + maxHandIndex + ":");
			while(!reader.hasNextInt()){
				System.out.println("invalid input!"); // Scans the next token of the input as an int.
				reader.next();
			}
			n = reader.nextInt();
		} while ((n < 0 ||  n > maxHandIndex) || n == null);

		//once finished
		//reader.close();

		if (n != null){
			if (n >= 0 && n <= maxHandIndex){
				discardedTile = player.getHand().discard((player.getHand().getTiles().get(n)));
				this.waitingForDiscard = false;
			}
		}
		if (discardedTile == null){
			discardedTile = player.getHand().discard((player.getHand().getTiles().get(randomNum)));
			this.waitingForDiscard = false;
		}
		return discardedTile;
	}
	public boolean discardClaimPhase(Player player, Tile discardedTile){
		List<Player> claims = checkPlayerWaits(discardedTile);
		boolean tileClaimed = false;
		if (claims.size() > 0){
			//TODO: check if players claim tile, set tileClaimed to true if claimed
			Player claimingPlayer = null;
			if (tileClaimed){
				this.setCurrentPlayer(claimingPlayer);
				return true;
			}
		}
		return false;
	}

	public void setNextPlayer(){
		Integer currentPlayerWind = this.currentPlayer.getSeat();
		Player nextPlayer = null;
		switch(currentPlayerWind){
			case 0:
				nextPlayer = players.get(1);
				break;
			case 1:
				nextPlayer = players.get(2);
				break;
			case 2:
				nextPlayer = players.get(3);
				break;
			case 3:
				nextPlayer = players.get(0);
				break;
			default:
				//should not occur
				System.out.println("Invalid Player Wind Attribute:");
				System.out.println(currentPlayerWind);
				break;
		}
		this.setCurrentPlayer(nextPlayer);
		this.rotateWinds();
	}
	
	public void playerTurn(Player player){
		/*playerActionsPhase(player);
		if(player.getHand().isWinner()){ //end the game (and break this loop)
			endHand(player);
		}
		else{
			Tile discardedTile = playerTileDiscardPhase(player);
			boolean tileClaimed = discardClaimPhase(player, discardedTile);
			if(!(tileClaimed)){ // if the discarded tile is not claimed, switch to next player
				setNextPlayer(); // sets the game's current player to the next player
				draw(this.currentPlayer); // player needs to draw if they did not claim a discarded tile
			}
			this.setCurrentDealer(this.currentPlayer);
			playerTurn(this.currentPlayer); //start the process again with the new player
		}
		*/
		System.out.println("=-=-=-=-=-=-=-CURRENT TURN: " + this.currentTurn + "-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-DISCARDING-=-=-=-=-=-=-=");
		this.waitingForDiscard = true;
		Tile tile = playerTileDiscardPhase(this.currentPlayer);
		this.currentPlayer.getHand().sortHand();
		System.out.println(tile.getSuite() + " " + tile.getName());
		try        
		{
			Thread.sleep(1000);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
		if(this.wall.size() > 0){
			setNextPlayer();
			System.out.println("=-=-=-=-=-=-=-STARTING TURN FOR PLAYER: " + this.getCurrentPlayer() + "-=-=-=-=-=-=-=");
			draw(this.currentPlayer);
			System.out.println("=-=-=-=-=-=-=-TILE DRAWN-=-=-=-=-=-=-=");
			try        
			{
				Thread.sleep(1000);
			} 
			catch(InterruptedException ex) 
			{
				Thread.currentThread().interrupt();
			}
			playerTurn(this.currentPlayer);
		}
		else{
			endGame();
		}
	}
	
	public void endHand(Player player){
		System.out.println("game has ended. Winner:");
		System.out.println(player);
		if(this.prevWinner != null && this.prevWinner.equals(player)){
			this.winCounter +=1;
		}
		else{
			this.prevWinner = player;
			this.winCounter = 1;
		}
		//TODO: expand on functionality to account for player winning while dealer
		if (currentHand %4 == 0){
			if (currentRound.equals(rounds)){
				endGame();
			}
			else{
				progressToNextRound();
			}
		}
		else{
				progressToNextHand(); 
			}
	}

	public void endGame(){
		System.out.println("Game has concluded");
	}
	public void updateRoundWind(){
		String roundWind = this.roundWind;
		switch(roundWind){ // wind rotation is set, so a switch case can handle this in a straightforward way
			case "east":
				this.setRoundWind("north");
				break;
			case "south":
				this.setRoundWind("east");
				break;
			case "west":
				this.setRoundWind("south");
				break;
			case "north":
				this.setRoundWind("west");
				break;
			default:
				//should not occur
				System.out.println("Invalid Round Wind Attribute:");
				System.out.println(roundWind);
				break;
		}
	}
	public void updateGameAttributes(){
		//TODO: check if other attributes should be updated here
		this.kanCounter = 0; 
		this.currentHand +=1;
		this.currentTurn =1;
		this.waitingForDiscard = false;
	}
	public void progressToNextRound(){
		this.currentRound +=1;
		updateRoundWind();
		progressToNextHand();
	}
	public void progressToNextHand(){
		rotateWinds();
		updateGameAttributes();
		setupGame();
		draw(currentPlayer);
		playerTurn(currentPlayer);
	}
	/*
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