/******************************************************************************
*  Purpose:  to check whether input string is more then three character
*            if it is then print it with  msg 

*
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

class Hello {
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("enter the string");
		String name = utility.inputString();
		Utility.hello(name);
	}
}
