/******************************************************************************
*  Purpose:  to print the sum of harmonic numbers
*
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

public class Harmonic 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the value till we want to print harmonic");
		double n = utility.inputDouble();
		Utility.harmonic(n);
	}
}
