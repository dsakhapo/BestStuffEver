package linkedlist;
//Singly Linked Item List
public class SLItemList 
{
	private SItem n, first, p;
	
	public SLItemList()
	{
		n = first = p = null;
	}
	
	public void pushFront(SItem n)
	{
		this.n = n;
		n.setLink(null);
		
		if(first == null)
			first = n;
		else
		{
			n.setLink(first);
			first = n;
		}
	}
	
	public String find(String s)
	{
		boolean match = false;
		String notFound = "The user Id or customer Id was not found";
		
		p = first;
		while (p != null)
		{
			if(p.getUserId().equals(s) || p.getCustomerId().equals(s))
			{
				match = true;
				break;
			}
			p = p.getLink();
		}
		if(match == false)
			return notFound;
		else
			return s;
	}
}
