/*
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. 
 * The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2. 
 * It could be possible that the same character needs to be removed/deleted 
 * from one point of str1 and inserted to some another point.*/

package Daynamic_Programming;
public class Convert_String_toString_b {
	
	private static int findLCS(String s1, String s2, int n, int m){
		
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i<n+1; i++){
			for(int j = 0; j<m+1; j++){
				if(i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}
		
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j<m+1; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[n][m];
	}
	
	private static void MinDelAndInsert(String s1, String s2){
		
		int n = s1.length();
		int m = s2.length();
		int lcs =  findLCS(s1,s2,n,m);
		int minD = n-lcs;
		int minI = m-lcs;
		System.out.println(minD+" "+minI);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "heap";
		String s2 = "pea";
		MinDelAndInsert(s1,s2);
	}
}
