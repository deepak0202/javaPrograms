/******************************************************************************
*  Purpose: to print prime number b/w 1 to 1000
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import com.bridgeit.utility.Utility;

public class Prime 
{
	public static void main(String[] args) 
	{
		for(int i=0; i<=1000;i++)
		{
			if(Utility.prime(i))
			{
				System.out.println(i);
			}
		}
	}
}
