package driver.helper.classes;
import java.io.*;
import java.util.Scanner;

public class TestDriver 
{
	public static void main(String[] args) throws IOException
	{
		Scanner fileScan = new Scanner(new File("INPUT"));
		PrintWriter pw = new PrintWriter(new FileWriter("OUTPUT"));
		
		UIMS ui = new UIMS(pw);
		String userId;
		
		while(fileScan.hasNext())
		{
			userId = fileScan.nextLine();

			if(ui.isAvailable(userId))
				ui.add(userId);
			else
			{
				System.out.println("The requested User Id is not available.");
				pw.println("The requested User Id is not available.");
			}
			
		}
		
		ui.outputTable();
		pw.close();
		fileScan.close();
		
		
	}

}
