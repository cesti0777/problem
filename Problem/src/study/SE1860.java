package study;

import java.util.Arrays;
import java.util.Scanner;

public class SE1860 {

	static int testCaseCnt;//testcase 개수
	static int n, m ,k;//사람 수, 붕어빵 생성 주기, 붕어빵 생성량
	static int[] people;
	static String answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			init();//변수 초기화
			
			n = in.nextInt();//사람 수 입력
			m = in.nextInt();//붕어빵 생성 주기 입력
			k = in.nextInt();//붕어빵 생성량 입력
			
			people = new int[n];//사람 도착 시간
			
			for(int i = 0; i < n; i++){//사람 도착 시간 입력
				people[i] = in.nextInt();
			}
			
			Arrays.sort(people);//사람 도착 시간 오름차순 정렬
			
			execute();//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void init() {
		people = null;
	}

	public static void execute() {
		int mSum = m;//첫번째 붕어생성 주기 초기화
		int peopleIdx = 0;//첫번째 사람으로 초기화
		int curSec = 0;//현재 시간(초)
		int fishSum = 0;//생성된 붕어빵 수
		while(peopleIdx != n){//가장 늦게 도착하는 사람 초까지 초증가
			
			//사람 도착시간 중복
			if(curSec > people[peopleIdx]){//초는 증가했지만 도착시간은 증가하지 않았을 경우
				if(fishSum > 0){//지급할 붕어빵이 있으면
					fishSum--;//붕어빵 지급
					peopleIdx++;//다음 도착할 사람으로 인덱스 조정
					curSec--;//해당 초를 그대로 유지하게 조정
				}else{//지급할 붕어빵이 없으면
					answer = "Impossible";
					return;
				}
				continue;//붕어빵을 생성하면 안되므로 다음 반복문으로 넘어감
			}
			
			//붕어빵 생성
			if(curSec == mSum){//현재 시간이 붕어 생성 주기가 되면
				fishSum += k;//생성된 붕어빵 누적
				mSum += m;//다음 주기로 갱신
			}
			
			//붕어빵 지급
			if(curSec == people[peopleIdx]){//사람 도착시간이 되면 
				if(fishSum > 0){//지급할 붕어빵이 있으면
					fishSum--;//붕어빵 지급
					peopleIdx++;//다음 도착할 사람으로 인덱스 조정
				}else{//지급할 붕어빵이 없으면
					answer = "Impossible";
					return;
				}
			}
			curSec++;//초증가
		}
		answer = "Possible";//모든 사람 붕어빵 지급하면 도달
	}
}
