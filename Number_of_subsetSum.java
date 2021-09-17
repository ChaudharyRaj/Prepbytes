package Daynamic_Programming;

public class Number_of_subsetSum {
	
	static int[][] memo;
	
	private static int coutSubsetSum(int[] arr, int sum, int n) {
		
		if(sum == 0)
			return 1;
		if(n == 0)
			return 0;
		if(memo[n-1][sum] != -1)
			return memo[n-1][sum];
		
		if(arr[n-1] <= sum){
			return memo[n][sum] = coutSubsetSum(arr, sum-arr[n-1], n-1)+coutSubsetSum(arr, sum, n-1);
		}else{
			return  memo[n][sum] = coutSubsetSum(arr,sum,n-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,1,2,3};
		int diff = 1;
		int sum = 0;
		for(int i = 0; i<arr.length; i++){
			sum += arr[i];
		}
		sum = (diff+sum)/2;
		
		memo = new int[arr.length+1][sum+1];
		for(int i = 0; i<arr.length+1; i++){
			for(int j =0; j<sum+1; j++)
				memo[i][j] =-1;
		}
		int res = coutSubsetSum(arr,sum,arr.length);
		System.out.println(res);
	}

	

}
