/******************************************************************************
*  Purpose: to print the triplet in array whose sum is zero
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;


public class Triple 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the number of integer to taken");
		int length = utility.inputInteger();
		int[] array = new int[length];
		for(int i = 0; i<length;i++)
		{
			System.out.println("enter the " + i+"th element in array");
			array[i] = utility.inputInteger();
		}
		Utility.triplet(array);
	}
}
