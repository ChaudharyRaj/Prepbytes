package Daynamic_Programming;

import java.util.Arrays;

public class MatrixChainMultiplication {
	static int dp[][];
	private static int solve(int[]  arr , int i , int j){
		
		if(i >= j)
			return 0;
		
	
		if(dp[i][j] != -1)
			return dp[j][j];
		dp[i][j] = Integer.MAX_VALUE;
		
		for(int k  = i; k <= j-1; k++){
			
			int temp = solve(arr,i,k)+solve(arr, k+1, j)+arr[i-1]*arr[k]*arr[j];
			
			dp[i][j] = Math.min(dp[i][j],temp);
		}
		return dp[i][j];
	}
	
	private static int MCM(int[] arr, int n){
		
		dp = new int[n+1][n+1];
		
		for(int row[] : dp)
			Arrays.fill(row, -1);
		
		return solve(arr,1,n-1);
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4};
        int n = arr.length;
        int res = MCM(arr,n);
        System.out.println(res);
	}

}
