package Daynamic_Programming;
/*Author : RKCH*/
public class KnapsackProblem {
	
	//Memoization technique
	static int memo[][];
	private static int kanpsack(int[] wt, int[] val, int w, int n){
		
		if(n == 0 || w== 0){
			return 0;
		}
		
		if(memo[n-1][w] != -1){
			return memo[n-1][w]; 
		}
		
		if(wt[n-1] <= w){
			return memo[n][w] =  Math.max(val[n-1]+kanpsack(wt, val, w-wt[n-1], n-1),
							kanpsack(wt, val, w, n-1));
		}else{
			return memo[n][w] = kanpsack(wt, val, w, n-1);
		}
	} 
	public static void main(String[] args) {
		
		int val[] = {1,2,3};
		int wt[] = {4,5,1}; 
		int w = 4;
		int n = 3;
//		memo =  new int[n+1][w+1];
//		for(int i = 0; i<n+1; i++){
//			for(int j =0; j<w+1; j++){
//				memo[i][j] = -1;
//			}
//		}
//		int res = kanpsack(wt,val,w,n);
//		System.out.println(res);
		
		
		//Top-Down Approach
		int[][] dp = new int[n+1][w+1];
		for(int i = 0; i<n+1; i++)
			for(int j =0; j<w+1; j++)
				if(i == 0 || j == 0)
					dp[i][j] =0;
		
		for(int i =1; i<n+1; i++){
			for(int j = 1; j<w+1; j++){
				
				if(wt[i-1] <= j){
					dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];
				}			
			}
		}
		System.out.println(dp[n][w]);
		
	}
}
