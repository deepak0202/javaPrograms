/******************************************************************************
*  Purpose:  generate table of 2 pow 1 to 2 pow till number entered by user

*
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

public class Power 
{
	public static void main(String[] args) 
	{
		System.out.println("enter the value of n " + args[0]);
		int n = Integer.parseInt(args[0]);
		Utility.power(n);
	}
}
