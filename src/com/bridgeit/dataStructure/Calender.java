/******************************************************************************
*  Purpose: to print calender of given month and year useing 2d array
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;

public class Calender 
{
	public static void main(String[] args) 
	{
		System.out.println("enter the month " + args[0]);
		int month = Integer.parseInt(args[0]);
		System.out.println("enter the year " + args[1]);
		int year = Integer.parseInt(args[1]);
		Utility.printMonthCalender(month, year);
		
	}
}
