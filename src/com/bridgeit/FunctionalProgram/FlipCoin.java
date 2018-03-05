package com.bridgeit.FunctionalProgram;

import com.bridgeit.Utility;

class FlipCoin
{
  public static void main(String[] args)
{
Utility utility = new Utility();
System.out.println("enter number of times coin to be flip");
int numberOfTimes = utility.inputInteger();
Utility.flipCoin(numberOfTimes);
}
}
