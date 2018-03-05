package com.bridgeit.FunctionalProgram;

import com.bridgeit.Utility;
/******************************************************************************
*  Purpose:  to print factor of number which are prime
*
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
public class PrimeFactorization 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the number whose prime facter have to be found");
		int number = utility.inputInteger();
		Utility.primeFactorization(number);
	}

}
