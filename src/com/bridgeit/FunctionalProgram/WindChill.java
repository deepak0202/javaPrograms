/******************************************************************************
*  Purpose:  calculate and print the wind chill by takeing temperature and wind speed as command
*            line arguments
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

public class WindChill 
{
	public static void main(String[] args) 
	{
		double t  = 0;
		double v = 0;
		System.out.println("enter the temprature" + args[0]);
		t = Double.parseDouble(args[0]);
		System.out.println("enter the wind speed" + args[1]);
		v = Double.parseDouble(args[1]);
		Utility.windChill(t, v);
	}
}
