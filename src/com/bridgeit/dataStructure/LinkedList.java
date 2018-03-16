/******************************************************************************
*  Purpose: represent a node of linkedlist and use to store genric data by call class constructor
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;
 class Node<T>
{
	@SuppressWarnings("rawtypes")
	Node forwardRefrence;
	T data;
	Node(T data1)
	{
		this.data = (T) data1;
	}
}
 /******************************************************************************
 *  Purpose: linkedlist to store only genric type of data
 *  @author  Deepak Singh
 *  @version 1.0
 *  @since   07-03-2018
 *
 ******************************************************************************/
 @SuppressWarnings("rawtypes")
public class LinkedList 
{
	Node firstNode;
	Node lastNode;
	@SuppressWarnings("unchecked")
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
	public <T> boolean search(T dataToBeSearched)
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
@SuppressWarnings("unchecked")
public	<T> boolean delete(T dataToBedeleted)
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
	public void itirate()
	{
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
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			size++;
			currentNode = currentNode.forwardRefrence;
		}
		return size;
	}
	@SuppressWarnings("unchecked")
	public <T> T dataAtPosition(int position)
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
}