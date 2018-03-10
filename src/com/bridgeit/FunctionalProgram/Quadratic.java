/******************************************************************************
*  Purpose: print the roots of quadratic equation and tell whether they are real,equal or imaginary
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;


public class Quadratic 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter a");
		double a = utility.inputDouble();
		System.out.println("enter b");
		double b = utility.inputDouble();
		System.out.println("enter c");
		double c = utility.inputDouble();
		Utility.quadratic(a, b, c);
	}

}
