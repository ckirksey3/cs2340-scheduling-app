
import java.applet.*; 
import java.awt.*;

public class Tournament extends Applet{

		// The method that will be automatically called  when the applet is started 
		public void init(){ 
			resize(2000, 2000);
		 // It is required but does not need anything. 
		} 
		// This method gets called when the applet is terminated 
		// That's when the user goes to another page or exits the browser. 
		public void stop()  { 
		     // no actions needed here now. 
		} 
		// The standard method that you have to use to paint things on screen 
		// This overrides the empty Applet method, you can't called it "display" for example.

		public void paint(Graphics g){ 
			
			Team UNC = new Team("North Carolina", null, 1 , 30);
			Team Duke = new Team("Duke", null, 16, 28);
			Team SYR = new Team("Syracuse", null, 8, 15);
			Team BY = new Team("Baylor", null, 9, 20);
			Team OSU = new Team("Ohio St", null, 5, 10);
			Team UK = new Team("Kentucky", null, 12, 15);
			Team UVA = new Team("Virginia", null, 4, 15);
			Team HAR = new Team("Harvard" ,null, 13, 5);
			Team UF = new Team("Florida", null, 6, 30);
			Team VT = new Team("Viginia Tech", null , 11, 41);
			Team GT = new Team("Georgia Tech", null, 3, 100);
			Team WF = new Team("Wake Forrest", null, 14 , 26);
			Team UGA = new Team("UGA", null , 7, 0);
			Team UCONN = new Team("UCONN", null, 10, 11);
			Team UCLA = new Team("UCLA", null, 2 , 27);
			Team UNLV = new Team("UNLV" , null, 15 , 24);
			Team GNZ = new Team("Gonzaga", null, 1 , 35);
			Team Army = new Team("Army", null, 16, 5);
			Team TENN = new Team("Tennesee", null, 8, 14);
			Team USC = new Team("USC", null, 9 , 16);
			Team VANDY = new Team("Vanderbilt", null, 5, 22);
			Team UM = new Team("Miami", null, 12, 25);
			Team CLEM = new Team("Clemson", null, 4 , 30);
			Team TCU = new Team("TCU", null, 13, 40);
			Team SMU = new Team("SMU", null, 6, 12);
			Team MRH = new Team("Morehouse", null, 11, 30);
			Team UT = new Team("Texas", null, 3, 23);
			Team PRD = new Team("Purdue", null, 14 , 40);
			Team FLST = new Team("Florida St", null, 7, 11);
			Team LSU = new Team("LSU", null, 10, 10);
			Team BAMA = new Team("Alabama", null, 2, 19);
			Team ARK = new Team("Arkansas", null, 15, 2);
			Team MST = new Team("Michigan St", null, 1 , 30);
			Team RICE = new Team("Rice", null, 16, 40);
			Team MICH = new Team("Michigan", null, 8, 23 );
			Team MARQ = new Team("Marquettte", null, 9, 15);
			Team WVU = new Team("West Virginia", null, 5, 11);
			Team RUT = new Team("Rutgers", null, 12, 22);
			Team PITT = new Team("Pittsburgh", null, 4, 40);
			Team PRNC = new Team("Princeton", null, 13, 22);
			Team CAL = new Team("California", null, 6, 22);
			Team ARZ = new Team("Arizona", null, 11, 1);
			Team COL = new Team("Colorado", null, 3, 18);
			Team AZST = new Team("Arizona St", null, 14, 19);
			Team TAM = new Team("Texas A&M", null, 7, 10);
			Team MIZZ= new Team("Missouri", null, 10, 23);
			Team WIS= new Team("Wisconsin", null, 2, 32);
			Team ILL = new Team("Illinois", null, 15, 11);
			Team IOWA= new Team("Iowa", null, 1, 5);
			Team TROY = new Team("Troy", null, 16, 3);
			Team NCST= new Team("North Carolina St", null, 8, 19);
			Team ORG = new Team("Oregon", null, 9, 5);
			Team SDST = new Team("San Diego St", null, 5, 8);
			Team BUT = new Team("Butler", null, 12, 14);
			Team MURST= new Team("Murray St", null, 4, 16);
			Team STAN= new Team("Stanford", null, 13, 32);
			Team WASH= new Team("Washington", null, 6, 33);
			Team WASHST= new Team("Washington St", null, 11, 32);
			Team MISS = new Team("Missisippi", null, 3, 14);
			Team VCU = new Team("VCU", null, 14, 19);
			Team IND = new Team("Indiana", null, 7, 48);
			Team MINN = new Team("Minnesota", null, 10, 44);
			Team ECU = new Team("Eastern Carolina", null, 2, 11);
			Team UCF= new Team("UCF", null, 15, 13);

			
			Team[] teamArray = {UNC, Duke, SYR, BY, OSU, UK, UVA, HAR, UF, VT, GT, WF, UGA,
					UCONN, UCLA, UNLV, GNZ, Army, TENN, USC, VANDY, UM, CLEM, TCU, SMU, MRH,
					UT, PRD, FLST, LSU, BAMA, ARK,	//first 32 teams are above
					MST, MICH, RICE, MARQ, WVU, RUT, PITT, PRNC, CAL, ARZ, AZST, COL, TAM,
					MIZZ, WIS, ILL, IOWA, TROY, NCST, ORG, SDST, BUT, MURST, STAN, WASH, WASHST,
					MISS, VCU, IND, MINN, ECU, UCF};
			
			Team.rankTeams(teamArray);
			
			Global.teamIndex = 0;
			Game semi1 = InitializeTournament(teamArray);
			Game semi2 = InitializeTournament(teamArray);
			
			semi1.playTournament();
			semi2.playTournament();
			
			Game champ = new Game(null);
			champ.setTeam1(semi1.getWinner());
			champ.setTeam2(semi2.getWinner());
			champ.playGame();
			
			
			Dimension appletSize = this.getSize();
		    int appH = appletSize.height;
			int appW = appletSize.width;
			int rW = 70;		// length of a rect
			int rH = 25;		// height of a rect
			int spacing = 0;	//space between game nodes
			int lineLength = 40;
			semi1.drawGame(g, appW/2 + lineLength + rW , appH/2, rH, rW, spacing, lineLength);
			semi2.drawGameLeft(g, appW/2 - lineLength - 2*rW, appH/2, rH, rW, spacing, lineLength);
			champ.drawChamp(g, appW/2 - rW/2, appH/2, rH, rW, rW);
		}
		
		public Game InitializeTournament(Team[] teams)
		{
			Game championship = new Game(null);
			championship.createGames(teams);
			return championship;
		}
		
}


