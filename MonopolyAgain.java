package Daynamic_Programming;
import java.util.*;
public class MonopolyAgain {
	 static long [] arr = new long[101];
	 static long[][][] dp = new long[101][101][101];
	 
	private static long solve(int turn, int index, int m, int n){
		
		if(index == n)
			return 0;
		
		long val1 = Long.MIN_VALUE;
		long val2 = Long.MAX_VALUE;
		long tempsum = 0;
		
		if(dp[turn][index][m] != -1){
			return dp[turn][index][m];
		}
		for(int i = 1; i<=2*m && (index+i-1)<n; i++){
			
			tempsum = (tempsum+arr[index + i - 1]);
			
			if(turn%2 == 0){
				
				val1 = Math.max(val1,tempsum+solve(turn+1,index+i,Math.max(m,i),n));
				
			}else{
				
				val2 = Math.min(val2,solve(turn+1,i+index,Math.max(m,i),n));
			}
		}
		
		if(turn%2 == 0){
			return dp[turn][index][m] = val1;
		}else{
			return dp[turn][index][m] = val2;
		}
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i<n; i++){
			arr[i] = in.nextLong();
		}
		for(int i = 0; i<101; i++){
			for(int j = 0; j <101; j++){
				for(int k = 0; k < 101; k++){
					dp[i][j][k] = -1;
				}
			}
		}
		long res = solve(0,0,1,n);
		System.out.println(res);
	}

}
