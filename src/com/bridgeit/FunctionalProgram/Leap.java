/******************************************************************************
*  Purpose:  to take year as input and print whether it is leap or not

*
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

class Leap
{
  public static void main(String[] args)
{
Utility utility = new Utility();
System.out.println("enter the year");
int year = utility.inputInteger();
boolean leap = Utility.leap(year);
if(leap)
{
	System.out.println("it is leap year");
}
else
{
	System.out.println("not a leap year");
}
}
}

