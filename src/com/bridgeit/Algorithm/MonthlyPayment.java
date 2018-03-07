/******************************************************************************
*  Purpose: reads in three command-line arguments P, Y, and R and calculates the monthly payments
*           you would have to make over Y years to pay off a P principal loan amount at R per cent 
*           interest compounded monthly 
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import com.bridgeit.utility.Utility;


public class MonthlyPayment 
{
	public static void main(String[] args) 
	{
		System.out.println("enter principle amount " + args[0]);
		double p = Double.parseDouble(args[0]);
		System.out.println("enter number of years " + args[1]);
		double y = Double.parseDouble(args[1]);
		System.out.println("enter rate of interest " + args[2]);
		double R = Double.parseDouble(args[2]);
		System.out.println(Utility.monthlyPayment(p, y, R)); 
	}
}
