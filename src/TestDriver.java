import java.math.BigInteger;

public class TestDriver 
{
	public static void main(String[] args) 
	{
		System.out.println("I am in TestDriver");
		Conversion conv = new Conversion();
		
		BigInteger bigNum  = conv.stringToBitseq("molly1");
		
<<<<<<< HEAD
		System.out.println(bigNum);
=======
		for(int i = 0; i < binaryArray.length; ++i)
			System.out.print(binaryArray[i]);
		//following line of code is for testing purpose
		Conversion.BitseqToDigitseq(binaryArray, 4);
>>>>>>> e4df0f9679980fe215c1db5bbbca126b033289af
	}

}
