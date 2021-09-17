package Daynamic_Programming;

public class CoinChange_MinimumCoin {

	static int solveTabulation(int[] coins, int sum,int n){
		
		int dp[][] = new int[n+1][sum+1];
		dp[0][0] = 0;
		
		for(int i = 0; i<sum+1; i++)
			dp[0][i] = Integer.MAX_VALUE-1;
		
		for(int i = 0; i<n+1; i++)
			dp[i][0] = 0;
		
		for(int i = 1; i<sum+1; i++)
			dp[1][i] = Integer.MAX_VALUE-1;
		
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j <sum+1; j++){
				if(coins[i-1] <= j){
					dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			} 
		} 
		
		return dp[n][sum] > sum ? -1 : dp[n][sum];
	}
	
	public static void main(String[] args){
		
		int coins[] = {25, 10, 5};
        int n = coins.length; 
        int sum = 30;
        int res = solveTabulation(coins, sum, n);
        System.out.println(res);
	}

}
