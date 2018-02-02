package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14891 {

	static LinkedList<Integer> list1 = new LinkedList<>();
	static LinkedList<Integer> list2 = new LinkedList<>();
	static LinkedList<Integer> list3 = new LinkedList<>();
	static LinkedList<Integer> list4 = new LinkedList<>();
	static int orderCnt;
	static Queue<Integer> orders = new LinkedList<Integer>();
	static int answer;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		for (int i = 0; i < 8; i++) {
			list1.add(Integer.parseInt(line.charAt(i) + ""));
		}
		line = in.nextLine();
		for (int i = 0; i < 8; i++) {
			list2.add(Integer.parseInt(line.charAt(i) + ""));
		}
		line = in.nextLine();
		for (int i = 0; i < 8; i++) {
			list3.add(Integer.parseInt(line.charAt(i) + ""));
		}
		line = in.nextLine();
		for (int i = 0; i < 8; i++) {
			list4.add(Integer.parseInt(line.charAt(i) + ""));
		}

		orderCnt = in.nextInt();

		for (int i = 0; i < orderCnt; i++) {
			orders.add(in.nextInt());
			orders.add(in.nextInt());
		}

		execute();// ����

	}

	public static void execute() {

		int tNum;
		int roDir;

		while (!orders.isEmpty()) {
			tNum = orders.remove();
			roDir = orders.remove();

			if(tNum == 1){
				if(list1.get(2) == list2.get(6)){//1~2��� ������
					rotation(tNum, roDir);
				}else{//1~2��� �ٸ���
					rotation(tNum, roDir);
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum + 1, -roDir);
					}else{//2~3��� �ٸ���
						rotation(tNum + 1, -roDir);
						if(list3.get(2) == list4.get(6)){//3~4��� ������
							rotation(tNum + 2, roDir);
						}else{//3~4��� �ٸ���
							rotation(tNum + 2, roDir);
							rotation(tNum + 3, -roDir);
						}
					}
				}
			}else if(tNum == 2){
				if(list1.get(2) == list2.get(6)){//1~2��� ������
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum, roDir);
					}else{//2~3��� �ٸ���
						rotation(tNum, roDir);
						if(list3.get(2) == list4.get(6)){//3~4��� ������
							rotation(tNum + 1, -roDir);
						}else{//3~4��� �ٸ���
							rotation(tNum + 1, -roDir);
							rotation(tNum + 2, roDir);
						}
					}
				}else{//1~2��� �ٸ���
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum, roDir);
						rotation(tNum - 1, -roDir);
					}else{//2~3��� �ٸ���
						rotation(tNum, roDir);
						if(list3.get(2) == list4.get(6)){//3~4��� ������
							rotation(tNum + 1, -roDir);
						}else{//3~4��� �ٸ���
							rotation(tNum + 1, -roDir);
							rotation(tNum + 2, roDir);
						}
					}
				}
			}else if(tNum == 3){
				if(list3.get(2) == list4.get(6)){//3~4��� ������
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum, roDir);
					}else{//2~3��� �ٸ���
						rotation(tNum, roDir);
						if(list1.get(2) == list2.get(6)){//1~2��� ������
							rotation(tNum - 1, -roDir);
						}else{//1~2��� �ٸ���
							rotation(tNum - 1, -roDir);
							rotation(tNum - 2, roDir);
						}
					}
				}else{//3~4��� �ٸ���
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum, roDir);
						rotation(tNum + 1, -roDir);
					}else{//2~3��� �ٸ���
						rotation(tNum, roDir);
						if(list1.get(2) == list2.get(6)){//1~2��� ������
							rotation(tNum - 1, -roDir);
						}else{//1~2��� �ٸ���
							rotation(tNum - 1, -roDir);
							rotation(tNum - 2, roDir);
						}
					}
				}
			}else{
				if(list3.get(2) == list4.get(6)){//3~4��� ������
					rotation(tNum, roDir);
				}else{//3~4��� �ٸ���
					rotation(tNum, roDir);
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum - 1, -roDir);
					}else{//2~3��� �ٸ���
						rotation(tNum - 1, -roDir);
						if(list1.get(2) == list2.get(6)){//1~2��� ������
							rotation(tNum - 2, roDir);
						}else{//1~2��� �ٸ���
							rotation(tNum - 2, roDir);
							rotation(tNum - 3, -roDir);
						}
					}
				}
			}
			print();
			System.out.println();
			
		}
		
		//���� ī��Ʈ
		if(list1.get(0) == 1){
			answer += 1;
		}
		if(list2.get(0) == 1){
			answer += 2;
		}
		if(list3.get(0) == 1){
			answer += 4;
		}
		if(list4.get(0) == 1){
			answer += 8;
		}
		
		print();
		
		System.out.println(answer);
	}

	public static void rotation(int tNum, int roDir) {
		LinkedList<Integer> list;
		if(tNum == 1){
			list = list1;
		}else if(tNum == 2){
			list = list2;
		}else if(tNum == 3){
			list = list3;
		}else{
			list = list4;
		}
		
		if(roDir == 1){
			list.addFirst(list.removeLast());
		}else{
			list.addLast(list.removeFirst());
		}
	}
	
	public static void print() {
		for(int i = 0; i < 8; i++){
			System.out.print(list1.get(i));
		}
		System.out.println();
		for(int i = 0; i < 8; i++){
			System.out.print(list2.get(i));
		}
		System.out.println();
		for(int i = 0; i < 8; i++){
			System.out.print(list3.get(i));
		}
		System.out.println();
		for(int i = 0; i < 8; i++){
			System.out.print(list4.get(i));
		}
		System.out.println();
	}
}

