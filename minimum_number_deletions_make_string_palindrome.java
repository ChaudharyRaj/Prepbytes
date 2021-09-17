package Daynamic_Programming;
public class minimum_number_deletions_make_string_palindrome{
	
	private static int LPS(String x, String y){
		
		int n = x.length();
		int m = y.length();
		
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i<n+1; i++){
			for(int j = 0; j<m+1; j++){
				if(i == 0 || j ==0)
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
		System.out.println(dp[n][m]);
		return dp[n][m];
	}
	
	private static int solve(String s1){
		
		StringBuffer sb = new StringBuffer();
		sb.append(s1).reverse();
		int n = s1.length();
		int lps = LPS(s1,sb.toString());
		return n - lps;
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		String s1 = "banana";
		int ans  = solve(s1);
		System.out.println(ans);
	}
}
