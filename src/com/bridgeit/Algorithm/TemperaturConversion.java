/******************************************************************************
*  Purpose: take temperature in fahrenheit as input outputs the temperature in Celsius  or viceversa 
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import com.bridgeit.utility.Utility;


public class TemperaturConversion 
{
	public static void main(String[] args)
	{
		Utility utility = new Utility();
		System.out.println("enter f for Celsius to Fahrenheit");
		System.out.println("enter c for Fahrenheit to Celsius");
		String ch = utility.inputString();
		switch (ch) 
		{
		case "f":
			System.out.println("enter temp in celsius");
			int c = utility.inputInteger();
			System.out.println("temp in fahrenheit = " + Utility.temperaturConversion(c, "c"));
			
			break;
         case "c":
        	 System.out.println("enter temp in Fahrenheit");
 			int f = utility.inputInteger();
 			System.out.println("temp in fahrenheit = " + Utility.temperaturConversion(f, "f"));
			
			break;

		default:
			System.out.println("enter valid choise");
			break;
		}	
	}
}
