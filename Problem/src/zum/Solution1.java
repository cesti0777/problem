package zum;

public class Solution1 {

	public int solution(String A, String B){
		int answer = 0;
		int cardAlec = 0;
		int cardBob = 0;
		
		for(int i = 0; i < A.length(); i++){
			if(A.charAt(i) == 'A'){
				cardAlec = 14;
			}else if(A.charAt(i) == 'K'){
				cardAlec = 13;
			}else if(A.charAt(i) == 'Q'){
				cardAlec = 12;
			}else if(A.charAt(i) == 'J'){
				cardAlec = 11;
			}else if(A.charAt(i) == 'T'){
				cardAlec = 10;
			}else{
				cardAlec = Character.getNumericValue(A.charAt(i));
			}
			
			if(B.charAt(i) == 'A'){
				cardBob = 14;
			}else if(B.charAt(i) == 'K'){
				cardBob = 13;
			}else if(B.charAt(i) == 'Q'){
				cardBob = 12;
			}else if(B.charAt(i) == 'J'){
				cardBob = 11;
			}else if(B.charAt(i) == 'T'){
				cardBob = 10;
			}else{
				cardBob = Character.getNumericValue(B.charAt(i));
			}
			
			if(cardAlec > cardBob){
				answer++;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Solution1 o = new Solution1();
		System.out.println(o.solution("A586QK", "JJ653K"));
		System.out.println(o.solution("23A84Q", "K2Q25J"));
		

	}
}
