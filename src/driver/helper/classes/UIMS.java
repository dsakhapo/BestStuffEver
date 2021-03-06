package driver.helper.classes;
import java.math.BigInteger;
import java.util.Random;
import driver.helper.classes.Conversion;
import hashing.HashEntry;
import java.io.*;

//This is the user ID management System

public class UIMS 
{
	private Conversion conv;
	private HashEntry[] userT;
	private int cid;
	private int[] binaryArray;		//userId's binary array
	private PrintWriter pw;
	
	public UIMS(PrintWriter pw)
	{
		this.pw = pw;
		userT = new HashEntry[1024];
		cid = 0;
		conv = new Conversion();
		
		for(int i = 0; i < userT.length; ++i)
			userT[i] = null;
	}
	
	//This method will check to see if a userId is available for use
	public Boolean isAvailable(String uid)
	{
		int hashValue = hash(uid);
		
		if(userT[hashValue] == null)
			return true;
		else
		{
			String userId = userT[hashValue].findUserId(uid);
			if(userId.equals("-1"))
				return true;
			else
				return false;
		}
	}
	
	//This method will add a new userId to the hash table
	public void add(String uid) 
	{
		int hashValue = hash(uid);					//Get the hash value
		
		if(userT[hashValue] == null)
		{
			++cid;
			String custId = Integer.toString(cid);
			userT[hashValue] = new HashEntry(uid, custId, pw);
		}
		else
		{
			++cid;
			String custId = Integer.toString(cid);
			userT[hashValue].store(uid, custId);
		}
	}
	
	//This method will return the customerId associated with the userId, or return 0 the userId doesn't exist
	public String lookUpCustomerId(String uid) 
	{
		int hashValue = hash(uid);
		
		if(userT[hashValue] == null)		//If the userId doesn't exist, return "-1"
			return "-1";
		else
		{
			return userT[hashValue].findCustomerId(uid);
		}
	}
	
	//This method will hash the userId and return the hash value
	public int hash(String uid)
	{
		BigInteger userId, salt, compare;
		
		binaryArray = conv.stringToBitseq(uid);
		userId = conv.bitSeqToBigNum(binaryArray);		//Convert the binary array to a BigInt
		salt = generateSalt(50, binaryArray.length);	//Get a random BigInt to hash with
		compare = new BigInteger("1");
		
		BigInteger hashFunction;
		
		BigInteger exp = new BigInteger("2");
		BigInteger modValue = exp.pow(binaryArray.length);
		
		BigInteger tableSize = exp.pow(10);
		BigInteger denominator = modValue.divide(tableSize);
		if(denominator.compareTo(compare) == -1)
			denominator = new BigInteger("1");
			
		
		hashFunction = (((salt.multiply(userId)).mod(modValue)).divide(denominator));
		
		return hashFunction.intValue();
		
	}
	
	
	
	public BigInteger generateSalt(int k, int binaryArraySize)
	{
		Random randomGenerator = new Random();
		int[] salt = new int[binaryArraySize / 6]; //to fix it, we will add one more argument for IntArraySize and pass in from TestDriver
		int randomInt = 0;
		
		
		for (int i = 0; i < salt.length; i++) 
		{
			randomInt = randomGenerator.nextInt(k);
			//This guarantees that all integers in salt are odd number
			while (randomInt % 2 == 0)
				randomInt = randomGenerator.nextInt(k);
			
			salt[i] = randomInt; //this generate a salt array filled with num
		}
			int[] tempArray = new int[6]; //this will temporarily hold 6 bits of on salt int array
			int[] saltInBits = new int[binaryArraySize]; //this will hold all bits of salt int array
			int saltInBitsCounter = 0;					//Act as an index in the salt bit array
			
		for (int j = 0; j < salt.length; j++) 
		{
			tempArray = conv.numToBitSeq(salt[j]);
			for (int l = 0; l < tempArray.length; l++) 
			{
				saltInBits[saltInBitsCounter] = tempArray[l];
				++saltInBitsCounter;
			}
		}
		return conv.bitSeqToBigNum(saltInBits);
	}
	
	public void outputTable()
	{
		for(int i = 0; i < userT.length; ++i)
		{
			if(userT[i] != null)
			{
				System.out.print(i + " - ");
				pw.print(i + " - ");
				userT[i].printAllItems();
				System.out.print("\n");
				pw.print("\r\n");
			}
		}
	}

}
