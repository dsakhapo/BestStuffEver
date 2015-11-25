package com.darius.linkedlist;

import java.util.Scanner;

public class LinearLinkedList 
{
	public static void main(String args[])
	{
		List list = new List();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello!, Welcome to my Linked List, below you will find various options.\n\n");
		while(true)
		{
			list.menu();
		
			switch(input.nextInt())
			{
				case(1): System.out.print("\nEnter a value that'd you like at the front of the list: ");
					 	 list.insertAtBeg(new Node(), input.nextInt());
					 	 System.out.println();
					 	 break;
					 
				case(2): System.out.print("\nEnter a value that'd you like at the end of the list: ");
					 	 list.insertAtEnd(new Node(), input.nextInt());
					 	 System.out.println();
					 	 break;
					 
				case(3): System.out.print("\nEnter the position at which you'd like to insert: ");
					 	 int insp = input.nextInt();	//insert position
					 	 System.out.print("\nEnter the value you'd like at this position: ");
					 	 list.insertAtPos(new Node(), insp, input.nextInt());
					 	 System.out.println();
					 	 break;
					 
				case(4): System.out.print("\nEnter the position at which you'd like to delete: ");
					 	 list.deleteAtPos(input.nextInt());
					 	 System.out.println();
					 	 break;
					 
				case(5): list.displayList();
						 System.out.println();
						 break;
			
				case(0): System.exit(0);
		    
				default: break;
					
			}
		
		}
	
	}
}
