//program to impliment the singly circuler linkedlist in java


import java.lang.*;

import java.util.*;

class Node
{
	public int  data;
	
	public Node next;

	public Node(int value)
	{
		data=value;

		next=null;
	}
}

class Singly_Circuler
{
	public Node Head;

	public Node Tail;

	public Singly_Circuler()
	{
		Head=null;

		Tail=null;
	}

	public void InsertFirst(int no)
	{
		Node newn=new Node(no);

		if(Head == null && Tail == null)
		{
			Head=Tail=newn;
		}

		else
		{
			newn.next=Head;

			Head=newn;
		}

		Tail.next=Head;
	}

	public void Display()
	{
		Node temp=Head;

		System.out.println("your circuler list is :");

		do
		{
			System.out.print(temp.data +"->" + "\t");

			temp=temp.next;
		
		}while(temp != Head);

		System.out.println("NULL");

	}

	  public int  Count()
        {
                Node temp=Head;

		int cnt=0;

                System.out.println("total number of node :");

                do
                {
                        cnt++;

                        temp=temp.next;
               
		}while(temp != Head);

		return cnt;

        }

	public void InsertLast(int no)
	{
		Node newn=new Node(no);

		if(Head == null && Tail == null)
		{
			return ;
		}

		else
		{
			Tail.next=newn;

			Tail=newn;
		}

		Tail.next=Head;
	}

	public void InsertAtPos(int pos,int no)
	{
		int size=Count();

		Node temp=Head;

		if(Head == null && Tail == null)
		{
			return ;
		}

		else
		{
			if( pos <= 0 || pos >(size+1))
			{
				
				return ;
			}

			else if(pos == 1)
			{
				InsertFirst(no);
			}

			else if(pos == (size+1))
			{
				InsertLast(no);
			}

			else
			{
				Node newn=new Node(no);

				for(int i=1 ;i<pos-1;i++)
				{
					temp=temp.next;
				}

				newn.next=temp.next;

				temp.next=newn;
			}
		}

		Tail.next=Head;


	
	}

	public void DeleteFirst()
	{
		Node temp=Head;

		if(Head == null && Tail == null)
		{
			return;
		}

		else if(Head == Tail )
		{
			Head=Tail=null;
		}
		else
		{
			Head=Head.next;
		}

		Tail.next=Head;


	}

	public void DeleteLast()
	{
		Node temp=Head;

		int i=0;

		for(i=0;temp.next != Tail ;i++)
		{
			temp=temp.next;
		}

		Tail=null;

		Tail=temp;

		Tail.next=Head;


	}

	public void DeleteAtPos(int pos)
	{
		Node temp=Head;
		
		Node temp2;

		int i=0;

		int size=Count();

		if(Head == null && Tail == null)
		{
			return ;
		}

		if(pos==1)
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

		temp.next=temp.next.next;

		temp2=null;
		
		}

		Tail.next=Head;


	}



}


class circuler
{
	public static void main(String args[])
	{
	
		Singly_Circuler cobj=new Singly_Circuler();
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
			 System.out.println("7:Display list");
			 System.out.println("8:count number of node");
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
					cobj.Display();

					break;

				case 8:
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
