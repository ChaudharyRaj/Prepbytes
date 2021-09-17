package Daynamic_Programming;
import java.util.*;
import java.io.*;
public class FoolishItems {
  
  static void maxProduct(int n){
    
    int[] val = new int[n+1];
    val[0] = val[1]= 0;
    
      for(int i = 1 ; i<=n; i++){
    	 int max_val = 0;
    	 for(int j =0; j<= i/2;j++){
    		 max_val = Math.max(max_val, Math.max(j * val[i - j], j * (i - j)));
    	 }
    	 val[i] = max_val;
      }
      System.out.println(val[n]);
  }
  
  public static void main(String args[]) throws IOException {
    
    //write your code here
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-->0){
      int n =  in.nextInt();
      maxProduct(n);
    }
  }
}
