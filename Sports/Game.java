import java.awt.Graphics;


public class Game {
		
	private Team team1;		
	private Team team2;
	private Team winner;
	private Game nextGame;
	private Game prevGame1;
	private Game prevGame2;
	
	public Game(Game nextGame){
		this.nextGame = nextGame;

	}
	
	
	public void playGame(){
		// determine which team one
		if (team1.getOverallScore() >= team2.getOverallScore())
			this.setWinner(team1);
		else
			this.setWinner(team2);
		// advance them to the next round
		advance(this.winner);
	}
	
	public void advance(Team winner){
		if (this.nextGame == null)	// check for null (if its the championship game)
			return;
		if (this.nextGame.getTeam1() == null) 
			this.nextGame.setTeam1(winner);		
		else if (this.nextGame.getTeam2() == null)
			this.nextGame.setTeam2(winner);
		return;
	}
	
	public void drawChamp(Graphics g, int x, int y, int height, int width, int lineLength){
		g.drawRect(x, y, width, height);
		g.drawString(this.team1.getSeed()+ " " +this.team1.getName(), x, y);
		g.drawString(this.team2.getSeed()+ " " +this.team2.getName(), x, y+height);
		
		g.drawLine(x + width, y+ (height/2), x + width + lineLength, y + (height/2));
		g.drawLine(x, y + (height/2), x - lineLength, y + (height/2));
		
		g.drawLine(x + width/2, y, x+width/2, y-2*lineLength);
		g.drawRect(x, y-2*lineLength-height, width, height);
		g.drawString(this.getWinner().getSeed() +" " + this.getWinner().getName(), x, y-2*lineLength-height);
	}
	
	public void drawGame(Graphics g, int x, int y, int height, int width, int spacing, int lineLength){ 
		//right half of bracket
		g.drawRect(x,y,width,height);
		if(this.team1 != null){
			g.drawString(this.team1.getSeed()+ " " +this.team1.getName(), x, y);
		}
		
		if(this.team2 != null){
			g.drawString(this.team2.getSeed()+ " " +this.team2.getName(), x, y + height);
		}
		
		int round = Global.maxRound - this.getRound() -2; // should be a 1. the two allows it to fit on the screen
		if(this.prevGame2 != null)
		{
			g.drawLine(x+width,y+(height/2),x+width+lineLength,y+(height/2)+(height*((int)Math.pow(2, round))));
			prevGame2.drawGame(g, x+width+lineLength, y+((height)*((int)Math.pow(2, round))) , height, width, spacing, lineLength);
		}
		
		if(this.prevGame1 != null)
		{
			g.drawLine(x+width,y+(height/2),x+width+lineLength,y+(height/2)-(height*((int)Math.pow(2, round))));
			prevGame1.drawGame(g, x+width+lineLength, y-((height)*((int)Math.pow(2, round))), height, width, spacing, lineLength);
		}
		
		
	}
	
	//left half of bracket
	public void drawGameLeft(Graphics g, int x, int y, int height, int width, int spacing, int lineLength){ 
		g.drawRect(x,y,width,height);
		if(this.team1 != null){
			g.drawString(this.team1.getSeed()+ " " +this.team1.getName(), x, y);
		}
		
		if(this.team2 != null){
			g.drawString(this.team2.getSeed()+ " " +this.team2.getName(), x, y + height);
		}
		int round = Global.maxRound - this.getRound() -2; // should be a 1. the two allows it to fit on the screen
		if(this.prevGame2 != null)
		{
			g.drawLine(x,y+(height/2),x-lineLength,y+(height/2)+(spacing+height*((int)Math.pow(2, round))));
			prevGame2.drawGameLeft(g, x-width-lineLength, y+(spacing+(height)*((int)Math.pow(2, round))) , height, width, spacing, lineLength);
		}
		
		if(this.prevGame1 != null)
		{
			g.drawLine(x,y+(height/2),x-lineLength,y+(height/2)-(spacing+height*((int)Math.pow(2, round))));
			prevGame1.drawGameLeft(g, x-width-lineLength, y-(spacing+(height)*((int)Math.pow(2, round))), height, width, spacing, lineLength);
		}

	}
	
	public Team getTeam1() {
		return team1;
	}
	
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
		
	public Team getTeam2() {
		return team2;
	}
	
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	
	public Team getWinner() {
		return winner;
	}
	
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
	public Game getNextGame() {
		return nextGame;
	}
	
	public void setNextGame(Game nextGame) {
		this.nextGame = nextGame;
	}
	
	public Game getPrevGame1() {
		return prevGame1;
	}
	
	public void setPrevGame1(Game prevGame1) {
		this.prevGame1 = prevGame1;
	}
	
	public Game getPrevGame2() {
		return prevGame2;
	}
	
	public void setPrevGame2(Game prevGame2) {
		this.prevGame2 = prevGame2;
	}

	/* JEff's Get Round
	 */
	public int getRound(){
		int i =0;
		Game probe = this;
		while (probe.getNextGame()!=null){
			i++;
			probe=probe.getNextGame();
		}
		return i;
	}
	

	public void createGames(Team[] teams){
		if (this.getRound() < Global.maxRound-1){
			this.setPrevGame1(new Game(this));
			this.setPrevGame2(new Game(this));
			this.getPrevGame1().createGames(teams);
			this.getPrevGame2().createGames(teams);
		}
		
		if (this.getRound() == Global.maxRound-1){
			this.setTeam1(teams[Global.teamIndex]);
			Global.teamIndex++;
		}
		if (this.getRound() == Global.maxRound-1){
			this.setTeam2(teams[Global.teamIndex]);
			Global.teamIndex++;
		}
		
	}
	
	public void playTournament(){
		if (this.getRound() < Global.maxRound-1){
			this.prevGame1.playTournament();
			this.prevGame2.playTournament();
			this.playGame();
		}
		else
			this.playGame();
	}
		

	/*
	public int getRound(){
		Game currentPrevGame1 = this.prevGame1;
		Game currentPrevGame2 = this.prevGame2;
		Game temp = null;
		int roundsPlayed = 0;
		while(currentPrevGame1 != null || currentPrevGame2 != null)
		{
			if(currentPrevGame1 != null)
			{
				temp = currentPrevGame1.prevGame1;
				currentPrevGame2 = currentPrevGame1.prevGame2;
				currentPrevGame1 = temp;
				roundsPlayed++;
			}
			else
			{
				temp = currentPrevGame2.prevGame1;
				currentPrevGame2 = currentPrevGame2.prevGame2;
				currentPrevGame1 = temp;
				roundsPlayed++;
			}
		}
		return roundsPlayed;
	}*/
	
	
	}

