import java.util.*;

public class DotComBust {
		private GameHelper helper = new GameHelper();
		private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
		private int numOfGuesses=0;
		
		public void setUpGame(){
			DotCom dotCom0 = new DotCom();	
			DotCom dotCom1 = new DotCom();
			DotCom dotCom2 = new DotCom();
			
			dotCom0.setName("booble.com");
			dotCom1.setName("yippee.com");
			dotCom2.setName("hornpub.com");
			
			dotComsList.add(dotCom0);
			dotComsList.add(dotCom1);
			dotComsList.add(dotCom2);
			
			System.out.println("Your goal is to sink 3 dot coms.");
			System.out.println(dotCom0.getName() + dotCom1.getName() + dotCom2.getName());
			System.out.println("Try to sink them all in the fewest number of guesses");
			
			for(DotCom dotComToSet : dotComsList){
				ArrayList<String> newLocation = helper.placeDotCom(3);
				dotComToSet.setLocationCells(newLocation);
			}
			
		}
		
		public void startPlaying(){
			while (!dotComsList.isEmpty()){
				String userGuess = helper.getUserInput("Enter a guess");
				checkUserGuess(userGuess);
			}
			finishGame();
		}
		
		public void checkUserGuess(String userGuess){
			numOfGuesses++;
			String result = "miss";
			for(DotCom dotComToTest : dotComsList){
				result = dotComToTest.checkYourself(userGuess);
				
				if(result.equals("hit")){
					break;
				}
				if(result.equals("kill")){
					dotComsList.remove(dotComToTest);
					break;
				}
			} 
			System.out.println(result);
		}
		
		public void finishGame(){
			System.out.println("GAME OVER");
			if(numOfGuesses <= 18){
				System.out.println("Sharpshooter! It took you " + numOfGuesses + " guesses");
			} else {
				System.out.println("check your sights. It took you " + numOfGuesses + " guesses");
			}
		}
		
		public static void main (String args[]){
			DotComBust game = new DotComBust();
			game.setUpGame();
			game.startPlaying();
			
		}
}