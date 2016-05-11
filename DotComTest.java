public class SimpleDotComTest{
	public static void main (String[] args){
			SimpleDotCom dotCom = new SimpleDotCom();
			int [] locations = {1,2,3};
			dotCom.setLocationCells(locations);
			String userGuess = "1";
			
			String result = dotCom.checkYourself(userGuess);
			String testResult = "failed";
			if(result.equals("hit")){
				testResult = "passed";
			}
			System.out.println(testResult);
	}
	
}