/******************************************************************************
*  Purpose:print the sqrt of number
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import com.bridgeit.utility.Utility;


public class Sqrt 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the value");
		int number = utility.inputInteger();
		Utility.sqrt(number);
	}

}
