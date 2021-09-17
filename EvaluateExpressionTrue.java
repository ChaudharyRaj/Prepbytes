/*
 * 	Count the number of ways we can parenthesize the expression so that the
 *  value of expression evaluates to true. 
	Let the input be in form of two arrays one contains the symbols (T and F)
	in order and other contains operators (&, | and ^}
	*/
package Daynamic_Programming;
import java.util.*;
public class EvaluateExpressionTrue {
	
	static Map<String,Integer> map = new HashMap<String, Integer>();
	private static int solve(String s, int i, int j, int isTrue){
		
		if(i > j) return 0;
		
		if(i == j){
			if(isTrue == 1){
				return (s.charAt(i) == 'T') ? 1 : 0;
			}else{
				return (s.charAt(i) == 'F') ? 1 : 0;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(i)+" ");
		sb.append(String.valueOf(j)+" ");
		sb.append(String.valueOf(isTrue));
		String key = sb.toString();
		
		if(map.containsKey(key))
			return map.get(key);
		
		int LT = 0;
		int LF = 0;
		int RT = 0;
		int RF = 0;
		int tempans = 0;
		
		for(int  k  = i+1; k<=j-1; k+=2){
			
			LT = solve(s,i,k-1,1);
			LF = solve(s,k+1,j,0);
			RT = solve(s,i,k-1,1);
			RF = solve(s,k+1,j,0);
			
			if(s.charAt(k) == '&'){
				
				if(isTrue == 1){
					tempans += LT*RT;
				}else{
					tempans +=(LT*RF + LF*RT + LF*RF);
				}
			}
			
			if(s.charAt(k) == '|'){
				if(isTrue == 1){
					tempans += (LT*RT + LF*RT + LT*RF);
				}else{
					tempans += (LF+RF);
				}
			}
			
			if(s.charAt(k) == '^'){
				if(isTrue == 1){
					tempans += (LT*RF + LF*RT);
				}else{
					tempans += (LT*RT + LF+RF);
				}
			}
		}
		map.put(key, tempans);
		return tempans;
	}
	private static int coutWays(String s,int n){
		map.clear();
		int ans  = solve(s,0,n-1,1);
		return ans;
	}
	
	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		String symbols = "TTFT";
        String operators = "|&^";
        StringBuffer sb = new StringBuffer();
        int j = 0;
        
        for(int i = 0; i<symbols.length(); i++){
        	sb.append(symbols.charAt(i));
        	if(j<operators.length())
        		sb.append(operators.charAt(j++));
        }
     
        int ans = coutWays(sb.toString(),sb.toString().length()); 
        System.out.println(ans);
	}
}
