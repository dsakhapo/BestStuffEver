
public class TestDriver 
{
	public static void main(String[] args) 
	{
		System.out.println("I am in TestDriver");
		Conversion conv = new Conversion();
		
		int [] binaryArray = conv.stringToBitseq("molly1");
		
		for(int i = 0; i < binaryArray.length; ++i)
			System.out.print(binaryArray[i]);
	}

}
