package driver.helper.classes;
import java.math.BigInteger;
import java.util.Random;


//This is the user ID management System

public class UIMS {
	private Conversion ConObject;
	Random randomGenerator;
	
	public UIMS() {
		ConObject = new Conversion();
		randomGenerator = new Random();
	}

	
	public static Boolean isAvailable(String uid)
	{
		return null;
		//returns true is the uid is available, false otherwise
	}
	
	
	public static void add(String uid) 
	{
		//precondition: uid is avaliable and customerId = cid
		//postcondition: uid is in hash table userT associated with cid
		//and customerId = cid + 1
	}
	
	
	public static int lookUpCustomerId(String uid) 
	{
		//return the customer id associated with user id uid
		//return 0 if uid is not an assigned user id
		return 0;
	}
	//This is the hash function that will return the index number
	public static int hash(String input) 
	{
		int hashedValue = 0;
		
		return hashedValue;
	}
	
	
	//This function returns a string of binary of salt
	public BigInteger generateSalt(int k){
		int IntArraySize = 6; //this line and the next line should change to find the size of the binary array for saltInBits, in order
		int[] salt = new int[IntArraySize]; //to fix it, we will add one more argument for IntArraySize and pass in from TestDriver
		int randomInt = 0;
		
		
		for (int i = 0; i < salt.length; i++) {
			randomInt = randomGenerator.nextInt(k);
			//This guarantees that all integers in salt are odd number
			while (randomInt%2 == 0){
				randomInt = randomGenerator.nextInt(k);
			}
			salt[i] = randomInt; //this generate a salt array filled with num
			System.out.println(salt[i]); //this prints out num in salt
		}
			System.out.println("=======");
			int[] tempArray = new int[6]; //this will temporarily hold 6 bits of on salt int array
			int[] saltInBits = new int[salt.length*6]; //this will hold all bits of salt int array
			int saltInBitsCounter = 0;
		for (int j = 0; j < salt.length; j++) {
			tempArray = ConObject.numToBitSeq(salt[j]);
			for (int l = 0; l < tempArray.length; l++) {
				saltInBits[saltInBitsCounter] = tempArray[l];
				System.out.print(tempArray[l]);
				
			}
		}
		System.out.println(" ");
		System.out.println(ConObject.bitSeqToBigNum(saltInBits));
		return (ConObject.bitSeqToBigNum(saltInBits));
		
	}

}
