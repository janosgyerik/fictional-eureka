import java.io.BufferedReader;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	
	public void doIt()throws FileNotFoundException, IOException {
		  Chained ctable = new Chained();
	        BufferedReader rd = new BufferedReader( new FileReader ("pg345.txt"));
	        String line = "";
	        while ((line = rd.readLine())!= null){
	        	String[] parts = line.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
	        	//System.out.println(Arrays.toString(parts));
	        	 for  (String j: parts ){
	 	        	ctable.Add(j);
	 	        }
	        }
	        System.out.println(ctable);


//		Chained ctable = new Chained();
//		//first change this to only take one arguement		
//		ctable.Add("Vic");
//		ctable.Add("Whc");
//		ctable.Add("Dic");
//		ctable.Add("Phc");
//		ctable.Add("Something");
//		ctable.Add("Joe");
//		ctable.Add("Ed");
//		ctable.Add("Fred");
//		System.out.println(ctable);
		//System.out.println(ctable.getLongestChain(name));
		//System.out.println(ctable.getLongestChain("something"));
//		
	}

}
