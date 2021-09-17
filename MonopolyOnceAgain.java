package Daynamic_Programming;
import java.util.*;
import java.io.*;
public class MonopolyOnceAgain {
	
	static long[][] dp = new long[101][101];
	static int n, k;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().trim().split("\\s");
		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);
		String s1[] = br.readLine().trim().split("\\s");
		long arr[] =  new long[n];
		for(int i = 0; i<n; i++)
			arr[i] = Long.parseLong(s1[i]);
		
		for(int i = 0; i<dp.length; i++){
			for(int j = 0; j < dp[0].length; j++)
				dp[i][j] = -1;
		}
		
		long res = solve(arr ,0,n-1);
		System.out.println(res);
	}

	private static long solve(long[] arr , int start, int end){
		
		
		if(dp[start][end] != -1)
			return dp[start][end];
		
		long sz = (end-start+1);
		long diff = n-sz;
		diff = (diff)/k;
		
		if(diff%2 == 0){
			
			if(sz <= k){
				long sum = 0;
				for(int i = start; i<=end; i++){
					sum+=arr[i];
				}
				return dp[start][end] = sum;
			}else{
				long val1 = Integer.MIN_VALUE;
				for(int i = 0; i<=k; i++){
					int cnt1 = i,cnt2 = k-i;
					int st1 = start, end1 = end;
					long sum = 0;
					while(cnt1>0){
						sum +=arr[st1];
						st1++;
						--cnt1;
					}
					while(cnt2>0){
						sum += arr[end1];
						--end1;
						--cnt2;
					}
					val1 = Math.max(val1,sum+solve(arr,st1,end1));
				}
				return dp[start][end] = val1;
			}
			
		}else{
			
			if(sz <= k){
				return dp[start][end] = 0;
			}else{
				
				long val2 = Integer.MAX_VALUE;
	            for(int i = 0; i<=k; i++){
	                int j=k-i;
	                val2=Math.min(val2,solve(arr,start+i,(end-j)));
	            }
	            return dp[start][end] = val2;
			}
		}
	}

}
