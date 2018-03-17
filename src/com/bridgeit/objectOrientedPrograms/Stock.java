/******************************************************************************
*  Purpose: to add stock details in stock.json file
*  and to read them
*  remove exsting one
*  @author  Deepak Singh
*  @version 1.0
*  @since   15-03-2018
*
******************************************************************************/

package com.bridgeit.objectOrientedPrograms;

import java.io.IOException;
import java.text.ParseException;
import com.bridgeit.utility.Utility;

public class Stock 
{
	
	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException 
	{
		Utility.writeStockJsonFile();
		Utility.readStockJsonFile();
	}
}