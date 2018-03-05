package com.bridgeit.Algorithm;

import com.bridgeit.Utility;

/******************************************************************************
*  Purpose:  takes a date as input by command line arguments  and 
*            prints the day of the week that date falls on
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
public class DayOfWeek 
{
	public static void main(String[] args) 
	{
		System.out.println("enter value b/w 1 to 12 for respective month " + args[0]);
		int m = Integer.parseInt(args[0]);
		System.out.println("enter the day of the month " + args[1]);
		int d = Integer.parseInt(args[1]);
		System.out.println("enter the year " + args[2]);
		int y = Integer.parseInt(args[2]);
		int weekDay = Utility.dayOfWeek(m, d, y);
		Utility.printDayOfWeek(weekDay);
	}
}
