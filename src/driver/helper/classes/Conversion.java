package driver.helper.classes;
import java.math.BigInteger;

import sun.security.action.GetBooleanAction;

import java.lang.Math;

//This is helper class for hash function
public class Conversion 
{
	//This method will convert a string to an array of binary numbers and return that array
	public BigInteger stringToBitseq(String inputString)		
	{
		//int[] binaryArray = new int[inputString.length() * 6];	//Each character will be represented by 6 bits
		int[] binaryArray = new int[inputString.length() * 6];	

		int i = 0;

		for (int oneCharCounter = 0; oneCharCounter < inputString.length(); oneCharCounter++) 
		{
			int customizedAsciiValue = getCustomizedAsciiValue(inputString.charAt(oneCharCounter));	//Will convert each character to a customized Ascii value and store it
			int[] bitSeq = numToBitSeq(customizedAsciiValue);	//Will convert each customized Ascii value to a 6 bit binary number
			
			for(int j = 0; j < bitSeq.length; ++j)
			{
				binaryArray[i] = bitSeq[j];
				++i;
			}
		}
		BigInteger bigNum = bitSeqToBigNum(binaryArray);
		return bigNum;
	}
	
		//This method will convert each character to their customized ascii value, which is mapped for us in the assignment
		public int getCustomizedAsciiValue(char oneCharacter)
		{
			int asciiValue = (int)oneCharacter;
			
			if (asciiValue >= 48 && asciiValue <= 57)	//Convert integer characters to their customized ascii value
				asciiValue -= 47;
		
			else if (asciiValue >= 97 && asciiValue <= 122)		//Convert lower-case characters to their customized ascii value
				asciiValue -= 86;
			
			else if (asciiValue >= 65 && asciiValue <= 90)		//Convert upper-case characters to their customized ascii value
				asciiValue -= 28;
			
			else asciiValue = 0;	//This will execute for characters that aren't in the set of characters allowed; used for error-checking
			
			return asciiValue;
		}
		
		//This method will convert each customized ascii value to binary, and store each digit in the bitSeq array
		public int[] numToBitSeq(int customizedAsciiValue)
		{
			int[] bitSeq = new int[6];
			int remainder = 0;
			
			for (int i = 0; i < bitSeq.length; i++)
				bitSeq[i] = 0;
			
			int i = 5;
			while(customizedAsciiValue > 0)
			{
				remainder = customizedAsciiValue % 2;
				customizedAsciiValue /= 2;
					
				bitSeq[i] = remainder;
				--i;
			}
			return bitSeq;
		}
		
		//Convert the binary number to a large integer
		public BigInteger bitSeqToBigNum(int[] bitSeq)
		{
			BigInteger bigNum = new BigInteger("0");
			
			int j = 0;
			for (int i = bitSeq.length - 1; i >= 0; --i)
			{
				bigNum = bigNum.add(BigInteger.valueOf((long)(bitSeq[j] * Math.pow(2, i))));
				++j;
			}
			return bigNum;
			
		}
	
	//This method will convert the array of binary numbers, and this time group them up by 4 bits (k = 4), and convert them to digits
	public static int[] bitSeqToDigitSeq(int[] bitSequence, int k)
	{
		int[] digitSequenceArray = new int[bitSequence.length/k];
		int[] tempArray = new int[k];
		
		int digitArrayCounter = 0;
		int bitSeqenceCounter = 0;
		
		while (bitSeqenceCounter < bitSequence.length) 
		{
			for (int i = 0; i < k; i++) 
			{
				tempArray[i] = bitSequence[bitSeqenceCounter];
				bitSeqenceCounter++;
			}
		
			int num = 0;
			for (int j = 0; j < tempArray.length;j++) 
				num += tempArray[j]*(Math.pow(2, tempArray.length-1-j));
			
			System.out.println(num);
			digitSequenceArray[digitArrayCounter] = num;
			digitArrayCounter++;
		}
		return digitSequenceArray;
	}
	
}
