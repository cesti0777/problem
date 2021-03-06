package samsung.review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14502 {
	static int answer;
	static int testCnt;
	static int n;
	static int m;
	static int[][] map;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		testCnt = in.nextInt();
		
		for(int testCase = 1; testCase <= testCnt; testCase++){
			init();
			
			n = in.nextInt();
			m = in.nextInt();
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					map[i][j] = in.nextInt();
				}
			}
			
//			printMap();
			
			execute();
			
			System.out.println("#" + testCase + " " + answer);
		}
		
	}
	
	public static void init(){
		answer = n = m = 0;
		map = null;
		map = new int[8][8];
	}
	
	public static void execute(){
		//맵을 1차원으로 저장
		int[] platMap = new int[n * m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				platMap[m * i + j] = map[i][j];
			}
		}
		
		int[][] cloneMap = null;
		
		for(int i = 0; i < n * m - 2; i++){//벽1 뽑기
			for(int j = i + 1; j < n * m - 1; j++){//벽2 뽑기
				for(int k = j + 1; k < n * m; k++){//벽3 뽑기
					//벽 세우기
					if(platMap[i] == 0 && platMap[j] == 0 && platMap[k] == 0){
						cloneMap = cloneMap(map);
						cloneMap[i/m][i%m] = 1;
						cloneMap[j/m][j%m] = 1;
						cloneMap[k/m][k%m] = 1;
						
						//바이러스 전파
						for(int a = 0; a < n; a++){
							for(int b = 0; b < m; b++){
								if(cloneMap[a][b] == 2){
									infection(cloneMap, a, b);
								}
							}
						}
						
						//안전지역 카운트
						int cnt = 0;
						for(int a = 0; a < n; a++){
							for(int b = 0; b < m; b++){
								if(cloneMap[a][b] == 0){
									cnt++;
								}
							}
						}
						
						//최대 안전지역 갱신
						answer = Math.max(answer, cnt);
					}
				}
			}
		}
	}
	
	public static void infection(int[][] cloneMap, int a, int b){
		boolean[][] visited = new boolean[n][m];

		Queue<Integer> q = new LinkedList<Integer>();
		visited[a][b] = true;
		q.add(a);
		q.add(b);
		
		int r = 0;
		int c = 0;
		while(!q.isEmpty()){
			r = q.remove();
			c = q.remove();
			
			//상
			if(r - 1 >= 0 && cloneMap[r - 1][c] == 0){
				cloneMap[r - 1][c] = 2;
				visited[r - 1][c] = true;
				q.add(r - 1);
				q.add(c);
			}
			//하
			if(r + 1 < n && cloneMap[r + 1][c] == 0){
				cloneMap[r + 1][c] = 2;
				visited[r + 1][c] = true;
				q.add(r + 1);
				q.add(c);
			}
			//좌
			if(c - 1 >= 0 && cloneMap[r][c - 1] == 0){
				cloneMap[r][c - 1] = 2;
				visited[r][c - 1] = true;
				q.add(r);
				q.add(c - 1);
			}
			//우
			if(c + 1 < m && cloneMap[r][c + 1] == 0){
				cloneMap[r][c + 1] = 2;
				visited[r][c + 1] = true;
				q.add(r);
				q.add(c + 1);
			}
		}
	}
	
	public static int[][] cloneMap(int[][] arr){
		int[][] cloneMap = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cloneMap[i][j] = arr[i][j];
			}
		}
		return cloneMap;
	}
	
	public static void printMap(){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

//3
//7 7
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 1 1
//0 1 0 0 0 0 0
//0 1 0 0 0 0 0
//4 6
//0 0 0 0 0 0
//1 0 0 0 0 2
//1 1 1 0 0 2
//0 0 0 0 0 2
//8 8
//2 0 0 0 0 0 0 2
//2 0 0 0 0 0 0 2
//2 0 0 0 0 0 0 2
//2 0 0 0 0 0 0 2
//2 0 0 0 0 0 0 2
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0

