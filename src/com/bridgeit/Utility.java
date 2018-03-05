package com.bridgeit;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Utility 
{
	public static Scanner scanner;
	
	 
	 
	/**
	 *  
	 */
	public Utility()
	{
		scanner = new Scanner(System.in);
		
	}
	/**
	 * @return string input given by the user
	 */
	public  String inputString()
	{
		try
		{
			return scanner.next();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return "";
	}
	/**
	 * @return int value given by the user
	 */
	public int inputInteger()
	{
		try
		{
			return scanner.nextInt();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/**
	 * @return double value given by the user
	 */
	public double inputDouble()
	{
		try
		{
			return scanner.nextDouble();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return 0.0;
	}
	/**
	 * @return boolean value given by the user
	 */
	public boolean inputBoolean()
	{
		try
		{
			return scanner.nextBoolean();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * @param stake = total amount of money gamble have
	 * @param goal = total amount of money gamble want to reach
	 * @param n = max number of times gamble will play
	 *  it print wining and loss percent of gambler
	 */
	
	public static void gambler(int stake,int goal,int n)
	{
		int won = 0;
		int loss = 0;
		int heplayed = 0;
		for(int i = 1; i <=n;i++)
		{
			heplayed++;
			if(Math.random() <0.5)
			{
				stake--;
				loss++;
			}
			else
			{
				stake++;
				won++;
			}
			if(stake == 0 || stake == goal)
			{
				break;
			}
		}
		System.out.println("number of wins " + won);
		double winPercent =(double)(won*100)/(double)heplayed;
		System.out.println("percent of won " + winPercent);
		double lossPercent = (double) (loss*100)/(double) heplayed;
		System.out.println("percent of loss " + lossPercent);
	}
	/**
	 * @param n = number of coupon user wants to genrate
	 * print distinct coupon number
	 */
	public static HashSet coupon(int n)
	{
		int y = 0;
		Random r = new Random();
		HashSet h = new HashSet();
		while(h.size()!= n)
		{
			y = r.nextInt();
			if(y>0)
			{
				h.add(y);
			}
		}
		return h;
	}
	/**
	 * @param x = name of array whose triplete we want to genrate
	 * print triplet whose sum is zero
	 */
	public static void triplet(int[] x)
	{
		int l = x.length;
		for(int i = 0;i<l-2;i++)
		{
			if(x[i] + x[i+1]+x[i+2]==0)
			{
				System.out.println(x[i] + " " + x[i+1] + " " + x[i+2]);
				
			}
		}
	}
	/**
	 * @param a = value present in quadratic equation with x^2
	 * @param b = value present in quadratic equation with x
	 * @param c = alone number present in quadratic equation
	 * print the roots of quadratic equation and tell whether they are real,equal or imaginary
	 */
	public static void quadratic(double a,double b,double c)
	{
		double delta = b*b - 4*a*c;
		if(delta >0)
		{
			System.out.println("roots real and unequal");
			double Root1 = (-b + Math.sqrt(delta))/(2*a);
			double Root2 = (-b - Math.sqrt(delta))/(2*a);
			System.out.println("1st root " + Root1);
			System.out.println("2nd root " + Root2);
		}
		else if(delta == 0)
		{
			System.out.println("roots real and equal");
			double Root = (-b + Math.sqrt(delta))/(2*a);
			System.out.println("both root are " + Root);
		}
		else
		{
			System.out.println("roots are imaginary");
		}
	}
	/**
	 * 
	 */
	public static void array2d()
	{
		Utility utility = new Utility();
		System.out.println("enter 1 for integer");
		System.out.println("enter 2 for double");
		System.out.println("enter 3 for boolean");
		int ca= utility.inputInteger();
		System.out.println("enter no of rows");
		int row = utility.inputInteger();
		System.out.println("enter no of colum");
		int colums = utility.inputInteger();
		switch (ca) 
		{
		case 1:
			Integer[][] x= new Integer[row][colums];
			for(int i = 0; i<row;i++)
			{
				for(int j = 0; j<colums;j++)
				{
					System.out.println("enter x["+i+"]["+j+"] element of array");
					x[i][j] = utility.inputInteger();
				}
			}
			printArray(x, row, colums);
			break;
			case 2:
				Double[][] x1 = new Double[row][colums];
				for(int i = 0; i<row;i++)
				{
					for(int j = 0; j<colums;j++)
					{
						System.out.println("enter x["+i+"]["+j+"] element of array");
						x1[i][j] = utility.inputDouble();
					}
				}
				printArray(x1, row, colums);
				break;
				case 3:
					Boolean[][] x2 = new Boolean[row][colums];
					for(int i = 0; i<row;i++)
					{
						for(int j = 0; j<colums;j++)
						{
							System.out.println("enter x["+i+"]["+j+"] element of array");
							x2[i][j] = utility.inputBoolean();
						}
					}
					printArray(x2, row, colums);
					break;
					default:
						System.out.println("enter correct number");
						break;
		}
	}
	/**
	 * @param x = name of the 2d array which we want to print
	 * @param row = number of rows in that array
	 * @param colums = number of colums in that array
	 */
	public  static <T> void printArray(T[][] x,int row,int colums) 
	{
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < row; i++) 
		{
			for(int j = 0;j<colums;j++)
			{
			printWriter.print(x[i][j]+" ");
			printWriter.flush();
			}
			printWriter.println();
		}
		
	}
	/**
	 * @param t = temperature in Fahrenheit
	 * @param v = wind speed in  miles per hours
	 * calculate and print the wind chill 
	 */
	public static void windChill(double t,double v)
	{
		if(t>50 || v>120 || v<3)
		{
			System.out.println("can't calculate for these value");
		}
		else
		{
			double windChill = 35.74 + (0.6215*t)+ (((0.4275*t)-35.75) *Math.pow(v, 0.16));
			System.out.println(windChill);
		}
	}
	/**
	 * @param x x-axis coordinate
	 * @param y y-axis coordinate
	 * @return distance b/w origin and the given coordinates
	 */
	public static double euclideanDistance(int x,int y)
	{
		double distance = Math.sqrt((x*x)+(y*y));
		return distance;
	}
	/**
	 * @param n = numer till which power of two has to be calculate
	 * generate table of 2 pow 1 to 2 pow till number entered by user
	 */
	public static void power(int n)
	{
		int value =0;
		if(n<0|| n>31)
		{
			System.out.println("stack overflow");
		}
		else
		{
			for(int i = 0;i<=n;i++)
			{
				value = (int) Math.pow(2, i);
				System.out.println("2^"+i+" = " + value);
			}
		}
	}
	/**
	 * @param n = represent till which number we have to find harmonic series sum
	 * it print the sum of n harmonic number
	 */
	public static void harmonic(double n)
	{
		double sum = 0;
		if(n==0)
		{
			System.out.println("enter a non zero number");
		}
		else
		{
			for(int i = 1; i<= n; i++)
			{
				sum+=(double)1/i;
			}
			System.out.println(sum);
		}
	}
	/**
	 * @param n = takes number whose primeFactorization we have to found
	 * print prime factor of the number
	 */
	public static void primeFactorization(int n)
	{
		for(int i = 1;i<n;i++)
		{
			if(n%i==0 && prime(i))
			{
				System.out.println(i);
			}
		}
	}
	/**
	 * @param number = number which has to be checked whether prime or not
	 * @return boolean if number prime then true else false
	 */
	public static boolean prime(int number)
	{
		boolean b = false;
		for(int i = 2; i < number; i ++)
		{
			if(number % i ==0)
			{
				b = false;
				break;
			}
			else
			{
				b= true;
			}
		}
		if(number == 2)
		{
			b= true;
		}
		return b;
	}
	/**
	 * method to play tictoe game with computer
	 */
	public static void tictoe()
	{
		Utility utility = new Utility();
		String[][] x = new String[3][3];
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j <3;j++)
			{
				x[i][j]=" ";
				System.out.println(x[i][j]);
			}
		}
		int row = 0;
		int colum = 0;
		int min = 0;
		boolean playerchance = true;
		boolean computerchance = true;
		Random random = new Random();
		tictoedisplay(x);
		l :
		while(true)
		{
			if(placeLeft(x) != 0)
			{
				while(playerchance)
				{
					System.out.println("player x enter your position");
					int position = utility.inputInteger();
					switch (position)
					{
					case 1:
						row = 0;
						colum = 0;
						break;
					case 2:
						row = 0;
						colum = 1;
						break;
					case 3:
						row = 0;
						colum = 2;
						break;
					case 4:
						row = 1;
						colum = 0;
						break;
					case 5:
						row = 1;
						colum = 1;
						break;
					case 6:
						row = 1;
						colum = 2;
						break;
					case 7:
						row = 2;
						colum = 0;
						break;
					case 8:
						row = 2;
						colum = 1;
						break;
					case 9:
						row = 2;
						colum = 2;
						break;

					default:
						System.out.println("enter b/w 1 to 9");
						continue;
						
					}
					if(x[row][colum].equals(" "))
					{
						x[row][colum]="x";
						playerchance = false;
						computerchance = true;
					}
					else
					{
						System.out.println("enter diffent cell this one already occupy");
					}
				}
				tictoedisplay(x);
				if((x[0][0]==x[0][1] && x[0][1]==x[0][2] && x[0][2].equals("x"))||
						   (x[1][0]==x[1][1] && x[1][1]==x[1][2] && x[1][2].equals("x"))||
						   (x[2][0]==x[2][1] && x[2][1]==x[2][2] && x[2][2].equals("x"))||
						   (x[0][0]==x[1][0] && x[1][0]==x[2][0] && x[2][0].equals("x"))||
						   (x[0][1]==x[1][1] && x[1][1]==x[2][1] && x[2][1].equals("x"))||
						   (x[0][2]==x[1][2] && x[1][2]==x[2][2] && x[2][2].equals("x"))||
						   (x[0][0]==x[1][1] && x[1][1]==x[2][2] && x[2][2].equals("x"))||
						   (x[0][2]==x[1][1] && x[1][1]==x[2][0] && x[2][0].equals("x")))
						{
							System.out.println("player wins");
							break l;
						}
			}
			else
			{
				System.out.println("draw");
				break l;
			}
			if(placeLeft(x) != 0)
			{
				while(computerchance)
				{
					row = min +random.nextInt(3);
					colum =min+ random.nextInt(3);
					if(x[row][colum].equals(" "))
					{
						x[row][colum]="o";
						playerchance = true;
						computerchance= false;
					}
				}
				tictoedisplay(x);
				if((x[0][0]==x[0][1] && x[0][1]==x[0][2] && x[0][2].equals("o"))||
						   (x[1][0]==x[1][1] && x[1][1]==x[1][2] && x[1][2].equals("o"))||
						   (x[2][0]==x[2][1] && x[2][1]==x[2][2] && x[2][2].equals("o"))||
						   (x[0][0]==x[1][0] && x[1][0]==x[2][0] && x[2][0].equals("o"))||
						   (x[0][1]==x[1][1] && x[1][1]==x[2][1] && x[2][1].equals("o"))||
						   (x[0][2]==x[1][2] && x[1][2]==x[2][2] && x[2][2].equals("o"))||
						   (x[0][0]==x[1][1] && x[1][1]==x[2][2] && x[2][2].equals("o"))||
						   (x[0][2]==x[1][1] && x[1][1]==x[2][0] && x[2][0].equals("o")))
						{
							System.out.println("computer wins");
							break l;
						}
			}
			else
			{
				System.out.println("draw");
				break l;
			}
		}
		System.out.println("game over");
	}
	public static int placeLeft(String[][] x)
	{
		int count = 0;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(x[i][j].equals(" "))
				{
					count++;
				}
			}
		}
		return count;
	}
	/**
	 * @param x = to print the table of tietoe game on console
	 */
	public static void tictoedisplay(String[][] x)
	{
		System.out.println(x[0][0]+"|"+x[0][1]+"|"+x[0][2]);
		System.out.println("------");
		System.out.println(x[1][0] +"|"+x[1][1]+"|"+x[1][2]);
		System.out.println("------");
		System.out.println(x[2][0]+"|"+x[2][1]+"|"+x[2][2]);
	}
	/**
	 * @param s = String which has to be printed with msg
	 * check whether String is greater then 3 character if it is them print it with msg
	 */
public	static void hello(String s)
	{
	if(s.length()>=3)
	{
	System.out.println("Hello " + s + ", How are you?");
	}
	else
	{
	System.out.println("enter string haveing 3 or more charater");
	}

	}


	/**
	 * @param n = number of times we have to flip the coin
	 * print the percent of head and tail occurrence
	 */
	public static void flipCoin(int n)
	{
	int tail = 0;
	int head = 0;
	for(int i = 1; i<=n;i++)
	{
	if(Math.random() <0.5)
	{
	tail++;
	}
	else
	{
	head++;
	}
	}
	double headPercent = (head * 100) /n;
	double tailPercent = (tail * 100) /n;
	System.out.println("Head percent" + headPercent + "v/s tail Percent" + tailPercent);
	}


	/**
	 * @param y= year which is to be checked whether leap or not
	 * @return boolean if year is leap then true else false
	 */
	public static boolean leap(int y)
	{
	if(y%4==0)
			{
				if(y%100==0)
				{
					if(y%400==0)
					{
						return true;
					}
					else
					{
						return false;
					}
					
				}
				else
				{
					return true;
				}
			}
			else
			{
				return false;
			}
	}
	public static long start()
	{
		return  System.currentTimeMillis();
	}
	public static long end()
	{
		return  System.currentTimeMillis();
	}
	public static long timeLaps(long start, long end)
	{
		return end - start;
	}
	
	/**
	 * @param x = name of the integer type array to be sorted
	 * @return sorted array of integer type
	 */
	public	static int[] sort(int[] x)
		{
			int l = x.length;
			for(int i = 0; i <l-1;i++)
			{
				for(int j = i+1;j<l;j++)
				{
					if(x[i] > x[j])
					{
						int temp = x[i];
						x[i] = x[j];
						x[j] = temp;
					}
				}
			}
			return x;
		}
		/**
		 * @param x = name of String type array to be sorted
		 * @return sorted array of String type
		 */
	public	static String[] sort(String[] x)
		{
			int l = x.length;
			for(int i = 0; i <l-1;i++)
			{
				for(int j = i+1;j<l;j++)
				{
					if(x[i].compareTo(x[j])>0)
					{
						String temp = x[i];
						x[i] = x[j];
						x[j] = temp;
					}
				}
			}
			return x;
		}

		/**
		 * @param x = String type array in which String is to be searched
		 * @param key = string to be Search
		 * @return boolean true if key is found else false
		 */
	public	static boolean serarch(String[] x,String key)
		{
			for(int i = 0;i<x.length;i++)
			{
				if(key.equals(x[i]))
				{
					return true;
				}
				
			}
			return false;
		}

		/**
		 * @param s1 = String to be checked anagram with other string
		 * @param s2 = String to be checked anagram with other string
		 * @return boolean true if Strings are anagram else false
		 */
		public static boolean anagram(String s1,String s2)
		{
			String s3 = s1.replaceAll(" +", "").toLowerCase();
			String s4 = s2.replaceAll(" +", "").toLowerCase();
			char[] ch1 = s3.toCharArray();
			char[] ch2 = s4.toCharArray();
			int l1 = ch1.length;
			int l2 = ch2.length;
			for(int i = 0; i < l1; i++)
			{
				l :
				for(int j = 0; j < l2; j++)
				{
					if(ch1[i]==ch2[j])
					{
						for(int k = j; k <l2-1;k++)
						{
						ch2[k]= ch2[k+1];
						}
						l2--;
						break l;
					}
				}
			}
			if(l2==0)
			{
			return true;
			}
			else
			{
				return false;
			}
		}

		/**
		 * @param change = amount for which min number of change to be found
		 * @param count = total number of notes return in starting take it as 0
		 * @param h = refrence variable of hashset
		 * print the notes return by vending machine and and min number of notes to be return
		 * its a recursive method
		 */
		public static void vending(int change,int count,HashSet h)
		{
			int[] x = {1000,500,100,50,10,5,2,1};
			for(int i = 0; i<x.length;i++)
			{
				if(change>= x[i])
				{
					change = change - x[i];
					count++;
					h.add(x[i]);
					break;
				}	
			}
			if(change == 0)
			{
				 System.out.println(count);
				 System.out.println(h);
				return;
			}
			vending(change,count,h);
		}
		/**
		 * @param n = number to be checked whether palindrome or not
		 * @return boolean true if number is palindrome else false
		 */
		public static boolean Palindrome(int n)
		{
			String s = Integer.toString(n);
			String s1 ="";
			for(int i = s.length()-1;i>=0;i--)
			{
				s1+=s.charAt(i);
			}
			if(s1.equals(s))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		/**
		 * @param n1 = number to be checked with other number whether it is anagram or not
		 * @param n2 = number to be checked with other number whether it is anagram or not
		 * @return boolean true if both number anagram else false
		 */
		public static boolean anagram(int n1,int n2)
		{
			String s3 = Integer.toString(n1);
			String s4 = Integer.toString(n2);
			char[] ch1 = s3.toCharArray();
			char[] ch2 = s4.toCharArray();
			int l1 = ch1.length;
			int l2 = ch2.length;
			for(int i = 0; i < l1; i++)
			{
				l :
				for(int j = 0; j < l2; j++)
				{
					if(ch1[i]==ch2[j])
					{
						for(int k = j; k <l2-1;k++)
						{
						ch2[k]= ch2[k+1];
						}
						l2--;
						break l;
					}
				}
			}
			if(l2==0)
			{
			return true;
			}
			else
			{
				return false;
			}
			
		}
		/**
		 * @param v = value of temperature to be changed
		 * @param c = determine whether value is in Celsius  or in Fahrenheit 
		 * @return temperature in celsius if imput is in fahrenheit vice-versa
		 */
		public static double temperaturConversion(double v,String c)
		{
			if(c=="f")
			{
				return  ((v*9)/5) + 32;
			}
			else
			{
				return ((v-32)*5)/9;
			}
		}
		/**
		 * @param x = name of the array to be sorted
		 * @return sorted integer type array by useing insertionSort algorithm
		 */
		public static int[] insertionSort(int[] x)
		{
			int key=0;
			int j=0;
			for(int i = 0; i < x.length;i++)
			{
				j= i-1;
				key = x[i];
			while(j>=0 && x[j]>key)
			{
				x[j+1] = x[j];
				j--;
			}
			x[j+1] = key;
			}
			return x;
		}
		/**
		 * @param x = String type of array which is to be sorted
		 * @return String type sorted array use insertion sort algo 
		 */
		public static String[] insertionSort(String[] x)
		{
			String key="";
			int j=0;
			for(int i = 0; i < x.length;i++)
			{
				j= i-1;
				key = x[i];
				
			while(j>=0 && x[j].compareTo(key)>0)
			{
				x[j+1] = x[j];
				j--;
			}
			x[j+1] = key;
			}
			return x;
		}
		/**
		 * @param x = integer type array which is to be sort 
		 * @return sorted array useing bubblesort algo
		 */
	public	static int[] bubbleSort(int[] x)
		{
			for(int i = 0; i < x.length-1;i++)
			{
				for(int j = 0; j<x.length-i-1;j++)
				{
					if(x[j] > x[j+1])
					{
						int temp = x[j];
						x[j] = x[j+1];
						x[j+1] = temp;
					}
				}
			}
			return x;
		}
		/**
		 * @param x =String type array which is to be sort 
		 * @return sorted array useing bubblesort algo
		 */
	public	static String[] bubbleSort(String[] x)
		{
			for(int i = 0; i < x.length-1;i++)
			{
				for(int j = 0; j<x.length-i-1;j++)
				{
					
					if(x[j].compareTo(x[j+1])>0)
					{
						String temp = x[j];
						x[j] = x[j+1];
						x[j+1] = temp;
					}
				}
			}
			return x;
		}
		/**
		 * @param m = month 
		 * @param d = day of month
		 * @param y = year
		 * return integer value 0 for sunday 1 for monday and so on
		 */
		public static int dayOfWeek(int m,int d,int y)
		{
			int y0 = y-((14-m)/12);
			int x = y0 + (y0/4) - (y0/100) + (y0/400);
			int m0 = m + (12*((14-m)/12)) -2;
			int d0 = (d+x+((31*m0)/12)) % 7;
			return d0;
			
		}
       /**
     * @param dayOfWeek = int value of week day
     * print the week day
     */
    public static void printDayOfWeek(int dayOfWeek)
       {
    	   switch (dayOfWeek) 
			{
			case 0:
				System.out.println("sunday");
				break;
			case 1:
				System.out.println("monday");
				break;
			case 2:
				System.out.println("tuesday");
				break;
			case 3:
				System.out.println("wednesday");
				break;
			case 4:
				System.out.println("thusday");
				break;
			case 5:
				System.out.println("friday");
				break;
			case 6:
				System.out.println("saturday");
				break;
			default:
				System.out.println("enter correct input");
				break;
			}
       }

		/**
		 * @param p=principle amount
		 * @param y = time in years
		 * @param R = rate of interest
		 * @return monthly amount to be payed
		 */
		public static double monthlyPayment(double p,double y,double R)
		{
			double r = R/(12 *100);
			double n = 12 * y;
			double pay = (p*r)/(1-Math.pow(1+r, -n));
			return pay;
		}
		/**
		 * @param c = number whose sqrt to be found
		 * print the sqrt of number
		 */
		public static void sqrt(int c)
		{
			if(c>=0)
			{
				double epsilon = 1e-15;
				double t = c;
				
				while((Math.abs(t-(c/t))) >epsilon *t)
				{
					t = (c/t + t)/2.0;
				}
				System.out.println(t);
			}
			else
			{
				System.out.println("enter a positive number");
			}
		}
		/**
		 * @param number = number which is to be converted to binary
		 * convert the number into binary number
		 */
		public static void toBinary(int number)
		{
			String binary = "";
			while(number != 0)
			{
				int reminder = number % 2;
				number = number/2;
				binary = reminder + binary;
			}
			System.out.println(binary);
			int number1 = 0;
			int j = 0;
			int digit = 0;
			int binary1 = Integer.parseInt(binary);
			String respretation = "";
			while(binary1 != 0)
			{
				digit = binary1 % 10;
				if(digit == 1)
				{
					number1 += Math.pow(2, j);
					respretation ="+ " +(int)Math.pow(2, j) + respretation;
				}
				binary1 = binary1/10;
				j++;
			}
			String finalreprsentation = number1 + " = " + respretation.substring(1, respretation.length());
			System.out.println(finalreprsentation);
		}
		/**
		 * @param number = number to be converted into binary
		 * convert number into binary then swap it from center then convert new binary to number
		 */
		public static void binary(int number)
		{
			String binary = "";
			while(number != 0)
			{
				int reminder = number % 2;
				number = number/2;
				binary = reminder + binary;
			}
			for(int i = binary.length();i<8;i++)
			{
				binary = 0 + binary;
			}
			String nible1 = binary.substring(0, 4);
			String nible2 = binary.substring(4, 8);
			String newBinary = nible2+nible1;
			int number1 = Integer.parseInt(newBinary);
			int j = 0;
			int number2 = 0;
			int digit = 0;
			while(number1 != 0)
			{
				digit = number1 % 10;
				if(digit == 1)
				{
					number2 += Math.pow(2, j);
				}
				j++;
				number1 = number1/10;
			}
			System.out.println(number2);
			
			}
		
		

}
