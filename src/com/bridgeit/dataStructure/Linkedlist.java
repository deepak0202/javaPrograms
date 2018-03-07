package com.bridgeit.dataStructure;
/******************************************************************************
*  Purpose: represent a node of linkedlist and use to store integer data by call class constructor
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/
class Node1
{
	Node1 forwardRefrence;
	int data;
	Node1(int data)
	{
		this.data= data;
	}
}
/******************************************************************************
*  Purpose: linkedlist to store only integer type of data
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/
public class Linkedlist 
{
	Node1 firstNode;
	Node1 lastNode;
	public void add(int data)
	{
		Node1 newNode = new Node1(data);
		if(firstNode==null)
		{
			firstNode = newNode;
		}
		else
		{
			lastNode.forwardRefrence = newNode;
		}
		lastNode = newNode;
		this.linkedlistsort();
	}
	public boolean search(int dataToBeSearched)
	{
			Node1 current = firstNode;
			while(current != null)
			{
				if(current.data == dataToBeSearched)
				{
					return true;
				}
				current = current.forwardRefrence;
			}
			return false;
	}
	public boolean delete(int dataToBedeleted)
	{
		if(firstNode.data ==dataToBedeleted)
		{
			firstNode = firstNode.forwardRefrence;
			return true;
		}
		else if(lastNode.data == dataToBedeleted)
		{
			Node1 currentNode = firstNode;
			Node1 prevNode = null;
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
			Node1 prevrefrence = null;
			boolean status  = false;
			Node1 current = firstNode;
			
			while(current != lastNode && !(status=!(current.data !=dataToBedeleted)))
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
		Node1 currentNode = firstNode;
		while(currentNode != null)
		{
			System.out.println(currentNode.data);
			currentNode = currentNode.forwardRefrence;
		}
	}
	public int size()
	{
		int size = 0;
		Node1 currentNode = firstNode;
		while(currentNode != null)
		{
			size++;
			currentNode = currentNode.forwardRefrence;
		}
		return size;
	}
	public int dataAtPosition(int position)
	{
		int location = 0;
		
			Node1 currentNode = firstNode;
			while(location != position)
			{
				currentNode = currentNode.forwardRefrence;
				location++;
			}
			return currentNode.data;
	}
	public boolean setData(int postion,int newdata)
	{
		int location = 0;
		if(postion >= this.size())
		{
			return false;
		}
		else
		{
			Node1 currentNode = firstNode;
			while(postion != location)
			{
				currentNode = currentNode.forwardRefrence;
				location++;
			}
			currentNode.data = newdata;
			return true;
		}
	}
	public void linkedlistsort()
	{
		for(int i = 0 ; i < this.size()-1;i++)
		{
			for(int j = i+1;j<this.size();j++)
			{	
				if(this.dataAtPosition(i) > this.dataAtPosition(j))
				{
					int temp = this.dataAtPosition(i);
					this.setData(i, this.dataAtPosition(j));
					this.setData(j, temp);
				}
			} 
		}
	}
}