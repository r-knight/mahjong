import java.util.ArrayList;
import java.util.List;


public class Player{

//	need to import User, Game, Hand when they are compiled
		
		private Game gameInstance;
		
		private Integer seat; // 0,1,2,3, to reperesent locations on the table N,E,S,W
	 	private String name; //screen name
		private Integer score;
		private Integer handsWon;
		private Integer winStreak;
		private ArrayList<Tile> discards;
		private boolean isActive; //used for the game logic to track when a player is done with their turn. the game logic should alter the state of the player before they can perform actions
		private boolean isHuman; //tracks the players vs AIs
		private Long userId; //connection to the logged in user
		
		
		public Player(){
			
		}
//		player generator intended for the game to create a player with relevant info
		public Player(Game gameInstance, Hand hand, Integer seat, String name, boolean isHuman) {
			this.gameInstance = gameInstance;
			this.hand = hand;
			this.seat = seat;
			this.name = name;
			this.isHuman = isHuman;
			this.score = 0;
			this.handsWon = 0;
			this.winStreak = 0;
			this.isActive = false;
			this.discards = new ArrayList<Tile>();
			
		}
		
//		draw function -> calls on external draw and adds to current hand
		public void draw() {
			hand.drawTile();
		}
		
//		discard function -> calls on game tile movement, but logs the tile in discards list
		public void discardTile(Tile tile) {
			hand.discard(tile);
		}
		
//		claim function -> 
		public void claim(Tile tile) {
//			call external methods to claim tiles
			hand.claimTile();
		}
		
//		pass function ->

		
//		declare function ->
		public List<Tile> declare(){
			List<Tile> tempList = new List<Tile>();
			return tempList;
		}
		
		
//		tsumo function-> calls on validate hand 
		public boolean tsumo() {
			this.hand.validate();
		}
		
//		endTurn function -> sets active state
		public void endTurn() {
			this.setActive(false);
		}
		
		
		
//		getters and setters
		public Game getGameInstance() {
			return gameInstance;
		}
		public void setGameInstance(Game gameInstance) {
			this.gameInstance = gameInstance;
		}
		
		public User getUser() {
			return user;
		}
		
		public void setUser(User user) {
			this.user = user;
		}
		
		public Hand getHand() {
			return hand;
		}
		public void setHand(Hand hand) {
			this.hand = hand;
		}
		public Integer getSeat() {
			return seat;
		}
		public void setSeat(Integer seat) {
			this.seat = seat;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getScore() {
			return score;
		}
		public void setScore(Integer score) {
			this.score = score;
		}
		public Integer getHandsWon() {
			return handsWon;
		}
		public void setHandsWon(Integer handsWon) {
			this.handsWon = handsWon;
		}
		public Integer getWinStreak() {
			return winStreak;
		}
		public void setWinStreak(Integer winStreak) {
			this.winStreak = winStreak;
		}
		public ArrayList<Tile> getDiscards() {
			return discards;
		}
		public void setDiscards(ArrayList<Tile> discards) {
			this.discards = discards;
		}
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
		public boolean isHuman() {
			return isHuman;
		}
		public void setHuman(boolean isHuman) {
			this.isHuman = isHuman;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		
		
		
		
}
