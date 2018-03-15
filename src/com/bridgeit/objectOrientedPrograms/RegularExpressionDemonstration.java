package com.bridgeit.objectOrientedPrograms;

import java.util.Date;

import com.bridgeit.utility.Utility;

public class RegularExpressionDemonstration 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		UserDetails userDetails=new UserDetails();
		
		System.out.println("Enter FirstName:");
		userDetails.setFirstName(utility.inputString());
		
		
		System.out.println("Enter LastName:");
		userDetails.setLastName(utility.inputString());
		
		System.out.println("Enter MobileNumber:");
		userDetails.setMobileNo(utility.inputString());
		
		
		userDetails.setDate(utility.getFormatedDate(new Date()));
		System.out.println(utility.convertString(userDetails,utility.getFileText("regular.text")));
	}
}