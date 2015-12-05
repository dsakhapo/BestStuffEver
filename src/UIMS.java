
//This is the user ID management System

public class UIMS {

	
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
		for (int i = 0; i < input.length(); i++) 
		{
			
			//System.out.println(i);
		}
		System.out.println(hashedValue);
		
		return 0;
	}

}
