package line;

public class Solution {

	public static void main(String[] args) {
		System.out.println(func(6));
	}
	
	public static int func(int n){
		if (n <= 2){
			return 1;
		}
		return func(n-1) + 2 * func(n-2);
		
	}

}
