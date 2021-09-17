package Daynamic_Programming;
import java.util.Arrays;

public class EggDroppingProblem{
	
	static int max(int a, int b){
		return a > b ? a : b;
	}
	static int[][] memo;
	
	static int solve(int e, int f){
		
		if(memo[e][f] != -1){
			return memo[e][f];
		}
		
		if(e == 0 || f == 0)
			return f;
		
		if(e == 1)
			return f;
		
		int min = Integer.MAX_VALUE;
		int temp = 0;
		
		for(int k = 1; k<=f; k++){
			
			temp  = max(solve(e-1,k-1),solve(e,f-k))+1;
			if(temp < min)
				min = temp;
		}
		
		return memo[e][f] = min;
	}
	
	public static void main(String[] args){
		
		int Floor = 4;
		int Egg = 2;
		memo = new int[Egg+1][Floor+1];
		for(int[] row : memo){
			Arrays.fill(row,-1);
		}
		int ans = solve(Egg,Floor);
		
		System.out.println(ans);
	}

}
