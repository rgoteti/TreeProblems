package com.rgoteti.ds.dynamicprogramming;

public class Fibonacci {

	public static void main(String[] args) {
		
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.bruteForceFibonacci(6));
		int n=6;
		Integer[] dp = new Integer[n+1];
		System.out.println(fib.topDownOrMemoization(n, dp));
		int[] dp1 = new int[n+1];
		System.out.println(fib.bottomUpOrTabluation(n, dp1));
	}

	public int bruteForceFibonacci(int n)
	{
		if(n<2)
			return n;
		return  bruteForceFibonacci(n-1)+bruteForceFibonacci(n-2);
	}
	
	public int topDownOrMemoization(int n, Integer[] dp)
	{
		if(n<2)
			return n;
		if(dp[n]==null)
			dp[n] = topDownOrMemoization(n-1,dp)+topDownOrMemoization(n-2,dp);
		
		return dp[n];
	}
	
	public int bottomUpOrTabluation(int n, int[] dp)
	{
		dp[0]=0;
		dp[1]=1;

		for(int i=2;i<=n;i++)
			dp[i]= dp[i-1]+dp[i-2];
		
		return dp[n];
	}
}
