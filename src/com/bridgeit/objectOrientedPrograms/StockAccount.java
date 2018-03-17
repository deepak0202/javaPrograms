/******************************************************************************
*  Purpose: to allow stock to buy or sell share and print the report
*  @author  Deepak Singh
*  @version 1.0
*  @since   15-03-2018
*
******************************************************************************/
package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import com.bridgeit.utility.Utility;

public class StockAccount 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException 
	{	
		Utility.stockAccountController();
	}
}