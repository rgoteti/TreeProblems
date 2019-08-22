package com.rgoteti.ds.dynamicprogramming;

public class RodCutting {

	public static void main(String[] args) {
		
		int lengths[] = { 1, 2, 3, 4, 5};
		int prices[] = {2, 6, 7, 10, 13};
		int length= 5;
		RodCutting road = new RodCutting();
		System.out.println(road.bruteForce(lengths, prices, length, 0));
		Integer[][] dp = new Integer[lengths.length][length+1];
		System.out.println(road.topDownOrMemoization(lengths, prices, length, 0, dp));
		int[][] dp1 = new int[lengths.length][length+1];
		System.out.println(road.bottomUpOrTabluation(lengths, prices, length, 0, dp1));
	}

	public int bruteForce(int[] lengths, int[] prices, int capacity, int currentIndex )
	{
		if(currentIndex >= lengths.length)
			return 0;
		
		int profit1 =0;
		int profit2 =0;
		if(lengths[currentIndex] <= capacity)
		{
			profit1 = prices[currentIndex] + bruteForce(lengths, prices, capacity-lengths[currentIndex], currentIndex);
		}
		profit2 = bruteForce(lengths, prices, capacity, currentIndex+1);
		return Math.max(profit1, profit2);
	}
	
	public int topDownOrMemoization(int[] lengths, int[] prices, int capacity, int currentIndex, Integer[][] dp)
	{
		if(currentIndex >= lengths.length)
			return 0;
		
		if(dp[currentIndex][capacity]==null)
		{
			int profit1=0;
			int profit2=0;
			if(lengths[currentIndex]<=capacity)
			{
				profit1 =  prices[currentIndex]+topDownOrMemoization(lengths, prices, capacity-lengths[currentIndex],currentIndex,dp);
			}
			profit2 = topDownOrMemoization(lengths, prices, capacity,currentIndex+1,dp);
			dp[currentIndex][capacity]= Math.max(profit1, profit2);
		}
		return dp[currentIndex][capacity];
	}
	
	public int bottomUpOrTabluation(int[] lengths, int[] prices, int capacity, int currentIndex, int[][] dp)
	{
		if(lengths.length!=prices.length || capacity<=0 || lengths.length <0)
			return 0;
		
		int n= lengths.length;
		for(int i=0;i<n;i++)
			dp[i][0]=0;
		
		for(int i=0;i<n;i++)
		{
			for(int c=0; c<=capacity;c++)
			{
				int profit2 = 0;
				int profit1 = 0;
				if(i>0)
					profit2 = dp[i-1][c];
				if(lengths[i]<=c)				
					profit1 = prices[i] +dp[i][c-lengths[i]];
				dp[i][c]=Math.max(profit1, profit2);
			}
		}
		return dp[n-1][capacity];
	}
}
