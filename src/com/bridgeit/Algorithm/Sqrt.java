package com.bridgeit.Algorithm;

import com.bridgeit.Utility;

/******************************************************************************
*  Purpose:print the sqrt of number
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
public class Sqrt 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the value");
		int c = utility.inputInteger();
		Utility.sqrt(c);
	}

}