package Daynamic_Programming;
import java.util.*;
public class Monopoly {
	static  int[][] memo;
	static int max = 100;
	private static int colleactMorecase(int[]  arr, int n){
		
		int sum = 0;
		for(int i : arr)
			sum += i;
		memo  =  new int[max+1][max+1];
		
		for(int i = 0; i<max+1;  i++){
			for(int j = 0; j<max; j++){
				memo[i][j] = -1;
			}
		}
		return maxSum(arr,0,n-1,sum);
	}
	private static int maxSum(int[] arr, int i, int j, int sum){
		
		if(j == i+1)
			return Math.max(arr[i],arr[j]);
		if(memo[i][j] != -1)
			return memo[i][j];
		return memo[i][j] =  Math.max((sum - maxSum(arr, i+1, j, sum - arr[i])),
				(sum - maxSum(arr, i, j-1, sum -arr[j])));
		
	}
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int[]  arr = new int[n]; 
			for(int i= 0; i<n; i++)
				arr[i] = in.nextInt();
			System.out.println(colleactMorecase(arr,n));
		}
		
	}

}
