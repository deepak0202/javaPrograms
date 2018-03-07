/******************************************************************************
*  Purpose: check whether to string taken as input are anagram or not
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import com.bridgeit.utility.Utility;

public class Anagaram 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the 1st string");
		String s1 = utility.inputString();
		System.out.println("enter the 2nd string");
		String s2 = utility.inputString();
		System.out.println(Utility.anagram(s1, s2));
	}	

}
