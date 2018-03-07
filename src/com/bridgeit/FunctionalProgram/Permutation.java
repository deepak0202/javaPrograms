/******************************************************************************
*  Purpose: input a string and print all its permutation

*
*  @author  Deepak Singh
*  @version 1.0
*  @since   06-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

public class Permutation 
{
	public static void main(String[] args)
	{
		Utility utility = new Utility();
		System.out.println("enter the string");
		String word = utility.inputString();
		int l = word.length();
		Utility.permute(word, 0, l-1);
	}
}
