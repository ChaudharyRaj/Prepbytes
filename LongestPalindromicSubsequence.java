package Daynamic_Programming;

public class LongestPalindromicSubsequence {
	private static int LCS(String x, String y){
		
		int n = x.length();
		int m = y.length();
		int[][]  dp = new int[n+1][m+1];
		
		
		for(int i = 0; i<n+1; i++){
			for(int j = 0; j<m+1; j++){
				if(i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}
		
		for(int i =1; i<n+1; i++){
			for(int j = 1; j<m+1; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[n][m];
	}
	private static int LPS(String seq){
		int n = seq.length();
		StringBuffer sb =  new StringBuffer();
		sb.append(seq).reverse();
		String seq1 = sb.toString();
		return LCS(seq,seq1);
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		String seq = "aagbcba";
		int ans = LPS(seq);
		System.out.println(ans);
	}
}
