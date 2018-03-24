/******************************************************************************
*  Purpose: to find number imagin by us
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import com.bridgeit.utility.Utility;

public class ImaginNumber 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the imagin number");
		int number = utility.inputInteger();
		Utility.imaginenumber(number);
		
	}
	
}
