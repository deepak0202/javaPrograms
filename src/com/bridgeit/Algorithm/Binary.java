/******************************************************************************
*  Purpose: convert number into binary then swap it from center then convert new binary to number
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import com.bridgeit.utility.Utility;


public class Binary 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the number to be converted to binary");
		int number = utility.inputInteger();
		Utility.binary(number);	
	}

}
