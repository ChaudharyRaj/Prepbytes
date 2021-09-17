package Daynamic_Programming;

public class SubsetSum {
	static int[][] memo;
	private static int isSubsetRecurr(int[] set, int sum, int n){
		
		if(sum == 0)
			return 1;
		if(n == 0)
			return 0;
		
		if(memo[n-1][sum] != -1){
			return memo[n-1][sum];
		}
		
		if(set[n-1] > sum)
			return  memo[n-1][sum] = isSubsetRecurr(set, sum, n-1);
		else
			return  memo[n-1][sum] = Math.max(isSubsetRecurr(set, sum, n-1),
					isSubsetRecurr(set, sum-set[n-1], n-1));	
	}
	static boolean isSubsetTabul(int[] set,int sum, int n){
		
		
		boolean[][] dp = new boolean[n+1][sum+1];
		
	      for(int i =0; i<n+1; i++){
	    	  for(int j =0; j<sum+1; j++){
	    		  if(i ==0)
	    			  dp[i][j] = false;
	    		  else if(j == 0)
	    			  dp[i][j] = true;
	    	  }
	      }
	      
	      for(int i =1; i<n+1; i++){
	    	  for(int j = 1; j<sum+1; j++){
	    		  
	    		  if(set[i-1] > j)
	    			  dp[i][j] = dp[i-1][j];
	    		  else if(set[i-1] <= sum)
	    			  dp[i][j] = dp[i-1][j-set[i-1]] || dp[i-1][j];
	    		  
	    	  }
	      }
	      return dp[n][sum];
	}
	
	public static void main(String[] args){
		
		  int set[] = { 3, 34, 4, 12, 5, 2 };
	      int sum = 9;
	      int n =  set.length;
	      memo = new int[n+1][sum+1];
	      for(int i= 0; i<n+1; i++){
	    	  for(int j = 0; j<sum+1; j++){
	    		  memo[i][j] = -1;
	    	  }
	      }
	      if(isSubsetRecurr(set,sum,n) == 1){
	    	  System.out.println("Yes");
	      }else{
	    	  System.out.println("No");
	      }
	      
//	      if(isSubsetTabul(set,sum,n) == true){
//	    	  System.out.println("Yes");
//	      }else{
//	    	  System.out.println("No");
//	      }
	      
	}
}
