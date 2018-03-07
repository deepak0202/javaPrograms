/******************************************************************************
*  Purpose: genric queue implementation useing linkedlist
*  the first dimension represents the range 0-100, 100-200, and so on.
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

public class Queue1 
{
	Node firstNode;
	Node lastNode;
	public <T> void add(T data)
	{
		Node newNode = new Node(data);
		if(firstNode==null)
		{
			firstNode = newNode;
		}
		else
		{
			lastNode.forwardRefrence = newNode;
		}
		lastNode = newNode;
	}
	<T> boolean search(T dataToBeSearched)
	{
			Node current = firstNode;
			while(current != null)
			{
				if(current.data.equals(dataToBeSearched))
				{
					return true;
				}
				current = current.forwardRefrence;
			}
			return false;
	}
	<T> boolean delete(T dataToBedeleted)
	{
		if(firstNode.data.equals(dataToBedeleted))
		{
			firstNode = firstNode.forwardRefrence;
			return true;
		}
		else if(lastNode.data.equals(dataToBedeleted))
		{
			Node currentNode = firstNode;
			Node prevNode = null;
			while(currentNode != lastNode)
			{
				prevNode = currentNode;
				currentNode = currentNode.forwardRefrence;
			}
			prevNode.forwardRefrence = null;
			return true;
		}
		else
		{
			Node prevrefrence = null;
			boolean status  = false;
			Node current = firstNode;
			
			while(current != lastNode && !(status=(current.data.equals(dataToBedeleted))))
			{
				prevrefrence = current;
				current = current.forwardRefrence;
			}
			if(status)
			{
				prevrefrence.forwardRefrence = current.forwardRefrence;
				return true;
			}
			
		}
		return false;
	}
	void itirate()
	{
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			System.out.println(currentNode.data);
			currentNode = currentNode.forwardRefrence;
		}
	}
	int size()
	{
		int size = 0;
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			size++;
			currentNode = currentNode.forwardRefrence;
		}
		return size;
	}
	<T> T dataAtPosition(int position)
	{
		int location = 0;
		if(position >= this.size())
		{
			return null;
		}
		else
		{
			Node currentNode = firstNode;
			while(location != position)
			{
				currentNode = currentNode.forwardRefrence;
				location++;
			}
			return  (T) currentNode.data;
		}
	}
	void deletelast()
	{
	
			if(this.size() == 1)
			{
				firstNode = null;
			}
			else if(this.size() == 2)
			{
				firstNode.forwardRefrence = null;
			}
			else
			{
		Node current = firstNode;
		Node prev=null;
		while(current != lastNode)
		{
			prev = current;
			current = current.forwardRefrence;
		}
		prev.forwardRefrence = null;
			}
		
		
	}

	 void deletefirst()
	 {
		 firstNode = firstNode.forwardRefrence;
	 }
	 <T> void enqueue(T data)
	 {
		 this.add(data);
	 }
	 <T> T dequeue()
	 {
		 T data = (T) firstNode.data;
		 this.deletefirst();
		 return data;
	 }
	 boolean isEmpty()
	 {
		 if(this.size() == 0)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }	

}
