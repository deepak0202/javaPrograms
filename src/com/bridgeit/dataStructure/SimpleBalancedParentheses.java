/******************************************************************************
*  Purpose: to check Arithmetic Expression is balanced or not
*  the first dimension represents the range 0-100, 100-200, and so on.
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;

public class SimpleBalancedParentheses 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the Arithmetic Expression");
		String ArithmeticExpression = utility.inputString();
		System.out.println(Utility.simpleBalancedParentheses(ArithmeticExpression));	
	}
}
