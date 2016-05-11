import java.util.ArrayList;

public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
		
	public void setLocationCells(ArrayList<String> loc){
		locationCells = loc;
	}
	
	public String checkYourself(String guess){
		String result = "miss";
		int index = locationCells.indexOf(guess);
		if (index>=0){
			locationCells.remove(index);
			if (locationCells.isEmpty()){
				result="kill";
				System.out.println("You sunk " + name);
			} else {
				result="hit";
			}
		}
		return result;
	}
		
	public String getName () {
		return name;
	}
	public void setName(String n){
		name = n;
	}
}