package driver.helper.classes;
import java.math.BigInteger;


public class TestDriver 
{
	public static void main(String[] args) 
	{
		System.out.println("I am in TestDriver");
		Conversion conv = new Conversion();
		
		BigInteger bigNum  = conv.stringToBitseq("molly1");
		
		System.out.println(bigNum);

	}

}
