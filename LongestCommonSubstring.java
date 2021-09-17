package Daynamic_Programming;

public class LongestCommonSubstring{
	
	static int[][] memo;
	private static int LcsCount(char[] x, char[] y, int n, int m, int count){
		
		if(n == 0 || m == 0)
			return count;
		
		if(memo[n][m] != -1)
			return memo[n][m];
		
		if(x[n-1] == y[m-1]){
			memo[n][m] = (LcsCount(x, y, n-1, m-1,count+1));
		}else{ 
			memo[n][m] = Math.max(LcsCount(x, y, n-1, m-1,0),LcsCount(x, y, n, m-1, 0));
		}
		return count;
	}
	
	static int LcsCountTabulation(char[] x, char[] y, int n, int m){
		
		int[][] dp =  new int[n+1][m+1];
		int res = 0;
		for(int i = 0; i<n+1; i++){
			for(int j = 0; j<m+1; j++){
				if( i == 0|| j ==0){
					dp[i][j] = 0;
				}
			}
		}
		
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j <m+1; j++){
				if(x[i-1] == y[j-1]){
					dp[i][j] = (1+dp[i-1][j-1]);
					res = Math.max(res,dp[i][j]);
				}else{
					dp[i][j] = 0;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		 String X = "OldSite:GeeksforGeeks.org";
	     String Y = "NewSite:GeeksQuiz.com";
	     int n = X.length();
	     int m = Y.length();
	     char x[] = X.toCharArray();
	     char y[] = Y.toCharArray();
	     memo =  new int[n+1][m+1];
	     
	     for(int i = 0; i<n+1; i++){
	    	 for(int  j =0; j<m+1; j++){
	    		 memo[i][j] = -1;
	    	 }
	     }
	     //int res = LcsCount(x,y,n,m,0);
	     int res = LcsCountTabulation(x,y,n,m);
	     System.out.println(res);
	}	
}
