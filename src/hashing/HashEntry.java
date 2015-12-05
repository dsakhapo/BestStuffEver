package hashing;
import linkedlist.SItem;
import linkedlist.SLItemList;

public class HashEntry 
{
	private String userId;
	private String customerId;
	private SItem n;			//pointer p to traverse the list
	private SLItemList list;
	
	public HashEntry(String userId, String customerId)
	{
		list = new SLItemList();
		n = new SItem(userId, customerId);
		list.pushFront(n);
	}
	
	public String getUserId()
	{
		userId = list.find(userId);
		return userId;
	}
	
	public String getCustomerId()
	{
		customerId = list.find(customerId);
		return customerId;
	}
	
	public void store(String userId, String customerId)
	{
		n = new SItem(userId, customerId);
		list.pushFront(n);
	}
	
}
