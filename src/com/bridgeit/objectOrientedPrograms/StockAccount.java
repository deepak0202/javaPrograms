package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
//		System.out.println("enter your choise");
//		System.out.println("enter 1 to create stockAount");
		//System.out.println("enter 2 to buy share");
		
		System.out.println("enter your choise");
		int choise = utility.inputInteger();
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
					
					
				}
				else
				{
					System.out.println("stock not exist");
					
				}
				
				

		default:
			break;
		}
		
		
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
	}
//	public static void buy(int useramountEnter,String symbol,Map user) throws FileNotFoundException, IOException, ParseException
//	{
//		Utility utility = new Utility();
//		int index = 0;
//		boolean present = false;
//		Map m = new LinkedHashMap<>();
//		JSONObject jsonObject = Utility.readFromJsonFile("share.json");
//		JSONArray jsonArray = (JSONArray) jsonObject.get("share");
//		
//		for(int i =0; i<jsonArray.size();i++)
//		{
//			m = (Map) jsonArray.get(i);
//			if(m.containsValue(symbol))
//			{
//				index = i;
//				present = true;
//				break;
//			}
//		}
//		
//		if(present)
//		{
//			//share detail
//			long numberOfShareAvalable =  (long) m.get("numberOfShare");
//			int shareprice = (int)(Integer) m.get("price");
//			int shareCompanyTotalAmount = (int)(Integer) m.get("amount");
//			
//			//transection detail
//			int numberOfShareHeWantsToBuy = useramountEnter / shareprice;
//			
//			//user detail
//			int numberOfUserShareOfSymbol = (int)(Integer) user.get(symbol);
//			double amounOfuser = (double) (Double)user.get("amount");
//			
//			
//			if(amounOfuser>=useramountEnter)
//			{
//				if(numberOfShareAvalable>=numberOfShareHeWantsToBuy)
//				{
//					//new user detail
//					int newShareofuser = numberOfUserShareOfSymbol + numberOfShareHeWantsToBuy;
//					double newAmountOfUser = amounOfuser - (double)useramountEnter;
//					
//					//new share detail
//					int newShareOfcompany = (int) (numberOfShareAvalable - numberOfShareHeWantsToBuy);
//					int newAmountOfShare = shareCompanyTotalAmount + useramountEnter;
//					
//					//user map update 
//					user.put(symbol,newShareofuser);
//					user.put("amount", newAmountOfUser);
//					
//					//user array update
////					jsonArray.set(index, m);
////					JSONObject jsonObject2 = new JSONObject();
////					jsonObject2.put("user", jsonArray);
////					Utility.printJsonObjectToFile("stockAccount", jsonObject2);
//					
//					//share map update
//					m.put("numberOfShare", newShareOfcompany);
//					m.put("amount", newAmountOfShare);
//					jsonArray.set(index, user);
// 					JSONObject jsonObject2 = new JSONObject();
//					jsonObject2.put("share", jsonArray);
//					Utility.printJsonObjectToFile("share.json", jsonObject2);
//					
//				}
//				else
//				{
//					System.out.println("company dont have that much share you reqied");
//				}
//			}
//			else
//			{
//				System.out.println("insufficient fund");
//			}
//			
//			
//		}
//		else
//		{
//			System.out.println("share symbol you have entered is not available for sale");
//		}
//		
//	}
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
			//stock details
			int numberOfShareOfSymbol = 0;
			if(stockMap.get(symbol)!= null)
			{
			String numberOfShareOfSymbolString = (String) stockMap.get(symbol);
			numberOfShareOfSymbol = Integer.parseInt(numberOfShareOfSymbolString);
			}
		//	 numberOfShareOfSymbol = (int)(Integer) stockMap.get(symbol);
			String totalShareOfStockString = (String) stockMap.get("totalShare");
			int totalshareOfStock = Integer.parseInt(totalShareOfStockString);
			String amountOfStockString = (String) stockMap.get("amount");
			double amountOfStock = Double.parseDouble(amountOfStockString);
			
			//shARE detaials in string
			String shareAmountString = (String) shareMap.get("amount");
			String shareNumberString = (String) shareMap.get("numberOfShare");
			String sharePriceString = (String) shareMap.get("price");
			
			//share detail converted
			double shareTotalAmount = Double.parseDouble(shareAmountString);
			int numberOfShare = Integer.parseInt(shareNumberString);
			double sharePrice = Double.parseDouble(sharePriceString);
			
			//transection amount
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
					//transection start
					//stock
					double newStockAmount = amountOfStock - amountOfTransection;
					int newShareOfStock = totalshareOfStock + numberOfShareToBuy;
					int newShareOfSymbol = numberOfShareOfSymbol + numberOfShareToBuy;
					
					//share 
					double newShareAmount = shareTotalAmount + amountOfTransection;
					int newNumberOfshare = numberOfShare - numberOfShareToBuy;
				
					// share atribute in string
					String newShareAmountString = Double.toString(newShareAmount);
					String newNumberOfShareString = Integer.toString(newNumberOfshare);
					
					
					
					JSONObject jsonObjectShare = new JSONObject();
					shareMap.put("amount",newShareAmountString);
					shareMap.put("numberOfShare", newNumberOfShareString);
					jsonArrayShare.set(index, shareMap);
					jsonObjectShare.put("share", jsonArrayShare);
					Utility.printJsonObjectToFile("share.json", jsonObjectShare);
					
					//stock seting attribute  in string
					String newStockAmountString = Double.toString(newStockAmount);
					String newShareOfStockString = Integer.toString(newShareOfStock);
					String newShareOfSymbolString = Integer.toString(newShareOfSymbol);
					
					//put stock in map
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

}
