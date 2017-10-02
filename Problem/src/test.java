import java.util.Scanner;

public class test {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] line = in.nextLine().split(" ");
		int[] num = new int[line.length];
		int[] sortedNum = new int[line.length];
		for(int i = 0; i < line.length; i++){
			num[i] = Integer.parseInt(line[i]);
		}
		for(int i = 0; i < num.length; i++){
			int max = 0;
			if(num[i]/10 < 1){ // 한자리면
				for(int j = i+1; j < num.length; j++){
					if(num[j]/10 < 1){// 한자리면
						if(num[i] > num[j]){
							max = num[i];
						}else{
							max = num[j];
						}
					}else{// 두자리면
						if(num[i] > num[j]/10){
							max = num[i];
						}else{
							max = num[j];
						}
					}
				}
				sortedNum[i] = max;
			}else{// 두자리면
				for(int j = i+1; j < num.length; j++){
					if(num[j]/10 < 1){// 한자리면
						if(num[i]/10 > num[j]){
							max = num[i];
						}else{
							max = num[j];
						}
						
					}else{// 두자리면
						if(num[i]/10 > num[j]/10){
							max = num[i];
						}else{
							max = num[j];
						}
					}
				}
				sortedNum[i] = max;
			}
			
			System.out.println(sortedNum[i]);
		}
		
		
	}
	
}

//1. 숫자 이어 붙이기
//
//여러 개의 자연수를 표준 입력(standard input)에서 읽은 후, 그 수들을 이어 붙여서 만들 수 있는 가장 큰 수와 가장 작은 수의 합을 구하세요.
//
//
//
//[입력]
//
//주어지는 입력은 10개 이하이며, 각각의 숫자는 2자리 이하의 자연수입니다.
//숫자는 공백으로 구분됩니다.
//두 번째 예시에 대해 주의 깊게 살펴보시기 바랍니다.
// 
//[출력]
//올바른 출력은 하나의 문장이어야 하며, 문장의 마지막은 불필요한 공백 없이 개행 문자(newline, \n)로 끝나야 합니다. 
// 
//
//[예시 설명 (1)]
//
//입력이 1 2 3일 경우, 만들 수 있는 가장 큰 수는 321이고 가장 작은 수는 123이며 두 수의 합은 444이다. 
//따라서 결과는 다음과 같다.
//444
// 
//
//[예시 설명 (2)] 
//
//입력이 2 9 10 21 24일 경우, 
//만들 수 있는 가장 큰 수는 92422110이고, 가장 작은 수는 10212249이며 두 수의 합은 102634359
//따라서 결과는 다음과 같다. 
//102634359