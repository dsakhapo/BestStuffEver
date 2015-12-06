package driver.helper.classes;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class TestDriver 
{
	public static void main(String[] args) throws IOException 
	{
		System.out.println("I am in TestDriver");
		Conversion conv = new Conversion();
		
		BigInteger bigNum  = conv.stringToBitseq("molly1");
		
		System.out.println(bigNum);
		
		UIMS uObj = new UIMS();
		
		uObj.generateSalt(10);

		

		///////////////////////////////
		FileInputStream fstream = new FileInputStream("INPUT");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  System.out.println (strLine);
		}
		//Close the input stream
		br.close();
		
		
	}

}
