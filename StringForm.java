package Daynamic_Programming;
import java.util.*;
public class StringForm {
	
	static Map<String ,Integer> hm = new HashMap<String, Integer>();
	
	private static boolean solve(String s){
		
		if(hm.get(s) != null){
			if(hm.get(s) == 1)
				return true;
		}
		String w = "";
		int f1 = 2;
		for(int i = 0; i<s.length(); i++){
			w+= s.charAt(i);
			if(hm.get(w) != null && solve(s.substring(i+1))){
				hm.put(s,1);
				return true;
			}
		}
		hm.put(s,2);
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =  new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			String string  = in.next();
			int n = in.nextInt();
			for(int i =0; i<n; i++){
				String str = in.next();
				hm.put(str,1);
			}
			boolean res = solve(string);
			System.out.println(res ? "YES" : "NO");
		}
	}
}
