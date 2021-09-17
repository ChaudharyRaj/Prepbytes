package Daynamic_Programming;
import java.util.*;
public class subsetsSum {
	static int memo[][];
	public static void main(String[] args) {
		
		 int arr[] = {1, 5, 3};
		 int n = arr.length;
		 System.out.println(isEqualPart(arr,n));
	}

	private static boolean isEqualPart(int[] arr, int n) {
		
		int sum = 0;
		for(int i = 0; i<n; i++)
			sum += arr[i];
		
		if(sum%2 != 0)
			return false;
		else{
			
			//return isSubset(arr,sum/2,n) == 1 ? true :false;
			
			boolean dp[][] =  new boolean[n+1][(sum/2)+1];
			
			for(int i = 0; i <n; i++)
				for(int j = 0; i<(sum/2)+1; j++)
					if(i == 0) dp[i][j] = false;
					else if(j ==0) dp[i][j] = true;
			
			// Tabulation technique
			for(int i = 1; i<n+1; i++){
				for(int j = 1; j<sum/2+1; j++){
					
					if(arr[i-1] > j ){
						dp[n][j] = dp[i-1][j];
					}else{
						dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
					}
				}
			}
			return dp[n-1][sum/2];
		}
	}
	
	
	//Memorization technique
	private static int isSubset(int[] arr, int sum, int n){
		
		if(sum == 0) return 1;
		if(n == 0) return 0;
		
		if(memo[n-1][sum] != -1)
			return memo[n-1][sum];
			
		if(arr[n-1] > sum)
			return memo[n-1][sum] = isSubset(arr, sum, n-1);
		else
			return memo[n-1][sum] = Math.max(isSubset(arr, sum-arr[n-1], n-1),isSubset(arr, sum, n-1));
	}
}
