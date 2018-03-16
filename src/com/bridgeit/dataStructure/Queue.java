
/******************************************************************************
*  Purpose: to store data of linkedlist by calling its constructor
*  the first dimension represents the range 0-100, 100-200, and so on.
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

class Node3
{
	Person person;
	Node3 forwardRefrence;
	Node3(Person person)
	{
		this.person = person;
	}
}
/******************************************************************************
*  Purpose: Queue implementation useing linkedlist
*  the first dimension represents the range 0-100, 100-200, and so on.
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/
public class Queue 
{
	Node3 firstNode;
	Node3 lastNode;
	public void add(Person person)
	{
		Node3 newNode = new Node3(person);
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
	public int size()
		{
			int size = 0;
			Node3 currentNode = firstNode;
			while(currentNode != null)
			{
				size++;
				currentNode = currentNode.forwardRefrence;
			}
			return size;
		}
	public void deletefirst()
	 {
		 firstNode = firstNode.forwardRefrence;
	 }
	public void enqueue(Person person)
	 {
		 this.add(person);
	 }
	public Person dequeue()
	 {
		 Person person = firstNode.person;
		 this.deletefirst();
		 return person;
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
