/******************************************************************************
*  Purpose: to store data of person useing its constructor
*  the first dimension represents the range 0-100, 100-200, and so on.
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/
package com.bridgeit.dataStructure;

public class Person 
{
	public String Name;
	public int moneyHehad;
	public Person(String Name,int moneyHehad)
	{
		this.Name=Name;
		this.moneyHehad=moneyHehad;
	}
	@Override
	public String toString() 
	{
		
		return ""+Name+" " +moneyHehad;
	}

}
