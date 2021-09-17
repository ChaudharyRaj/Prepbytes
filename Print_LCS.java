package Daynamic_Programming;
import java.util.*;

public class Print_LCS{
	
	static int[][] dp;
	private static void Lcs(String x, String y, int n,int m){
		
		dp =  new int[n+1][m+1];
		for(int i = 0; i<n+1; i++){
			for(int j =0; j<m+1; j++){
				if(i ==0 || j== 0)
					dp[i][j] = 0;
			}
		}
		
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j<m+1; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = (1+dp[i-1][j-1]);
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
	}
	
	
	private static void printLcs(String x, String y, int n , int m){
		
		StringBuilder sb =  new StringBuilder();
		Lcs(x,y,n,m);
		int i = n;
		int j = m;
		
		while(i > 0 && j > 0){
			
			if(x.charAt(i-1) == y.charAt(j-1)){
				sb.append(x.charAt(i-1));
				i--;
				j--;
			}else{
				
				if(dp[i-1][j] > dp[i][j-1])
					i--;
				else
					j--;
			}
		}
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args){
		
		String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int n = s1.length();
        int m = s2.length();
        printLcs(s1,s2,n,m);
       
	}
}
