package samsung.practice1;

import java.util.Scanner;

public class P14500 {
	static int n;
	static int m;
	static int[][] map = new int[500][500];
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		
		//�� ����
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				map[i][j] = in.nextInt();
			}
		}
		
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				count1(i,j);
				count2(i,j);
				count3(i,j);
				count4(i,j);
				count5(i,j);
				count6(i,j);
				count7(i,j);
				count8(i,j);
				count9(i,j);
				count10(i,j);
				count11(i,j);
				count12(i,j);
				count13(i,j);
				count14(i,j);
				count15(i,j);
				count16(i,j);
				count17(i,j);
				count18(i,j);
				count19(i,j);
			}
		}
		System.out.println(max);
	}
	//��������
	public static void count1(int i,int j){
		int count = 0;
		if(j + 3 < m){
			count = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
		}
		max = Math.max(max, count);
	}
	//��
	//��
	//��
	//��
	public static void count2(int i,int j){
		int count = 0;
		if(i + 3 < n){
			count = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
		}
		max = Math.max(max, count);
	}
	//����
	//����
	public static void count3(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 1 < m){
			count = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1];
		}
		max = Math.max(max, count);
	}
	//��
	//��
	//����
	public static void count4(int i,int j){
		int count = 0;
		if(i + 2 < n && j + 1 < m){
			count = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
		}
		max = Math.max(max, count);
	}
	//  ��
	//  ��
	//����
	public static void count5(int i,int j){
		int count = 0;
		if(i + 2 < n && j + 1 < m){
			count = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j] + map[i + 2][j + 1];
		}
		max = Math.max(max, count);
	}
	//������
	//��
	public static void count6(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 2 < m){
			count = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j];
		}
		max = Math.max(max, count);
	}
	//������
	//   ��
	public static void count7(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 2 < m){
			count = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
		}
		max = Math.max(max, count);
	}      
	//����
	//  ��
	//  ��
	public static void count8(int i,int j){
		int count = 0;
		if(j + 1 < m && i + 2 < n){
			count = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
		}
		max = Math.max(max, count);
	}
	//����
	//��
	//��
	public static void count9(int i,int j){
		int count = 0;
		if(j + 1 < m && i + 2 < n){
			count = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
		}
		max = Math.max(max, count);
	}
	//   ��
	//������
	public static void count10(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 2 < m){
			count = map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
		}
		max = Math.max(max, count);
	}
	//��
	//������
	public static void count11(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 2 < m){
			count = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
		}
		max = Math.max(max, count);
	}
	//��
	//����
	//  ��
	public static void count12(int i,int j){
		int count = 0;
		if(j + 1 < m && i + 2 < n){
			count = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
		}
		max = Math.max(max, count);
	}
	//  ��
	//����
	//��
	public static void count13(int i,int j){
		int count = 0;
		if(j + 1 < m && i + 2 < n){
			count = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
		}
		max = Math.max(max, count);
	}
	//  ����
	//����
	public static void count14(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 2 < m){
			count = map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1];
		}
		max = Math.max(max, count);
	}
	//����
	//  ����
	public static void count15(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 2 < m){
			count = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
		}
		max = Math.max(max, count);
	} 
	//������
	// ��
	public static void count16(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 2 < m){
			count = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
		}
		max = Math.max(max, count);
	} 
	// ��
	//������
	public static void count17(int i,int j){
		int count = 0;
		if(i + 1 < n && j + 2 < m){
			count = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
		}
		max = Math.max(max, count);
	}   
	//  ��
	//����
	//  ��
	public static void count18(int i,int j){
		int count = 0;
		if(j + 1 < m && i + 2 < n){
			count = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
		}
		max = Math.max(max, count);
	}   
	//��
	//����
	//��
	public static void count19(int i,int j){
		int count = 0;
		if(j + 1 < m && i + 2 < n){
			count = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
		}
		max = Math.max(max, count);
	}   
}