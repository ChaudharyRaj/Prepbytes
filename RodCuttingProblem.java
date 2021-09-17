package Daynamic_Programming;
import java.util.*;
public class RodCuttingProblem{
	static int[][] memo;
	
	private static int memoMaxProfit(int[] price, int[] length, int size, int n){
		
		if(size == 0 ||n == 0)
			return 0;
		
		if(memo[n-1][size] != -1) 
			return memo[n-1][size];
		
		if(length[n-1] <= size){
			return memo[n][size] = Math.max(price[n-1]+memoMaxProfit(price, length, size-length[n-1], n-1),
					memoMaxProfit(price, length, size, n-1));
		}else{
			return memo[n][size] = memoMaxProfit(price, length, size, n-1);
		}
	}
	
	public static void main(String[] args){
		
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		int n = arr.length;
		int size = arr.length;
		int length[] =  new int[size];
		memo = new int[n+1][size+1];
		int x = 1;
		for(int i = 0; i<size; i++)
			length[i] = x++;
		
//		for(int item : length)
//			System.out.print(item+" ");
		
		for(int i = 0; i<n+1; i++)
			for(int j = 0; j<size+1; j++)
				memo[i][j] = -1;
		
		int res = memoMaxProfit(arr, length, size,n);
		System.out.println(res);
	}
}
