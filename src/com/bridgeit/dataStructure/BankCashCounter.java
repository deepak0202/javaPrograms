/******************************************************************************
*  Purpose: bank cash counter
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;

public class BankCashCounter 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Queue queue = new Queue();
		Utility utility = new Utility();
		System.out.println("enter the max number of person to be served");
		int maxPerson = utility.inputInteger();
		int numberOfPersonEntered = 0;
		System.out.println("the money bank had");
		int bankbalance = utility.inputInteger();
		
		while(numberOfPersonEntered != maxPerson)
		{
			System.out.println("person enter the bank");
			System.out.println("enter the name of person");
			String name = utility.inputString();
			System.out.println("enter the amount he had");
			int amount  = utility.inputInteger();
			System.out.println("person enter the queue");
			queue.enqueue(new Person(name, amount));
			numberOfPersonEntered++;
		}
		while(!(queue.isEmpty()))
				{
			Person person = queue.dequeue();
			System.out.println("enter 1 to deposit money and 2 to withdraw moeny");
			int choice = utility.inputInteger();
			switch (choice) {
			case 1:
				System.out.println("enter the money amount to be deposit");
				int amount = utility.inputInteger();
				if(person.moneyHehad >= amount)
				{
					person.moneyHehad -= amount;
					bankbalance+=amount;
				}
				else
				{
					System.out.println("insuffcent aumont with " + person.Name);
				}
				break;
               case 2:
            	   System.out.println("enter the amount to be withdraw");
            	   int withdrawMoney = utility.inputInteger();
            	   if(bankbalance >= withdrawMoney)
            	   {
            		   bankbalance -= withdrawMoney;
            		   person.moneyHehad +=withdrawMoney;
            	   }
            	   else
            	   {
            		   System.out.println("bank have insuffcent fund for your request come tommorow");
            	   }
				
				break;

			default:
				break;
			}
			System.out.println("person servered detail");
			System.out.println(person.Name + "----" + person.moneyHehad);
			
			
				}
		
	}

}
