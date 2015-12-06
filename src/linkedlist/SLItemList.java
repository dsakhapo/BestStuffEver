package linkedlist;
//Singly Linked Item List
public class SLItemList 
{
	private SItem first, p;
	
	public SLItemList()
	{
		first = p = null;
	}
	
	public void pushFront(SItem n)
	{
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
		boolean found = false;
		
		p = first;
		while (p != null)
		{
			if(p.getUserId().equals(s) || p.getCustomerId().equals(s))
			{
				found = true;
				break;
			}
			p = p.getLink();
		}
		
		if(found == true)
			return s;
		else
			return "-1";
	}
}
