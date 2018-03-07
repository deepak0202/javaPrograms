/******************************************************************************
*  Purpose: check wheater input string is palindrome or not useing dequeue
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import java.util.Deque;
import java.util.LinkedList;

import com.bridgeit.utility.Utility;


public class PalindromeWithDequeue 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the string");
		String stringForPalindrome = utility.inputString();
		System.out.println(palindromeWithDeqeue(stringForPalindrome));
		
	}
	static boolean palindromeWithDeqeue(String stringForPalindrome)
	{
		boolean check = false;
		Deque deque =  new LinkedList();
		Deque deque2 = new LinkedList();
		char[] array = stringForPalindrome.toCharArray();
		for(char value : array)
		{
			deque.push(value);
			deque2.push(value);
		}
		while(deque.size() != 0)
		{
			if(deque.pop() == (deque2.removeLast()))
			{
				check = true;
			}
			else
			{
				check = false;
				break;
			}
		}
		return check;
	}
}
