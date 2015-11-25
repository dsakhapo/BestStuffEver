package linkedlist;

public class Node 
{
	private Node link;
	private int data;
	
	public Node()
	{
		link = null;
	}
	
	public Node(int d, Node n)
	{
		link = n;
		data = d;
	}
	
	public void setData(int d)
	{
		data = d;
	}
	
	public int getData()
	{
		return data;
	}
	
	public void setLink(Node n)
	{
		link = n;
	}
	
	public Node getLink()
	{
		return link;
	}
}
