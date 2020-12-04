
//impliment the  doubly linkedlist in java


import java.lang.*;

import java.util.*;

class Node
{
	public int data;

	public Node next;

	public Node prev;

	public Node(int value)
	{
		data=value;

		next=null;

		prev=null;
	}
}

class Doubly_List
{
	public Node Head;

	public Doubly_List()
	{
		Head=null;

	}

	public void InsertFirst(int no)
	{
		Node newn=new Node(no);

		newn.next=null;

		newn.prev=null;

		if(Head == null)
		{
			Head=newn;
		}

		else
		{
			newn.next=Head;

			Head.prev=newn;

			Head=newn;
		}

	}

	public void DisplayForward()
	{
		Node temp=Head;

		System.out.println("list in forward manner");

		while(temp != null)
		{
			System.out.print(temp.data +"-->");
			temp=temp.next;
		}

		System.out.println("NULL");
	}

	 public void DisplayBackward()
        {
                Node temp=Head;

                System.out.println("list in backward manner");

		while(temp.next != null)
		{
			temp=temp.next;
		}

                while(temp != null)
                {
                        System.out.print(temp.data +"-->");
                        temp=temp.prev;
                }

                System.out.println("NULL");
        }

	 public int Count()
        {
                Node temp=Head;

		int cnt=0;

                System.out.println("Total number of node");

                while(temp != null)
                {
                        cnt++;
                        temp=temp.next;
                }

                return cnt;
        }

	public void InsertLast(int no)
	{
		Node newn=new Node(no);

		newn.next=null;

		newn.prev=null;

		if(Head==null)
		{
			Head=newn;
		}

		else
		{
			Node temp=Head;

			while(temp.next != null)
			{
				temp=temp.next;
			}

			temp.next=newn;

			newn.prev=temp;
		}
	
	}

	public void InsertAtPos(int pos,int no)
	{

		int i=0;

		Node temp=Head;

		int size=Count();

		if(pos < 1 || pos > size+1)
		{
			return ;
		}

		if(pos  == 1)
		{
			InsertFirst(no);
		
		}

		else if(pos == size+1)
		{
			InsertLast(no);
		}

		else
		
		{
			Node newn=new Node(no);

			newn.next=null;

			newn.prev=null;

			for(i=1;i<pos-1;i++)
			{
				temp=temp.next;
			}

			newn.next=temp.next;

			temp.next.prev=newn;

			temp.next=newn;

			newn.prev=temp;
		}


	
	}

	public void DeleteFirst()
	{

		Node temp=Head;

		if(Head==null)
		{
			return ;
		}

		else
		{
			Head=Head.next;

			Head.prev=null;


		}
	
	}

	public void DeleteLast()
	{

		Node temp=Head;

		if(Head == null)
		{
			return ;
		}

		while(temp.next.next != null)
		{
			temp=temp.next;
		}

		temp.next=null;
	}

	public void DeleteAtPos(int pos)
	{

		Node temp=Head;

		Node temp2=Head;

		int i=0;

		int size=Count();

		if(pos < 1 || pos > size)
		{
			return ;
		}

		if(pos == 1)
		{
			DeleteFirst();
		}

		else if(pos == size)
		{
			DeleteLast();

		}

		else
		{

			for(i=1;i<pos-1;i++)
			{
		
				temp=temp.next;
			}

			temp2=temp.next;

			temp.next=temp2.next;

			temp2.next.prev=temp2.prev;

			temp2=null;
		
		}
	
	}


}

class Doubly
{
	public static void main(String args[])
	{

		Doubly_List cobj=new Doubly_List();
		Scanner s=new Scanner(System.in);
		int ch=0;
		int i=0;
		int pos=0;
		int val=0;
		do
		{
			 System.out.println();
			 System.out.println("1:insert first");
			 System.out.println("2:insert last");
			 System.out.println("3:insert at any position");
			 System.out.println("4:delete first");
			 System.out.println("5:delete last ");
			 System.out.println("6:delete at any position");
			 System.out.println("7:Display Forward  list");
			 System.out.println("8:Display Backward list");
			 System.out.println("9:count number of node");
			 System.out.println("0:EXIT");
			 System.out.println();

			 System.out.println("enter your choice");
			 ch=s.nextInt();
			 switch(ch)
			 {
			 	case 1:
					System.out.println("enter number of node do you want");
					int n=s.nextInt();
					System.out.println("enter data for node");
					for( i=0 ; i<n ; i++)
					{
						val=s.nextInt();
						cobj.InsertFirst(val);
					}

					break;

				case 2:

					System.out.println("enter data for last node");

					val=s.nextInt();

					cobj.InsertLast(val);

					break;

				case 3:
					System.out.println("enter position to insert the data");

					pos=s.nextInt();

					System.out.println("enter value to insert the data");

					val=s.nextInt();

					cobj.InsertAtPos(pos,val);

					break;

				case 4:
					cobj.DeleteFirst();

					break;

				case 5:
					cobj.DeleteLast();

					break;

				case 6:
					System.out.println("enter position to delete the data");

					pos=s.nextInt();

					cobj.DeleteAtPos(pos);

					break;



				case 7:
					cobj.DisplayForward();

					break;

				case 8:
					cobj.DisplayBackward();

					break;

				case 9:
					int res=cobj.Count();

					System.out.println(res);

					break;

				case 0:
					System.out.println("thank you for using this application");
					cobj.Head=null;

			 }


		}while(ch !=0);
	}
}
