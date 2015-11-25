package linkedlist;

public class List 
{
	private Node p;
	private Node first;
	private Node last;
	
	public List()
	{
		p = null;
		first = null;
		last = null;
	}
	
	public void insertAtBeg(Node n, int data)
	{
		n.setData(data);
		n.setLink(null);
		
		if(isEmpty())
		{
			first = n;
			last = n;
		}
		else
		{
			n.setLink(first);
			first = n;
		}
	}
	
	public void insertAtEnd(Node n, int data)
	{
		n.setData(data);
		n.setLink(null);
		
		if(isEmpty())
		{
			first = n;
			last = n;
		}
		
		else
		{
			p = first;
			
			while(p.getLink() != null)
				p = p.getLink();
			p.setLink(n);
		}
		
		//Always have last point to the last node
		if(last.getLink() != null)
		{
			while(last.getLink() != null)
				last = last.getLink();
		}
			

	}
	
	public void insertAtPos(Node n, int position, int data)
	{
		int counter = 1;
		p = first;
		
		//If the position doesn't make sense
		if(position > numOfElements() + 1 || position <= 0)
			System.out.println("Invalid position.");
		
		else
		{
			n.setData(data);
			n.setLink(null);
			
			p = first;
			Node q = first;
			while(counter != position)
			{
				q = q.getLink();
				++counter;
			}
			
			while(p.getLink() != q)
				p = p.getLink();
			p.setLink(n);
			n.setLink(q);
			
		}
		
	}
	
	public void deleteAtPos(int position)
	{
		int counter = 1;
		
		//If the position doesn't make sense
		if(position > numOfElements() || position <= 0)
			System.out.println("Invalid position.");
		
		else
		{
			p = first;
			Node q = first;
			if(counter == position)
			{
				//If you want to delete the first position and there's only 1 node in the list
				if(p.getLink() == null)
					first = null;
				//If there's 2 or more nodes
				else
				{
					first = first.getLink();
					p.setLink(null);
					p = first;
				}
			}
			else
			{
				while(counter != position)
				{
					q= q.getLink();
					++counter;
				}
			
				while(p.getLink() != q)
					p = p.getLink();
			
				if(q.getLink() == null)
					p.setLink(null);
				else
				{
					p.setLink(q.getLink());
					q.setLink(null);
				}
			}
		}
			
		
	}
	
	public int numOfElements()
	{
		int counter = 1;
		
		if(isEmpty())
			return 0;
		else
		{
			p = first;
			while(p.getLink() != null)
			{
				p = p.getLink();
				++counter;
			}
			return counter;
		}
		
	}
	
	public void displayList()
	{
		if(isEmpty())
			System.out.println("\nThe list is empty, nothing to display.");
		else
		{
			p = first;
			
			System.out.print("\n");
			while(p != null)
			{
				System.out.print("| " + p.getData() + " | ---> ");
				p = p.getLink();
			}
			System.out.print("\n");
		}
		
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public void menu()
	{
		System.out.println("1 - Add a value to the front of the list.");
		System.out.println("2 - Add a value to the end of the list.");
		System.out.println("3 - Insert a value at a position.");
		System.out.println("4 - Delete a value at a position.");
		System.out.println("5 - Display the linked list.");
		System.out.println("Press '0' to exit the program.");
	}


}
