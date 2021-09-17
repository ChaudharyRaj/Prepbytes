package Daynamic_Programming;

import java.util.Arrays;

public class PalindromePartitioning {
	static int[][] memo;
	private static boolean isPalindrom(String s, int i , int j){
		
		while(i < j){
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	private static int minPalPartion(String s, int i, int j){
		
		if(i >=j || isPalindrom(s, i, j) == true)
			return 0;
		
		if(memo[i][j] != -1)
			return memo[i][j];
		
		int minans = Integer.MAX_VALUE;
		for(int k = i; k<j; k++){
			
			int left = 0;
            int right = 0;
            
            if(memo[i][k] != -1){
                left = memo[i][k]; 
            }else{
            	left = minPalPartion(s,i,k);
            }
            
            if(memo[k+1][j] != -1){
                
                right = memo[k+1][j];
                
            }else{
            	right = minPalPartion(s,k+1,j);
            }
            int temp = (1+left+right);
            minans = Math.min(minans,temp);
		}
		return memo[i][j] = minans;
	}
	
	public static void main(String[] args){
		
		String str = "nitik";
		int n = str.length()-1;
		memo =  new int[n+1][n+1];
		for(int[] row : memo)
			Arrays.fill(row, -1);
		
		int ans  = minPalPartion(str,0,str.length()-1);
		System.out.println(ans);
	}
}
