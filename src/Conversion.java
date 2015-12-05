

//This is helper class for hash function
public class Conversion {
	public static int[] stringToBitseq(String inputString){
		int[] binaryArray = new int[inputString.length() * 6];

		for (int oneCharCounter = 0; oneCharCounter < inputString.length(); oneCharCounter++) {
			char oneChar = inputString.charAt(oneCharCounter);
			int customizedAsciiValue = getCustomizedAsciiValue(oneChar);
			String binaryInString = Integer.toBinaryString(customizedAsciiValue);
			//here I should convert to array of binary and insert into binaryArray
			
			System.out.println(customizedAsciiValue);
			System.out.println(binaryInString);
		}
		return binaryArray;
	}
	
	public static int[] BitseqToDigitseq(int[] bs, int k){
		
		return bs;
	}
	
	
	
	
	
	
	
	
	
	public static int getCustomizedAsciiValue(char oneCharacter){
		int asciiValue = (int)oneCharacter;
		if (asciiValue >= 48 && asciiValue <= 57){
			asciiValue -= 47;
		} 
		else if (asciiValue >= 97 && asciiValue <= 122){
			asciiValue -= 86;
		}
		else if (asciiValue >= 65 && asciiValue <= 90){
			asciiValue -= 28;
		}
		else asciiValue = 0;
		
		return asciiValue;
	}
}
