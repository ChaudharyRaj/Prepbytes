package Daynamic_Programming;
import java.io.*;
import java.util.*;
public class CoinDivision {
	static int dp[][]=new int[40001][3];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int  t = Integer.parseInt(br.readLine());
		while(t-->0){
			String[] s1 = br.readLine().trim().split("\\s");
			int n = Integer.parseInt(s1[0]);
			String s[] = br.readLine().trim().split("\\s");
			int[] arr = new int[n];
			for(int i =0; i<n; i++){
				arr[i] = Integer.parseInt(s[i]);
			}
			for(int i = 0; i<dp.length; i++){
				for(int j = 0; j <dp[0].length; j++)
					dp[i][j] = -1;
			}
			int ans  = solve(0,0,arr,n);
			System.out.println(ans);
		}
	}
	private static int solve(int i, int sum, int[] arr, int n) {
		
		if(i == n)
			return 0;
		
		if(dp[i][sum] != -1)
			return dp[i][sum];
		
		int ans  = 0;
		   
			ans  = solve(i+1, sum, arr,n);
		
		if((sum+arr[i]+solve(i+1,(sum+arr[i])%3, arr,n))%3 == 0){
			
			ans = Math.max(ans,arr[i]+solve(i+1,(sum+arr[i])%3, arr,n));
		}
		return dp[i][sum] = ans;
	}

}
