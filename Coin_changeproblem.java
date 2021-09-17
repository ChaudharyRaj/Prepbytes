package Daynamic_Programming;
import java.util.*;
public class Coin_changeproblem{
	
	
	static int chnageCoin(int[] arr, int sum, int n){
		
		int dp [][] =  new int[n+1][sum+1];
		for(int i = 0; i<sum+1; i++)
			dp[0][i] = 0;
		
		for(int i = 1; i<n+1; i++)
			dp[i][0] = 1;
		
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j< sum+1; j++){
				if(arr[i-1] <= j){
					dp[i][j] = dp[i][j-arr[i-1]]+dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}
	
	public static void main(String[] args){
		
	 	int arr[] = {1, 2, 3};
        int n = arr.length;
        int m = 4;
        int res =  chnageCoin(arr,m,n);
        System.out.println(res);
	}

}
