/******************************************************************************
*  Purpose: to print number which are prine and anagram b/w 1 to 1000 useing queue
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;

public class PrimeAnagramQueue 
{
	public static void main(String[] args) 
	{
		Queue1 queue = new Queue1();
		Linkedlist linkedlist = new Linkedlist();
		for(int i = 1; i<=1000;i++)
		{
			if(Utility.prime(i))
			{
				linkedlist.add(i);
			}
		}
		for(int i =0; i <linkedlist.size()-1;i++)
		{
			for(int j = i+1; j < linkedlist.size();j++)
			{
				if(Utility.anagram(linkedlist.dataAtPosition(i), linkedlist.dataAtPosition(j)))
				{
					queue.enqueue(linkedlist.dataAtPosition(i));
					queue.enqueue(linkedlist.dataAtPosition(j));
				}
			}
		}
		while(!(queue.isEmpty()))
				{
			System.out.println((Integer)queue.dequeue());
				}
	}

}
