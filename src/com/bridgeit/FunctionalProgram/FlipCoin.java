/******************************************************************************
*  Purpose: input the number of times coin should be flip and print the percent of head and tail outcome
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

class FlipCoin {
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("enter number of times coin to be flip");
		int numberOfTimes = utility.inputInteger();
		Utility.flipCoin(numberOfTimes);
	}
}
