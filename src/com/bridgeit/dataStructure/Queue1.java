/******************************************************************************
*  Purpose: genric queue implementation useing linkedlist
*  the first dimension represents the range 0-100, 100-200, and so on.
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

public class Queue1<T> 
{
	
	@SuppressWarnings("rawtypes")
	Node firstNode;
	@SuppressWarnings("rawtypes")
	Node lastNode;
	
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> void add(T data)
	{
		@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("hiding")
	public <T> boolean search(T dataToBeSearched)
	{
			@SuppressWarnings("rawtypes")
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
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> boolean delete(T dataToBedeleted)
	{
		if(firstNode.data.equals(dataToBedeleted))
		{
			firstNode = firstNode.forwardRefrence;
			return true;
		}
		else if(lastNode.data.equals(dataToBedeleted))
		{
			@SuppressWarnings("rawtypes")
			Node currentNode = firstNode;
			@SuppressWarnings("rawtypes")
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
			@SuppressWarnings("rawtypes")
			Node prevrefrence = null;
			boolean status  = false;
			@SuppressWarnings("rawtypes")
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
	public void itirate()
	{
		@SuppressWarnings("rawtypes")
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			System.out.println(currentNode.data);
			currentNode = currentNode.forwardRefrence;
		}
	}
	public int size()
	{
		int size = 0;
		@SuppressWarnings("rawtypes")
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			size++;
			currentNode = currentNode.forwardRefrence;
		}
		return size;
	}
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> T dataAtPosition(int position)
	{
		int location = 0;
		if(position >= this.size())
		{
			return null;
		}
		else
		{
			@SuppressWarnings("rawtypes")
			Node currentNode = firstNode;
			while(location != position)
			{
				currentNode = currentNode.forwardRefrence;
				location++;
			}
			return  (T) currentNode.data;
		}
	}
	@SuppressWarnings("unchecked")
	public void deletelast()
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
		@SuppressWarnings("rawtypes")
		Node current = firstNode;
		@SuppressWarnings("rawtypes")
		Node prev=null;
		while(current != lastNode)
		{
			prev = current;
			current = current.forwardRefrence;
		}
		prev.forwardRefrence = null;
			}	
	}
	public void deletefirst()
	 {
		 firstNode = firstNode.forwardRefrence;
	 }
	 @SuppressWarnings("hiding")
	public <T> void enqueue(T data)
	 {
		 this.add(data);
	 }
	@SuppressWarnings("hiding")
	public <T> T dequeue()
	 {
		 @SuppressWarnings("unchecked")
		T data = (T) firstNode.data;
		 this.deletefirst();
		 return data;
	 }
	public boolean isEmpty()
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
