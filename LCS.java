package Daynamic_Programming;

public class LCS{
	
	static int memo[][];
	
	private static int LcsCount(char[] s1, char[] s2, int n, int m){
		
		if(n == 0 || m == 0)
			return 0; 
		
		if(memo[n][m] != -1)
			return memo[n][m];
		
		if(s1[n-1] == s2[m-1]){
			return memo[n][m] = (1+LcsCount(s1, s2, n-1, m-1));
		}else{
			return memo[n][m] = Math.max(LcsCount(s1, s2, n-1, m), LcsCount(s1, s2, n, m-1));
		} 
	}
	
	static int LcsCountTabulation(char[] x, char[] y,int n, int m){
		
		
		int dp[][] = new int[n+1][m+1];
		for(int i = 0; i<n+1; i++){
			for(int j = 0; j<m+1; j++){
				if( i ==0 || j == 0)
					dp[i][j] = 0;
			}
		}
		
		for(int i = 1; i<n+1; i++){
			for(int j =1; j <m+1; j++){
				if(x[i-1] == y[j-1]){
					dp[i][j] = (1+dp[i-1][j-1]);
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[n][m];
	}
	
	
	public static void main(String[] args){
		 
		 String s1 = "AGGTAB";
		 String s2 = "GXTXAYB";
		 int n = s1.length();
		 int m = s2.length();
		 char str1[] = s1.toCharArray();
		 char str2[] = s2.toCharArray();
//		 memo =  new int[n+1][m+1];
//		 
//		 for(int i = 0; i<n+1; i++){
//			 for(int j = 0; j<m+1; j++){
//				 memo[i][j] = -1;
//			 }
//		 }
//		 int ans = LcsCount(str1,str2,n,m);
		 
		 int ans = LcsCountTabulation(str1, str2, n, m);
		 System.out.println(ans);
	}
}
