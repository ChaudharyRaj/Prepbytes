package Daynamic_Programming;
import java.io.*;
import java.util.*;
public class ChocolateDilemma {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().trim().split("\\s");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		int arr[][] = new int[n][m];
		for(int i=0;i<n;i++){
            String[] s1 = br.readLine().trim().split(" ");
            //while(s.length<m){s=br.readLine().trim().split(" ");}
            //String s[] = ss.split(" ");
            for(int j=0;j<m;j++){
               arr[i][j] = Integer.parseInt(s1[j]);
            }
        }
		
		int a[][] = new int[n][3];
		
		for(int i = 0; i<n; i++){
			for(int k = 0; k<3; k++){
				int curr = Integer.MIN_VALUE;
				for(int j = k*(m/3); j<((k+1)*(m/3)); j++){
					a[i][k] = Math.max(curr,arr[i][j]);
					curr = a[i][k];
				}
			}
		}
		
		
		int[][] dp = new int[n][3];
		
		dp[0][0] = a[0][0];
		dp[0][1] = a[0][1];
		dp[0][2] = a[0][2];
		
		for(int i =1; i<n; i++){
			for(int j = 0; j<3; j++){
				
				if(j == 0){
					dp[i][j] = a[i][0]+Math.max(dp[i-1][1],dp[i-1][2]);
				}
				if(j == 1){
					dp[i][j] = a[i][1]+Math.max(dp[i-1][0],dp[i-1][2]);
				}
				if(j == 2){
					dp[i][j] = a[i][2]+Math.max(dp[i-1][1],dp[i-1][0]);
				}
			}
		}
		int ans = Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
		System.out.println(ans);
	}

}
