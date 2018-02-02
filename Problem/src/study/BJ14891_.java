package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14891_ {

	static int[] list1 = new int[8];
	static int[] list2 = new int[8];
	static int[] list3 = new int[8];
	static int[] list4 = new int[8];
	static int orderCnt;
	static Queue<Integer> orders = new LinkedList<Integer>();
	static int answer;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		for (int i = 0; i < 8; i++) {
			list1[i] = Integer.parseInt(line.charAt(i) + "");
		}
		line = in.nextLine();
		for (int i = 0; i < 8; i++) {
			list2[i] = Integer.parseInt(line.charAt(i) + "");
		}
		line = in.nextLine();
		for (int i = 0; i < 8; i++) {
			list3[i] = Integer.parseInt(line.charAt(i) + "");
		}
		line = in.nextLine();
		for (int i = 0; i < 8; i++) {
			list4[i] = Integer.parseInt(line.charAt(i) + "");
		}

		orderCnt = in.nextInt();

		for (int i = 0; i < orderCnt; i++) {
			orders.add(in.nextInt());
			orders.add(in.nextInt());
		}

		execute();// ½ÇÇà

	}

	public static void execute() {

		int tNum;
		int roDir;

		while (!orders.isEmpty()) {
			tNum = orders.remove();
			roDir = orders.remove();

			if(tNum == 1){
				if(list1[2] == list2[6]){//1~2Åé´Ï °°À¸¸é
					rotation(tNum, roDir);
				}else{//1~2Åé´Ï ´Ù¸£¸é
					rotation(tNum, roDir);
					if(list2[2] == list3[6]){//2~3Åé´Ï °°À¸¸é
						rotation(tNum + 1, -roDir);
					}else{//2~3Åé´Ï ´Ù¸£¸é
						rotation(tNum + 1, -roDir);
						if(list3[2] == list4[6]){//3~4Åé´Ï °°À¸¸é
							rotation(tNum + 2, roDir);
						}else{//3~4Åé´Ï ´Ù¸£¸é
							rotation(tNum + 2, roDir);
							rotation(tNum + 3, -roDir);
						}
					}
				}
			}else if(tNum == 2){
				if(list1[2] == list2[6]){//1~2Åé´Ï °°À¸¸é
					if(list2[2] == list3[6]){//2~3Åé´Ï °°À¸¸é
						rotation(tNum, roDir);
					}else{//2~3Åé´Ï ´Ù¸£¸é
						rotation(tNum, roDir);
						if(list3[2] == list4[6]){//3~4Åé´Ï °°À¸¸é
							rotation(tNum + 1, -roDir);
						}else{//3~4Åé´Ï ´Ù¸£¸é
							rotation(tNum + 1, -roDir);
							rotation(tNum + 2, roDir);
						}
					}
				}else{//1~2Åé´Ï ´Ù¸£¸é
					if(list2[2] == list3[6]){//2~3Åé´Ï °°À¸¸é
						rotation(tNum, roDir);
						rotation(tNum - 1, -roDir);
					}else{//2~3Åé´Ï ´Ù¸£¸é
						rotation(tNum, roDir);
						if(list3[2] == list4[6]){//3~4Åé´Ï °°À¸¸é
							rotation(tNum + 1, -roDir);
						}else{//3~4Åé´Ï ´Ù¸£¸é
							rotation(tNum + 1, -roDir);
							rotation(tNum + 2, roDir);
						}
					}
				}
			}else if(tNum == 3){
				if(list3[2] == list4[6]){//3~4Åé´Ï °°À¸¸é
					if(list2[2] == list3[6]){//2~3Åé´Ï °°À¸¸é
						rotation(tNum, roDir);
					}else{//2~3Åé´Ï ´Ù¸£¸é
						rotation(tNum, roDir);
						if(list1[2] == list2[6]){//1~2Åé´Ï °°À¸¸é
							rotation(tNum - 1, -roDir);
						}else{//1~2Åé´Ï ´Ù¸£¸é
							rotation(tNum - 1, -roDir);
							rotation(tNum - 2, roDir);
						}
					}
				}else{//3~4Åé´Ï ´Ù¸£¸é
					if(list2[2] == list3[6]){//2~3Åé´Ï °°À¸¸é
						rotation(tNum, roDir);
						rotation(tNum + 1, -roDir);
					}else{//2~3Åé´Ï ´Ù¸£¸é
						rotation(tNum, roDir);
						if(list1[2] == list2[6]){//1~2Åé´Ï °°À¸¸é
							rotation(tNum - 1, -roDir);
						}else{//1~2Åé´Ï ´Ù¸£¸é
							rotation(tNum - 1, -roDir);
							rotation(tNum - 2, roDir);
						}
					}
				}
			}else{
				if(list3[2] == list4[6]){//3~4Åé´Ï °°À¸¸é
					rotation(tNum, roDir);
				}else{//3~4Åé´Ï ´Ù¸£¸é
					rotation(tNum, roDir);
					if(list2[2] == list3[6]){//2~3Åé´Ï °°À¸¸é
						rotation(tNum - 1, -roDir);
					}else{//2~3Åé´Ï ´Ù¸£¸é
						rotation(tNum - 1, -roDir);
						if(list1[2] == list2[6]){//1~2Åé´Ï °°À¸¸é
							rotation(tNum - 2, roDir);
						}else{//1~2Åé´Ï ´Ù¸£¸é
							rotation(tNum - 2, roDir);
							rotation(tNum - 3, -roDir);
						}
					}
				}
			}
//			print();
//			System.out.println();
			
		}
		
		//Á¡¼ö Ä«¿îÆ®
		if(list1[0] == 1){
			answer += 1;
		}
		if(list2[0] == 1){
			answer += 2;
		}
		if(list3[0] == 1){
			answer += 4;
		}
		if(list4[0] == 1){
			answer += 8;
		}
		
//		print();
		
		System.out.println(answer);
	}

	public static void rotation(int tNum, int roDir) {
		int[] list;
		if(tNum == 1){
			list = list1;
		}else if(tNum == 2){
			list = list2;
		}else if(tNum == 3){
			list = list3;
		}else{
			list = list4;
		}
		
		int temp;
		if(roDir == 1){
			temp = list[7];
			list[7] = list[6];
			list[6] = list[5];
			list[5] = list[4];
			list[4] = list[3];
			list[3] = list[2];
			list[2] = list[1];
			list[1] = list[0];
			list[0] = temp;
		}else{
			temp = list[0];
			list[0] = list[1];
			list[1] = list[2];
			list[2] = list[3];
			list[3] = list[4];
			list[4] = list[5];
			list[5] = list[6];
			list[6] = list[7];
			list[7] = temp;
		}
	}
	
	public static void print() {
		for(int i = 0; i < 8; i++){
			System.out.print(list1[i]);
		}
		System.out.println();
		for(int i = 0; i < 8; i++){
			System.out.print(list2[i]);
		}
		System.out.println();
		for(int i = 0; i < 8; i++){
			System.out.print(list3[i]);
		}
		System.out.println();
		for(int i = 0; i < 8; i++){
			System.out.print(list4[i]);
		}
		System.out.println();
	}
}


