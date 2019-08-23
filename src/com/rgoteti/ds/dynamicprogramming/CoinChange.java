package com.rgoteti.ds.dynamicprogramming;

public class CoinChange {
	public static void main(String args[])
	{
		int denominations[] =  {1,2,3};
		int amount= 5;		
		CoinChange cc = new CoinChange();
		System.out.println(cc.bruteForce(denominations, amount, 0));
		Integer[][] dp = new Integer[denominations.length][amount+1];
		System.out.println(cc.topDownOrMemoization(denominations, amount, 0, dp));
		int[][] dp1 = new int[denominations.length][amount+1];
		System.out.println(cc.bottomUpOrTabluation(denominations, amount, 0, dp1));
		
	}
	
	public int bruteForce(int[] coins, int amount, int currentIndex)
	{
		if(currentIndex >= coins.length) 
			return 0;
		if(amount == 0) 
			return 1;
		
		int sum1=0, sum2=0;
		if(coins[currentIndex]<=amount)
			sum1 = bruteForce(coins, amount-coins[currentIndex],currentIndex);
		sum2 = bruteForce(coins, amount,currentIndex+1);
		return sum1+sum2;
	}
	
	public int topDownOrMemoization(int[] coins, int amount, int currentIndex, Integer[][] dp)
	{
		if(currentIndex >= coins.length)
			return 0;
		if(amount == 0)
			return 1;
		
		if(dp[currentIndex][amount]==null)
		{
			int sum1=0, sum2=0;
			if(coins[currentIndex]<=amount)
				sum1 = topDownOrMemoization(coins, amount-coins[currentIndex], currentIndex, dp);
			sum2 = topDownOrMemoization(coins, amount, currentIndex+1, dp);
			dp[currentIndex][amount] = sum1+sum2;
		}
		return dp[currentIndex][amount];
	}
	
	public int bottomUpOrTabluation(int[] coins, int amount, int currentIndex, int[][] dp)
	{
		if(coins.length <0 || amount <0)
			return 0;
		if(amount==0)
			return 1;		
		for(int i=0;i<coins.length;i++)
			dp[i][0]=1;
		
		for(int i=0;i<coins.length;i++)
		{
			for(int c=1;c<=amount;c++)
			{
				int sum1=0, sum2=0;
				if(i>0)
					sum2 = dp[i-1][c];
				if(coins[i]<=c)
					sum1 = dp[i][c-coins[i]];
				
				dp[i][c] = sum1+sum2;
			}
		}
		return dp[(coins.length)-1][amount];
	}
}
