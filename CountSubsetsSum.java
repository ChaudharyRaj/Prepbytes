package Daynamic_Programming;
import java.util.*;
public class CountSubsetsSum{
	
	static int[][] memo;
	private static int  countSubsets(int[] arr, int sum, int n){
			
		if(sum == 0) return 1;
		if(n == 0 ) return 0;
		
		if(memo[n-1][sum] != -1)
			return memo[n-1][sum];
		
		if(arr[n-1] <= sum){
			return  memo[n-1][sum] = countSubsets(arr, sum-arr[n-1], n-1) + countSubsets(arr, sum, n-1);
		}else{
			return memo[n-1][sum] = countSubsets(arr, sum, n-1);
		}	
	}
	
	static int countSubsetsTabulation(int[] arr, int sum, int n){
		
		int[][] dp = new int[n+1][sum+1];
		dp[0][0] = 1;
		
		for(int i = 1; i<sum+1; i++)
			dp[0][i] = 0;
		
		for(int i = 1; i<n+1; i++)
			dp[i][0] = 1;
		
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j<sum+1; j++){
				
				if(arr[i-1] <= j){
					dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][sum];
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int n = 4;
	    int arr[] = {3,3,3,3};
	    int sum = 6;
	    memo = new int[n+1][sum+1];
	    for(int i= 0; i<n+1; i++)
	    	for(int j = 0; j<sum+1; j++)
	    		memo[i][j] = -1;
	    
	    //int ans  = countSubsets(arr,sum,n);
	    int ans = countSubsetsTabulation(arr, sum, n);
	    System.out.println(ans);
	}	
}
