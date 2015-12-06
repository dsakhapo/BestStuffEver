package hashing;
import linkedlist.SItem;
import linkedlist.SLItemList;
import java.io.*;

public class HashEntry 
{
	private String userId;
	private String customerId;
	private SItem n;			//pointer p to traverse the list
	private SLItemList list;
	private PrintWriter pw;
	
	public HashEntry(String userId, String customerId, PrintWriter pw)
	{
		this.pw = pw;
		list = new SLItemList();
		n = new SItem(userId, customerId);
		list.pushFront(n);
	}
	
	public String findUserId(String uid)
	{
		userId = list.findUser(uid);
		return userId;
	}
	
	public String findCustomerId(String uid)
	{
		customerId = list.findCustomer(uid);
		return customerId;
	}
	
	public void store(String userId, String customerId)
	{
		n = new SItem(userId, customerId);
		list.pushFront(n);
	}
	
	public void printAllItems()
	{
		list.traverse(pw);
	}
	
}
