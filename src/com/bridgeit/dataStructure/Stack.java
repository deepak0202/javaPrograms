/******************************************************************************
*  Purpose: genric stack implementation useing linkedlist
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/


package com.bridgeit.dataStructure;

import java.io.UncheckedIOException;

import com.bridgeit.Algorithm.*;

class Node8<T>
{
	Node8 forwardRefrence;
	T data;
	Node8(T data1)
	{
		this.data = (T) data1;
	}
}
public class Stack 
{
	Node8 firstNode;
	Node8 lastNode;
	public <T> void add(T data)
	{
		Node8 newNode = new Node8(data);
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
	public <T> boolean search(T dataToBeSearched)
	{
			Node8 current = firstNode;
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
	public <T> boolean delete(T dataToBedeleted)
	{
		if(firstNode.data.equals(dataToBedeleted))
		{
			firstNode = firstNode.forwardRefrence;
			return true;
		}
		else if(lastNode.data.equals(dataToBedeleted))
		{
			Node8 currentNode = firstNode;
			Node8 prevNode = null;
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
			Node8 prevrefrence = null;
			boolean status  = false;
			Node8 current = firstNode;
			
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
		Node8 currentNode = firstNode;
		while(currentNode != null)
		{
			System.out.println(currentNode.data);
			currentNode = currentNode.forwardRefrence;
		}
	}
	public int size()
	{
		int size = 0;
		Node8 currentNode = firstNode;
		while(currentNode != null)
		{
			size++;
			currentNode = currentNode.forwardRefrence;
		}
		return size;
	}
	public <T> T dataAtPosition(int position)
	{
		int location = 0;
		if(position >= this.size())
		{
			return null;
		}
		else
		{
			Node8 currentNode = firstNode;
			while(location != position)
			{
				currentNode = currentNode.forwardRefrence;
				location++;
			}
			
			return  (T) currentNode.data;
		}
	}
	public void deletelast()
	{
		if(this.size()==1)
		{
			firstNode = null;
		}
		else
		{
		Node8 prevNode=null;
		Node8 currentNode = firstNode;
		while(currentNode.forwardRefrence !=null)
		{
			prevNode = currentNode;
			currentNode = currentNode.forwardRefrence;
		}
		lastNode = prevNode;
		lastNode.forwardRefrence = null;
		}
	}
	public <T> void push(T data)
	{
		this.add(data);
	}
	public <T> T pop()
	{
		T data =(T) lastNode.data;
		this.deletelast();
		return data;
	}
public <T> T peek()
	{
		return (T) lastNode.data;
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