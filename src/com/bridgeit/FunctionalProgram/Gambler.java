/******************************************************************************
*  Purpose: to make gamble play till till he reach his goal amount or become nill or he 
*           had played max number of time then print the number of times he won
*           percent of won and percent of loss
*
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

public class Gambler 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the stake aount");
		int stake = utility.inputInteger();
		System.out.println("enter the goal amount");
		int goal = utility.inputInteger();
		System.out.println("enter the no of times he played");
		int n = utility.inputInteger();
		Utility.gambler(stake,goal,n);
	}
}
