package Daynamic_Programming;

public class Print_shortest_common_supersequence {
	
	static int[][] dp;
	private static void LCS(String x,String y,int n, int m){
		
		for(int i = 0; i<n+1; i++){
			for(int j = 0; j<m+1; j++){
				if( i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}
		
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j <m+1; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = (1+dp[i-1][j-1]);
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
	}
	
	private static String PrintSCS(String x, String y){
		
		int n = x.length();
		int m = y.length();
		dp =  new int[n+1][m+1];
		LCS(x,y,n,m);
		
		StringBuffer sb =  new StringBuffer();
		int i = n;
		int j = m;
		
		while(i > 0 && j > 0){
			
			if(x.charAt(i-1) == y.charAt(j-1)){
				sb.append(x.charAt(i-1));
				i--;
				j--;
			}else{
				
				if(dp[i-1][j] > dp[i][j-1]){
					sb.append(x.charAt(i-1));
					i--;
				}else{
					sb.append(y.charAt(j-1));
					j--;
				}
			}
		}
		
		while(i  > 0){sb.append(x.charAt(i-1)); i--;}
		while(j  > 0){sb.append(y.charAt(j-1)); j--;}
		
		return sb.reverse().toString();
	}
	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		String s1 = "GEEK";
        String s2 = "HELLO";
        String ans =  PrintSCS(s1,s2);
        System.out.println(ans);
	}
}
