/******************************************************************************
*  Purpose: check wheater input string is palindrome or not useing dequeue
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;


public class PalindromeWithDequeue 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the string");
		String stringForPalindrome = utility.inputString();
		System.out.println(Utility.palindromeWithDeqeue(stringForPalindrome));
	}
}
