/******************************************************************************
*  Purpose: to print number which are prine and anagram b/w 1 to 1000 useing stack
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;

public class PrimeAnagram 
{
	public static void main(String[] args) 
	{
		Linkedlist linkedlist = new Linkedlist();
		Stack stack = new Stack(); 
		for(int i=0;i<=1000;i++)
		{
			if(Utility.prime(i))
			{
				linkedlist.add(i);
			}
		}
		for(int i = 0; i < linkedlist.size()-1;i++)
		{
			for(int j = i+1; j <linkedlist.size();j++)
			{
				if(Utility.anagram(linkedlist.dataAtPosition(i), linkedlist.dataAtPosition(j)))
				{
					stack.push(linkedlist.dataAtPosition(i));
					stack.push(linkedlist.dataAtPosition(j));
				}
			}
		}
		while(!(stack.isEmpty()))
		{
			System.out.println((Integer)stack.pop());
		}
	}

}
