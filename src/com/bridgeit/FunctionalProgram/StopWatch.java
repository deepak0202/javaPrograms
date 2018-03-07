/******************************************************************************
*  Purpose: to find time of execution of program
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/


package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;


public class StopWatch 
{
	public static void main(String[] args) 
	{
		long start;
		long end;
		start = Utility.start();
		for(int i = 0; i<=100000;i++)
		{
			for(int j = 0; j <10000; j++)
			{
				
			}
		}
		end = Utility.end();
		System.out.println(Utility.timeLaps(start, end));
		
	}

}
