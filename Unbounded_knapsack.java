package Daynamic_Programming;

public class Unbounded_knapsack {
	private static int[][] memo;
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int w = 8;
		int val[] = {1, 4, 5, 7};
		int wt[] = {1, 3, 4, 5};
        int n = val.length;
//        memo =  new int[n+1][w+1];
//        for(int i = 0; i<n+1; i++){
//    	   for(int j = 0; j<w+1; j++){
//    		   memo[i][j] = -1;	
//    	   }
//        }
		//int res = solve(val,wt,w,n);
        
        int res = solveTablulation(val, wt, w, n);
        
		System.out.println(res);    
	}
	
	private static  int solveTablulation(int[] val, int[] wt, int w, int n){
		
		int dp[][] = new int[n+1][w+1];
		
		for(int i = 0; i<n+1; i++) dp[i][0] = 0;
		
		for(int i =0; i<w+1; i++) dp[0][i] = 0;
			
		
		for(int i = 1; i<n+1; i++){
			for(int j = 0; j<w+1; j++){
				if(wt[i-1] <= j){
					
					dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][w];
	} 
	
	private static int solve(int[] val, int[] wt, int w, int n){
		
		if( n == 0 || w == 0){
			return 0;
		}
		
		if(memo[n-1][w] != -1)
			return memo[n-1][w];
		
		if(wt[n-1]<= w){
			return memo[n][w] = Math.max(val[n-1]+solve(val, wt, w-wt[n-1], n),
					solve(val, wt, w, n-1));
		}else{
			return memo[n][w] = solve(val, wt, w, n-1);
		}
	}
} 
