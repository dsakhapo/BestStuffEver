package driver.helper.classes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import driver.helper.classes.Conversion;
import hashing.HashEntry;


//This is the user ID management System

public class UIMS 
{
	private Conversion conv;
	private HashEntry[] userT;
	private int cid;
	private int[] binaryArray;		//userId's binary array
	
	public UIMS()
	{
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
			return false;
	}
	
	//This method will add a new userId to the hash table
	public void add(String uid) 
	{
		int hashValue = hash(uid);					//Get the hash value
		
		if(userT[hashValue] == null)
		{
			++cid;
			String custId = Integer.toString(cid);
			userT[hashValue] = new HashEntry(uid, custId);
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
			return userT[hashValue].getCustomerId();		
	}
	
	//This method will hash the userId and return the hash value
	public int hash(String uid)
	{
		BigInteger hashFunction;
		
		BigDecimal modValue = BigDecimal.valueOf(Math.pow(2, binaryArray.length));
		BigDecimal denominator = BigDecimal.valueOf(Math.pow(2, binaryArray.length) / Math.pow(2, 10));
		BigInteger mValue = modValue.toBigInteger();
		BigInteger denom = denominator.toBigInteger();
		
		BigInteger userId, salt;
		binaryArray = conv.stringToBitseq(uid);		//Get the userId's binary array
		
		userId = conv.bitSeqToBigNum(binaryArray);		//Convert the binary array to a BigInt
		salt = generateSalt(10, binaryArray.length);	//Get a random BigInt to hash with
		
		hashFunction = (((salt.multiply(userId)).mod(mValue)).divide(denom));
		
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

}
