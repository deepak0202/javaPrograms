package com.bridgeit.FunctionalProgram;

import java.util.HashSet;

import com.bridgeit.Utility;
/******************************************************************************
*  Purpose:  generate Distinct Coupon Number and save it in hashset object

*
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
public class Coupon 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the number of coupon to be genrated");
		int numberOfCoupon = utility.inputInteger();
		HashSet hashSet = Utility.coupon(numberOfCoupon);
		System.out.println(hashSet);
	}
}