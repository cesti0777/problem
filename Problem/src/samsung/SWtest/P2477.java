package samsung.SWtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2477 {
	static int testCnt;
	static int n;// 접수 창구 개수
	static int m;// 정비 창구 개수
	static int k;// 방문 고객 수
	static int a;// 타겟의 접수 창구 번호
	static int b;// 타겟의 정비 창구 번호
	static int[] aT;// 접수창구 시간
	static int[] bT;// 정비창구 시간
	static int[] kT;// 도착 고객 시간
	static int[][] visited;
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		testCnt = in.nextInt();

		for (int testCase = 1; testCase <= testCnt; testCase++) {

			init();

			n = in.nextInt();
			m = in.nextInt();
			k = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();

			for (int i = 1; i <= n; i++) {
				aT[i] = in.nextInt();
			}
			for (int i = 1; i <= m; i++) {
				bT[i] = in.nextInt();
			}
			for (int i = 1; i <= k; i++) {
				kT[i] = in.nextInt();
			}

			execute();
			
			for(int i = 1; i <= k; i++){
				if(visited[i][0] == a && visited[i][1] == b){
					answer += i;
				}
			}
			
			if(answer == 0){
				answer = -1;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void init() {
		answer = 0;
		n = m = k = a = b = 0;
		aT = bT = kT = null;
		aT = new int[10];
		bT = new int[10];
		kT = new int[1001];
		visited = null;
		visited = new int[1001][2];
	}

	public static void execute(){
		int[] aState = new int[n + 1];
		Queue<Integer> aWaitQ = new LinkedList<Integer>();
		int[] bState = new int[m + 1];
		Queue<Integer> bWaitQ = new LinkedList<Integer>();
		
		int[] curAT = new int[n + 1];// 원래 접수창구 시간
		int[] curBT = new int[m + 1];// 원래 정비창구 시간
		
		//원래 시간 저장
		for(int i = 1; i <= n; i++){
			curAT[i] = aT[i];
		}
		for(int i = 1; i <= m; i++){
			curBT[i] = bT[i];
		}
		
		//첫 고객 찾기
		int kTIdx = 1;
		while(kT[1] != 0){
			for(int i = 1; i <= k; i++){
				kT[i]--;
			}
		}
		
		//첫 고객 푸시
		for(int i = 1; i <= k; i++){
			if(kT[i] == 0){
				aWaitQ.add(i);
			}else{
				kTIdx = i;
				break;
			}
		}
		
		// 매 초 실행
		while (true) {
			// 접수, 정비 창구 모두 고객이 없으면 종료
			boolean isExsist = false; 
			for(int i = 1; i <= n; i++){
				if(aState[i] == 0){
					continue;
				}else{
					isExsist = true;
					break;
				}
			}
			if(isExsist != true){
				for(int i = 1; i <= m; i++){
					if(bState[i] == 0){
						continue;
					}else{
						isExsist = true;
						break;
					}
				}
			}
			if(isExsist != true && aWaitQ.isEmpty() && bWaitQ.isEmpty()){// 고객이 없으면 종료
				for(int i = 1; i <= k; i++){
					if(kT[i] != 0){//아직 도착안한 손님 존재
						break;
					}
				}
				return;
			}
			
			// 창구 처리 완료 작업
			for(int i = 1; i <= n; i++){
				if(curAT[i] == 0){
					bWaitQ.add(aState[i]);
					aState[i] = 0;
					curAT[i] = aT[i];
				}
			}
			for(int i = 1; i <= m; i++){
				if(curBT[i] == 0){
					bState[i] = 0;
					curBT[i] = bT[i];
				}
			}
			
			// 고객이 존재			
			// 접수 창구 처리
			// 접수 창구 대기 손님 처리
			int aIsFull = 0; // 0이면 full
			while (!aWaitQ.isEmpty()) {// 접수창구 대기손님 있으면
				// 접수창구 빈자리 확인
				for (int i = 1; i <= n; i++) {
					if (aState[i] == 0) {// 빈자리 있으면
						aIsFull = i;
						break;
					}
				}
				if (aIsFull != 0) {// 빈자리 있으면
					aState[aIsFull] = aWaitQ.remove();
					visited[aState[aIsFull]][0] = aIsFull;
					aIsFull = 0;
				} else {// 빈자리 없으면
					break;
				}
			}

			// 정비 창구 대기 손님 처리
			int bIsFull = 0;
			while (!bWaitQ.isEmpty()) {// 정비 창구 대기손님 있으면
				// 정비 창구 빈자리 확인
				for (int i = 1; i <= m; i++) {
					if (bState[i] == 0) {// 빈자리 있으면
						bIsFull = i;
						break;
					}
				}
				if (bIsFull != 0) {// 빈자리 있으면
					bState[bIsFull] = bWaitQ.remove();
					visited[bState[bIsFull]][1] = bIsFull;
					bIsFull = 0;
				} else {// 빈자리 없으면
					break;
				}
			}

			//도착 고객 푸시
			if(kTIdx <= k){
				for(int i = kTIdx; i <= k; i++){
					kT[i]--;
				}
				
				for(int i = kTIdx; i <= k; i++){
					if(kT[i] == 0){
						aWaitQ.add(i);
					}else{
						kTIdx = i;
						break;
					}
				}
			}
			
			//시간 경과
			for(int i = 1; i <= n; i++){
				if(aState[i] != 0){
					if(curAT[i] != 0){
						curAT[i]--;
					}
				}
			}
			for(int i = 1; i <= m; i++){
				if(bState[i] != 0){
					if(curBT[i] != 0){
						curBT[i]--;
					}
				}
			}
		}
	}
}
