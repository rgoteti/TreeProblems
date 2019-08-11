package com.rgoteti.ds.dynamicprogramming;

public class KnapSack {

	public static void main(String[] args) {
		int weights[] = { 1, 3, 4 , 5};
		int profits[] =  { 15, 50, 60,90 };
		int capacity= 8;		
		KnapSack kp = new KnapSack();
		System.out.println(kp.bruteForce(weights, profits, capacity, 0));
		Integer[][] dp= new Integer[profits.length][capacity+1];
		System.out.println(kp.topDownOrMemoization(weights, profits, capacity, 0, dp));
		int[][] dp1= new int[profits.length][capacity+1];
		System.out.println(kp.bottomUpOrTabluation(weights, profits, capacity, dp1));
	}

	public int bruteForce(int[] weights, int[] profits, int capacity, int currentIndex)
	{
		if(capacity<=0 || currentIndex>= profits.length)
			return 0;
		
		int profit1=0;
		int profit2=0;
		if(weights[currentIndex]<=capacity)
		{
			profit1 = profits[currentIndex]+bruteForce(weights, profits, capacity-weights[currentIndex], currentIndex);
		}
		profit2 = bruteForce(weights,profits,capacity, currentIndex+1);		
		return Math.max(profit1, profit2);
	}
	
	public int topDownOrMemoization(int[] weights, int[] profits, int capacity, int currentIndex, Integer[][] dp)
	{
		if(capacity<=0|| currentIndex >= profits.length ) return 0;
		
		int profit1=0;
		int profit2=0;
		if(dp[currentIndex][capacity]==null)
		{
			if(weights[currentIndex]<=capacity)
				profit1 = profits[currentIndex]+topDownOrMemoization(weights, profits, capacity-weights[currentIndex], currentIndex,dp);
			profit2 = topDownOrMemoization(weights, profits, capacity, currentIndex+1, dp);
			
			dp[currentIndex][capacity]= Math.max(profit1, profit2);
		}
		return dp[currentIndex][capacity];
	}
	
	public int bottomUpOrTabluation(int[] weights, int[] profits, int capacity, int dp[][])
	{
		if(capacity<=0 || profits.length <=0 || weights.length!=profits.length)
			return 0;		
		
		int n = profits.length;
		for(int i=0;i<n;i++)
			dp[i][0]=0;	
		
		for(int i=0;i<n;i++)
		{
			for(int c=1;c<=capacity;c++)
			{
				int profit1 = 0;
				int profit2 =0;
				if(i>0)
					profit1 = dp[i-1][c];				
				if(weights[i]<=c)
					profit2 = profits[i]+ dp[i][c-weights[i]];
				
				dp[i][c] = Math.max(profit1, profit2);
 			}
		}
		
		return dp[n-1][capacity];
	}
	
	public void printIndexs(int dp[][])
	{
		
	}
}
