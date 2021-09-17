package Daynamic_Programming;
import java.util.*;
public class ScrambledString {
	static Map<String,Boolean> map =  new HashMap<>();
	static boolean solve(String a, String b){
		
		if(a.compareTo(b) == 0)
			return true;
		
		int n = a.length();
		boolean flag = false;
		
		String key = a+" "+b;
		
		if(map.containsKey(key))
			return map.get(key);
		
		for(int i = 1; i<n; i++){
			if((solve(a.substring(0,i),b.substring(n-i,n))
				&&
				solve(a.substring(i,n),b.substring(0,n-i)))
				||
				(solve(a.substring(0,i),b.substring(0,i))
				&&
				solve(a.substring(i,n),b.substring(i,n)))){
				flag = true;
				break;
			}
		}
		
		map.put(key,flag);
		return flag;
	}
	static boolean isScrambled(String s1, String  s2){
		
		map.clear();
		
		if(s1.length() != s2.length())
			return false;
		if(s1.compareTo(s2) == 0)
			return true;
		
		return solve(s1,s2); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "great";
		String s2 = "rgeat";
		boolean  res = isScrambled(s1,s2);
		System.out.println(res ? "Yes":"No");  
	}

}
