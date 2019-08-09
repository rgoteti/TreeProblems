package com.rgoteti.ds.dynamicprogramming;

public class Binarykanpsack {

	public static void main(String[] args) {
		int weights[] =  { 2, 3, 1, 4 };
		int profits[] =  { 4, 5, 3, 7 };
		int capacity = 5;
		System.out.println(new Binarykanpsack().bruteForce(capacity, 0, weights, profits));
		Integer[][] dp = new Integer[profits.length][capacity + 1];
		System.out.println(new Binarykanpsack().topDownOrTabluation(capacity, 0, weights, profits, dp));
		System.out.println(new Binarykanpsack().bottomUpOrMemoization(capacity, weights, profits));
	}
	
	public int bruteForce(int capacity, int currentIndex, int[] weights, int[] profits)
	{
		if(capacity<=0 || currentIndex >= profits.length)
			return 0;		
		int profit1=0;
		if(weights[currentIndex]<=capacity)
			profit1 = profits[currentIndex]+bruteForce(capacity-weights[currentIndex], currentIndex+1, weights, profits);		
		int profit2 = bruteForce(capacity, currentIndex+1, weights, profits);		
		return Math.max(profit1, profit2);
	}

	
	public int topDownOrTabluation(int capacity, int currentIndex, int[] weights, int[] profits, Integer[][] dp)
	{
		if(capacity<=0 || currentIndex >= profits.length)
			return 0;		
		if(dp[currentIndex][capacity]==null)
		{
			int profit1=0;
			if(weights[currentIndex]<=capacity)
				profit1 = profits[currentIndex]+topDownOrTabluation(capacity-weights[currentIndex], currentIndex+1, weights, profits,dp);			
			int profit2 = topDownOrTabluation(capacity, currentIndex+1, weights, profits,dp);
			dp[currentIndex][capacity] =  Math.max(profit1, profit2);
		}		
		return dp[currentIndex][capacity];
	}
	
	public int bottomUpOrMemoization(int capacity, int[] weights, int[] profits )
	{
	    int[][] dp = new int[profits.length][capacity + 1];
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
		      return 0;		
		for(int i=0;i<profits.length;i++)
			dp[i][0]=0;		
		for(int c=0;c<=capacity;c++)
		{
			if(weights[0]<=c)
				dp[0][c]=profits[0];
		}
		for(int i=1;i<profits.length;i++)
		{
			for(int j=1;j<=capacity;j++)
			{
				int profit1 = 0; 
				int profit2 =0;
				if(weights[i] <= j)
					profit2 = profits[i]+dp[i-1][j-weights[i]];			
				profit1 = dp[i-1][j];
				dp[i][j]= Math.max(profit1, profit2);				
			}
		}
		return dp[profits.length-1][capacity];
	}
}
