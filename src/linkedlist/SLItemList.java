package linkedlist;
import java.io.*;
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
	
	public String findUser(String s)
	{
		boolean found = false;
		
		p = first;
		while (p != null)
		{
			if(p.getUserId().equals(s))
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
	
	public String findCustomer(String s)
	{
		p = first;
		while(p != null)
		{
			if(p.getUserId().equals(s))
				return p.getCustomerId();
			p = p.getLink();
		}
		return "-1";
	}
	
	public void traverse(PrintWriter pw)
	{
		p = first;
		while(p != null)
		{
			System.out.print(p.getUserId() + ", ");
			pw.print(p.getUserId() + ", ");
			p = p.getLink();
		}
	}
}
