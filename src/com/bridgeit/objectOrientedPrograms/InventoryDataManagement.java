package com.bridgeit.objectOrientedPrograms;

import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;

import com.bridgeit.utility.Utility;

public class InventoryDataManagement 
{
	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException
	{
		Utility.writeInventoryJsonFile();
		JSONObject jsonObject = Utility.readFromJsonFile("inventory.json");
		Utility.inventoryData(jsonObject);
		
	}

}
