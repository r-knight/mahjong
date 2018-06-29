//package com.mahjong.mvc.models;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.io.*;


public class Test{
    
    private static final GameLogger gameLogger = new GameLogger();
	public static void main(String[] args) throws IOException{

        List<Player> players = new ArrayList<Player>();
		for (Integer i = 0; i < 4; i++){
			String name = "test".concat(i.toString());
            Player newPlayer = new Player(null, null, i, name, false);
            players.add(newPlayer);
        }
        players.get(0).setHuman(true);
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
        
        
       System.out.println("******************* GAME STARTING ***********************");
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
        

        gameLogger.flush(); // flush printstream before starting a game so all setup info is logged properly
        //gameLogger.resetOutstreamToSTDOut();
        game.startGame();
        gameLogger.flush(); // flush printstream after game ends so all game data is logged properly

        System.out.print("Wall:");
        System.out.println(Arrays.deepToString(game.getWall().toArray()));
        System.out.print("Wall Size:");
        System.out.println(game.getWall().size());
       // System.out.println("-=-=-Test discard-=-=-");
       // System.out.println(game.getCurrentPlayer().getHand().discardByIndex(1));
        System.out.println("******************* GAME COMPLETE ***********************");
       
        gameLogger.flush();
       gameLogger.closeOutPS(); // flush and close printstream

       gameLogger.resetOutstreamToSTDOut(); //Changes System.out back to stdout so the following message is printed to console.
       System.out.println("Done!");
    }
}