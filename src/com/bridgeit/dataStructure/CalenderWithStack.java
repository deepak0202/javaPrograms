/******************************************************************************
*  Purpose: to print calender of given month and year useing stack
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;

public class CalenderWithStack 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the month");
		int month = utility.inputInteger();
		System.out.println("enter the year");
		int year = utility.inputInteger();
		Utility.calenderWithStack(month,year);
	}
}