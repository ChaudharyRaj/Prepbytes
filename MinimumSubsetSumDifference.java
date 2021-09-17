package Daynamic_Programming;
import java.util.*;
public class MinimumSubsetSumDifference {
	
	static int[][] dp;
	
	private static void subsetSum(int[] arr, int sum ,int n){
		
		dp = new int[n+1][sum+1];
		for(int i = 0; i<sum+1; i++)
			dp[0][i] = 0;
		for(int i = 0; i < n+1; i++)
			dp[i][0] = 1;
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j<sum+1; j++){
				
				if(arr[i-1] <= j){
					dp[i][j] = Math.max(dp[i-1][j-arr[i-1]],dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
	}
	private static int solve(int[] arr, int n){
		
		int sum = 0;
		for(int i : arr)
			sum +=i;
		
		System.out.println("Sum: "+sum);
		subsetSum(arr,sum,n);
		
		//System.out.println(dp[n][sum]);

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i<=sum/2; i++){
			
			if(dp[n][i] == 1) list.add(i);
		}
		int diff = Integer.MAX_VALUE;
		
		for(int i =0; i <list.size(); i++){
			diff = Math.min(diff, sum - 2*list.get(i));
		}
		return diff;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        int res = solve(arr,n);
        System.out.println(res);
	}

}
