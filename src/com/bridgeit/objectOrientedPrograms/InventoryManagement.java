
/******************************************************************************
*  Purpose: to calculate stock price of each stock and there total
*  @author  Deepak Singh
*  @version 1.0
*  @since   15-03-2018
*
******************************************************************************/
package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class InventoryManagement 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		Utility.readStockJsonFile();
	}
}
