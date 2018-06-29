//package com.mahjong.mvc.models;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Test{
    
    private static final Logger logger = Logger.getLogger(Test.class.getName());
	public static void main(String[] args) throws IOException{

        File file = new File("mahjongapp.log");
        if(file.createNewFile()){
            System.out.println("log created");
        }
        else{
            System.out.println("log already exists");
        }
        Handler fh = new FileHandler("mahjongapp.log", true);
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.setLevel(Level.FINE);

        PrintStream stdout = System.out;
        PrintStream outPS =
        new PrintStream(
            new BufferedOutputStream(
                new FileOutputStream("mahjongapp.log", true)));  // append is true
        System.setErr(outPS);
        System.setOut(outPS);

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
        

        outPS.flush();
        game.startGame();
        outPS.flush();
        System.out.print("Wall:");
        System.out.println(Arrays.deepToString(game.getWall().toArray()));
        System.out.print("Wall Size:");
        System.out.println(game.getWall().size());
       // System.out.println("-=-=-Test discard-=-=-");
       // System.out.println(game.getCurrentPlayer().getHand().discardByIndex(1));

       System.out.println("******************* GAME COMPLETE ***********************");
       outPS.flush();
       outPS.close();
       System.setOut(stdout);
       System.out.println("Done!");
    }
}