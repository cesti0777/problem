package samsung.review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14503 {
	static int testCnt;
	static int answer;
	static int n;
	static int m;
	static int r;
	static int c;
	static int d;
	static int[][] map;
	static boolean[][] visited;
	
	final static int N = 0;
	final static int E = 1;
	final static int S = 2;
	final static int W = 3;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		testCnt = in.nextInt();
		
		for(int testCase = 1; testCase <= testCnt; testCase++){
			
			init();
			
			n = in.nextInt();
			m = in.nextInt();
			r = in.nextInt();
			c = in.nextInt();
			d = in.nextInt();
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					map[i][j] = in.nextInt();
				}
			}
				
			execute();
			
			System.out.println("#" + testCase + " " + answer);
			
		}
	}
	
	public static void init(){
		answer = n = m = r = c = d = 0;
		map = null;
		map = new int[50][50];
		visited = null;
		visited = new boolean[50][50];
	}
	
	public static void execute(){
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		visited[r][c] = true; // �ʱ� ��ġ û��
		q.add(r);
		q.add(c);
		q.add(d);
		q.add(1);
		
		int curR = 0;
		int curC = 0;
		int curD = 0;
		int no = 0;
		while(!q.isEmpty()){
			curR = q.remove();
			curC = q.remove();
			curD = q.remove();
			answer = q.remove();
			
			if(no != 4){//4���� ���� x
				switch (curD) {
				case N://���� �ٶ󺸴� ��
					if(map[curR][curC - 1] == 0 && !visited[curR][curC - 1]){//������ ��ĭ and û��x
						curD = W;//�������� ȸ��
						curC--;//�� ĭ ����
						visited[curR][curC] = true;
						no = 0;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer + 1);
						break;
					}else{//���� �� or û��o
						curD = W;//�������� ȸ��
						no++;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer);
						break;
					}
				case E://���� �ٶ󺸴� ��
					if(map[curR - 1][curC] == 0 && !visited[curR - 1][curC]){//������ ��ĭ and û��x
						curD = N;//�������� ȸ��
						curR--;//�� ĭ ����
						visited[curR][curC] = true;
						no = 0;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer + 1);
						break;
					}else{//���� �� or û��o
						curD = N;//�������� ȸ��
						no++;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer);
						break;
					}
				case S://���� �ٶ󺸴� ��
					if(map[curR][curC + 1] == 0 && !visited[curR][curC + 1]){//������ ��ĭ and û��x
						curD = E;//�������� ȸ��
						curC++;//�� ĭ ����
						visited[curR][curC] = true;
						no = 0;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer + 1);
						break;
					}else{//���� �� or û��o
						curD = E;//�������� ȸ��
						no++;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer);
						break;
					}
				case W://���� �ٶ󺸴� ��
					if(map[curR + 1][curC] == 0 && !visited[curR + 1][curC]){//������ ��ĭ and û��x
						curD = S;//�������� ȸ��
						curR++;//�� ĭ ����
						visited[curR][curC] = true;
						no = 0;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer + 1);
						break;
					}else{//���� �� or û��o
						curD = S;//�������� ȸ��
						no++;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer);
						break;
					}
				}
			}else{//4���� ����o
				switch (curD) {
				case N://���� �ٶ󺸴� ��
					if(map[curR + 1][curC] == 0){//�ڰ� ���� �ƴϸ�
						curR++;//�� ĭ ����
						no = 0;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer);
						break;
					}else{//�ڰ� ���̸�
						return;
					}
				case E://���� �ٶ󺸴� ��
					if(map[curR][curC - 1] == 0){//�ڰ� ���� �ƴϸ�
						curC--;//�� ĭ ����
						no = 0;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer);
						break;
					}else{//�ڰ� ���̸�
						return;
					}
				case S://���� �ٶ󺸴� ��
					if(map[curR - 1][curC] == 0){//�ڰ� ���� �ƴϸ�
						curR--;//�� ĭ ����
						no = 0;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer);
						break;
					}else{//�ڰ� ���̸�
						return;
					}
				case W://���� �ٶ󺸴� ��
					if(map[curR][curC + 1] == 0){//�ڰ� ���� �ƴϸ�
						curC++;//�� ĭ ����
						no = 0;
						q.add(curR);
						q.add(curC);
						q.add(curD);
						q.add(answer);
						break;
					}else{//�ڰ� ���̸�
						return;
					}
				}
			}
		}//end while
	}
	
	public static void print(boolean[][] arr){
		System.out.println();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
}

//2
//3 3
//1 1 0
//1 1 1
//1 0 1
//1 1 1
//11 10
//7 4 0
//1 1 1 1 1 1 1 1 1 1
//1 0 0 0 0 0 0 0 0 1
//1 0 0 0 1 1 1 1 0 1
//1 0 0 1 1 0 0 0 0 1
//1 0 1 1 0 0 0 0 0 1
//1 0 0 0 0 0 0 0 0 1
//1 0 0 0 0 0 0 1 0 1
//1 0 0 0 0 0 1 1 0 1
//1 0 0 0 0 0 1 1 0 1
//1 0 0 0 0 0 0 0 0 1
//1 1 1 1 1 1 1 1 1 1