package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class StockAccount 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{	
		Utility utility = new Utility();
		int start;
		do
		{
		System.out.println("enter your choise");
        System.out.println("enter 1 to create stockAount");
		System.out.println("enter 2 to buy share");
		System.out.println("enter 3 to sell share");
		System.out.println("enter 4 to print report");
		System.out.println("enter 5 to exist");
		int choise = utility.inputInteger();
		start = choise;
		switch (choise) 
		{
		case 1:
			stockAccount("stockAccount.json");
			break;
			case 2 :
				boolean present = false;
				int index = 0;
				Map userMap = new LinkedHashMap<>();
				System.out.println("enter stock name for which you want to buy share");
				String stockName = utility.inputString();
				JSONObject jsonObjectuser = Utility.readFromJsonFile("stockAccount.json");
				JSONArray jsonArrayuser = (JSONArray) jsonObjectuser.get("user");
				for(int i = 0; i < jsonArrayuser.size();i++)
				{
					userMap = (Map) jsonArrayuser.get(i);
					if(userMap.containsValue(stockName))
					{
						index = i;
						present = true;
						break;
					}
				}
				if(present)
				{
					System.out.println("you can buy following share at specific rate");
					System.out.println("@ at price of 100 per share");
					System.out.println("! at price of 40 per share");
					System.out.println("# at price of 1000 per share");
					System.out.println("& at price of 100 per share");
					String symbol = utility.inputString();
					Map stockMap =buy(120, symbol, userMap);
					System.out.println(stockMap);
					
		
					JSONObject jsonObjectStock = new JSONObject();
					jsonArrayuser.set(index, stockMap);
					jsonObjectStock.put("user", jsonArrayuser);
					
					Utility.printJsonObjectToFile("stockAccount.json", jsonObjectStock);
					printDate();
					
					
				}
				else
				{
					System.out.println("stock not exist");
					
				}
				break;
			case 3 :
				boolean present3 = false;
				int index3 = 0;
				Map userMap3 = new LinkedHashMap<>();
				System.out.println("enter stock name for which you want to sell share");
				String stockName3 = utility.inputString();
				JSONObject jsonObjectuser3 = Utility.readFromJsonFile("stockAccount.json");
				JSONArray jsonArrayuser3 = (JSONArray) jsonObjectuser3.get("user");
				for(int i = 0; i < jsonArrayuser3.size();i++)
				{
					userMap3 = (Map) jsonArrayuser3.get(i);
					if(userMap3.containsValue(stockName3))
					{
						index3 = i;
						present3 = true;
						break;
					}
				}
				if(present3)
				{
				Map newUserMap =	sell(userMap3);
				jsonArrayuser3.set(index3, newUserMap);
				JSONObject jsonObjectnew = new JSONObject();
				jsonObjectnew.put("user", jsonArrayuser3);
				Utility.printJsonObjectToFile("stockAccount.json", jsonObjectnew);
				
					printDate();
				}
				else
				{
					System.out.println("stock not exist");
				}
				break;
			case 4:
				printReport();
				printDate();
				break;
				

		default:
			break;
		}
		}
		while(start < 5);
		
		
	}
	public static void stockAccount(String fileName) throws FileNotFoundException, IOException, ParseException
	{
		int totalShare = 0;
		Utility utility = new Utility();
		Map<String, String> stockMap = new LinkedHashMap<>();
		JSONObject jsonObject = Utility.readFromJsonFile(fileName);
		JSONArray jsonArray = (JSONArray) jsonObject.get("user");
		System.out.println("enter the stock name");
		String stockName = utility.inputString();
		stockMap.put("stockName", stockName);
		System.out.println("enter how many compony you want to enter");
		int numberOfCompany = utility.inputInteger();
		for(int i = 0 ; i < numberOfCompany; i++)
		{
			System.out.println("enter the company symbol");
			String symbol = utility.inputString();
			System.out.println("enter number of share");
			int numberOfShare = utility.inputInteger();
			String numberOfShareString = Integer.toString(numberOfShare);
			stockMap.put(symbol, numberOfShareString);
			totalShare += numberOfShare;
		}
		String totalShareString = Integer.toString(totalShare);
		stockMap.put("totalShare", totalShareString);
		
		System.out.println("enter the total amount stock have");
		double amount = utility.inputDouble();
		String amountString = Double.toString(amount);
		stockMap.put("amount", amountString);
		jsonArray.add(stockMap);

		jsonObject.put("user", jsonArray);
		PrintWriter printWriter = new PrintWriter(fileName);
		printWriter.write(jsonObject.toJSONString());
		printWriter.flush();
		printWriter.close();
		printDate();
	}
	public static Map buy(double useramountEnter,String symbol,Map stockMap) throws FileNotFoundException, IOException, ParseException
	{
		boolean present = false;
		int index=0;
		Map shareMap = new LinkedHashMap<>();
		JSONObject jsonObject = Utility.readFromJsonFile("share.json");
		JSONArray jsonArrayShare = (JSONArray) jsonObject.get("share");
		
		for(int i = 0; i < jsonArrayShare.size();i++ )
		{
			shareMap = (Map) jsonArrayShare.get(i);
			if(shareMap.containsValue(symbol))
			{
				index = i;
				present = true;
				break;
			}
		}
		if(present)
		{
			int numberOfShareOfSymbol = 0;
			if(stockMap.get(symbol)!= null)
			{
			String numberOfShareOfSymbolString = (String) stockMap.get(symbol);
			numberOfShareOfSymbol = Integer.parseInt(numberOfShareOfSymbolString);
			}

			String totalShareOfStockString = (String) stockMap.get("totalShare");
			int totalshareOfStock = Integer.parseInt(totalShareOfStockString);
			String amountOfStockString = (String) stockMap.get("amount");
			double amountOfStock = Double.parseDouble(amountOfStockString);
			
			String shareAmountString = (String) shareMap.get("amount");
			String shareNumberString = (String) shareMap.get("numberOfShare");
			String sharePriceString = (String) shareMap.get("price");
			
			double shareTotalAmount = Double.parseDouble(shareAmountString);
			int numberOfShare = Integer.parseInt(shareNumberString);
			double sharePrice = Double.parseDouble(sharePriceString);
			
			double amountOfTransection;
			if(useramountEnter% sharePrice == 0)
			{
				amountOfTransection = useramountEnter;
			}
			else
			{
				amountOfTransection = useramountEnter - (useramountEnter%sharePrice);
			}
			int numberOfShareToBuy = (int)(amountOfTransection / sharePrice);
			
			if(amountOfStock>=amountOfTransection)
			{
				if(numberOfShare>=numberOfShareToBuy)
				{
					double newStockAmount = amountOfStock - amountOfTransection;
					int newShareOfStock = totalshareOfStock + numberOfShareToBuy;
					int newShareOfSymbol = numberOfShareOfSymbol + numberOfShareToBuy;
					
					 
					double newShareAmount = shareTotalAmount + amountOfTransection;
					int newNumberOfshare = numberOfShare - numberOfShareToBuy;
				
					String newShareAmountString = Double.toString(newShareAmount);
					String newNumberOfShareString = Integer.toString(newNumberOfshare);
										
					JSONObject jsonObjectShare = new JSONObject();
					shareMap.put("amount",newShareAmountString);
					shareMap.put("numberOfShare", newNumberOfShareString);
					jsonArrayShare.set(index, shareMap);
					jsonObjectShare.put("share", jsonArrayShare);
					Utility.printJsonObjectToFile("share.json", jsonObjectShare);

					String newStockAmountString = Double.toString(newStockAmount);
					String newShareOfStockString = Integer.toString(newShareOfStock);
					String newShareOfSymbolString = Integer.toString(newShareOfSymbol);
					
					stockMap.put("amount", newStockAmountString);
					stockMap.put("totalShare", newShareOfStockString);
					stockMap.put(symbol, newShareOfSymbolString);
					return stockMap;
				}
				else
				{
					System.out.println("number of share avalable for sell are " + numberOfShare);
				}
			}
			else
			{
				System.out.println("you dont have total amount");
			}	
		}
		else
		{
			System.out.println("share not avalable for sale");
		}
		return stockMap;
	}
	public static Map sell(Map stockMap) throws FileNotFoundException, IOException, ParseException
	{
		Utility utility = new Utility();
		boolean present = false;
		int index=0;
		Map shareMap = new LinkedHashMap<>();
		JSONObject jsonObject = Utility.readFromJsonFile("share.json");
		JSONArray jsonArrayShare = (JSONArray) jsonObject.get("share");
		System.out.println("enter share symbol which you want to sell");
		String symbol = utility.inputString();
		System.out.println("enter number share you want to sell");
		int numberOfShareToBeSell = utility.inputInteger();
		
		for(int i = 0; i < jsonArrayShare.size();i++ )
		{
			shareMap = (Map) jsonArrayShare.get(i);
			if(shareMap.containsValue(symbol))
			{
				index = i;
				present = true;
				break;
			}
		}
		if(present)
		{
			String numberOfShareOfSymbolString = (String) stockMap.get(symbol);
			String totalNumberOfShareOfStockString = (String) stockMap.get("totalShare");
			String amountOfStockString = (String) stockMap.get("amount");
			
			String totalShareOfCompanyString = (String) shareMap.get("numberOfShare");
			String amountOfCompanyString = (String) shareMap.get("amount");
			String sharePriceString = (String) shareMap.get("price");
			
			int numberOfShareOfSymbol = Integer.parseInt(numberOfShareOfSymbolString);
			int totalNumberOfShareOfStock = Integer.parseInt(totalNumberOfShareOfStockString);
			double amountOfStock = Double.parseDouble(amountOfStockString);
			 
			int totalShareOfCompany = Integer.parseInt(totalShareOfCompanyString);
			double amountOfCompany = Double.parseDouble(amountOfCompanyString);
			double priceOfShare = Double.parseDouble(sharePriceString);
					
			if(numberOfShareToBeSell<=numberOfShareOfSymbol)
			{ 
				int newNumberOfShareOfSysmbol = numberOfShareOfSymbol - numberOfShareToBeSell;
				double transectionAmount = priceOfShare *(double) numberOfShareToBeSell;
				double newAmountOfStock = amountOfStock + transectionAmount;
				int newTotalNumberOfShareOfStock = totalNumberOfShareOfStock - numberOfShareToBeSell;
				
				int newTotalshareOfCompany = totalShareOfCompany + numberOfShareToBeSell;
				double newAmountOfCompany = amountOfCompany - transectionAmount;
				
				String newNumberOfShareOfSymbolString = Integer.toString(newNumberOfShareOfSysmbol);
				String newAmountOfStockString = Double.toString(newAmountOfStock);
				String newTotalNumberOfShareOfStockString = Integer.toString(newTotalNumberOfShareOfStock);
				
				String newTotalShareOfCompanyString = Integer.toString(newTotalshareOfCompany);
				String newAmountOfCompanyString = Double.toString(newAmountOfCompany);
				
				stockMap.put(symbol, newNumberOfShareOfSymbolString);
				stockMap.put("amount", newAmountOfStockString);
				stockMap.put("totalShare", newTotalNumberOfShareOfStockString);
				
				shareMap.put("numberOfShare", newTotalShareOfCompanyString);
				shareMap.put("amount", newAmountOfCompanyString);
				
				jsonArrayShare.set(index, shareMap);
				JSONObject newjsonObjectShare = new JSONObject();
				newjsonObjectShare.put("share", jsonArrayShare);
				
				Utility.printJsonObjectToFile("share.json", newjsonObjectShare);	
			}
			else
			{
				System.out.println("you dont have that much share to sell");
			}	
		}
		else
		{
			System.out.println("company not present to purches that share");
		}	
		return stockMap;
	}
	public static void printReport() throws FileNotFoundException, IOException, ParseException
	{
		JSONObject jsonObjectstock = Utility.readFromJsonFile("stockAccount.json");
		JSONArray jsonArray = (JSONArray) jsonObjectstock.get("user");
		for(int i = 0; i < jsonArray.size();i++)
		{
			Map stockMap = (Map) jsonArray.get(i);
			System.out.println(stockMap);	
		}
	}
	public static void printDate()
	{
		Date date = new Date();
		String d = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(date);
		System.out.print("date" + d);
		//queuueu uue=new hdhuhdu();
		//add.(dghsvdg);
		//dplay
	}
}
