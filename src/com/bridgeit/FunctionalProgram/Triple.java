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
		int l = utility.inputInteger();
		int[] x = new int[l];
		for(int i = 0; i<l;i++)
		{
			System.out.println("enter the " + i+"th element in array");
			x[i] = utility.inputInteger();
		}
		Utility.triplet(x);
	}
}
