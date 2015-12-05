package linkedlist;

//Single Item in the singly linked list (Node Class essentially)
public class SItem 
{
	
	private String userId;
	private String customerId;
	private SItem link;
	
	public SItem(String userId, String customerId)
	{
		this.userId = userId;
		this.customerId = customerId;
		
		link = null;
	}
	
	public String getUserId()
	{
		return userId;
	}
	
	public String getCustomerId()
	{
		return customerId;
	}
	
	public void setLink(SItem n)
	{
		link = n;
	}
	
	public SItem getLink()
	{
		return link;
	}
	
}
