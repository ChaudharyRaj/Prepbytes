package Daynamic_Programming;

public class ShortestCommonSupersequence {
	
	private static int LCS(String s1, String s2, int n, int m) {
		
		int[][] dp = new int[n+1][m+1];
		
		for(int i = 0; i<n+1; i++){
			for(int j =0; j<m+1; j++){
				if(i ==0 || j ==0)
					dp[i][j] = 0;
			}
		}
		
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j<m+1; j++){
				
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = (1+dp[i-1][j-1]);
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[n][m];
	}
	private static int SCS(String s1, String s2){
		int n = s1.length();
		int m = s2.length();
		int lcs = LCS(s1,s2,n,m);
		return (n+m)-lcs;
	}
	
	public static void main(String[] args){
		
		String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(SCS(s1,s2));
		
	}
}
