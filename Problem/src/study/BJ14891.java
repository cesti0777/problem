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

		//linkedlist�� ������� �Է�
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

		//���� inqueue �۾�
		for (int i = 0; i < orderCnt; i++) {
			orders.add(in.nextInt());
			orders.add(in.nextInt());
		}

		execute();// ����

	}

	public static void execute() {

		int tNum;
		int roDir;

		while (!orders.isEmpty()) {//���̻� ������ ���������� �ݺ�
			tNum = orders.remove();
			roDir = orders.remove();

			if(tNum == 1){
				if(list1.get(2) == list2.get(6)){//1~2��� ������
					rotation(tNum, roDir);//1��� ȸ��
				}else{//1~2��� �ٸ���
					rotation(tNum, roDir);//1��� ȸ��
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum + 1, -roDir);//2��� ȸ��
					}else{//2~3��� �ٸ���
						rotation(tNum + 1, -roDir);//2��� ȸ��
						if(list3.get(2) == list4.get(6)){//3~4��� ������
							rotation(tNum + 2, roDir);//3��� ȸ��
						}else{//3~4��� �ٸ���
							rotation(tNum + 2, roDir);//3��� ȸ��
							rotation(tNum + 3, -roDir);//4��� ȸ��
						}
					}
				}
			}else if(tNum == 2){
				if(list1.get(2) == list2.get(6)){//1~2��� ������
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum, roDir);//2��� ȸ��
					}else{//2~3��� �ٸ���
						rotation(tNum, roDir);//2��� ȸ��
						if(list3.get(2) == list4.get(6)){//3~4��� ������
							rotation(tNum + 1, -roDir);//3��� ȸ��
						}else{//3~4��� �ٸ���
							rotation(tNum + 1, -roDir);//3��� ȸ��
							rotation(tNum + 2, roDir);//4��� ȸ��
						}
					}
				}else{//1~2��� �ٸ���
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum, roDir);//2��� ȸ��
						rotation(tNum - 1, -roDir);//1��� ȸ��
					}else{//2~3��� �ٸ���
						rotation(tNum, roDir);//2��� ȸ��
						rotation(tNum - 1, -roDir);//1��� ȸ��
						if(list3.get(2) == list4.get(6)){//3~4��� ������
							rotation(tNum + 1, -roDir);//3��� ȸ��
						}else{//3~4��� �ٸ���
							rotation(tNum + 1, -roDir);//3��� ȸ��
							rotation(tNum + 2, roDir);//4��� ȸ��
						}
					}
				}
			}else if(tNum == 3){
				if(list3.get(2) == list4.get(6)){//3~4��� ������
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum, roDir);//3��� ȸ��
					}else{//2~3��� �ٸ���
						rotation(tNum, roDir);//3��� ȸ��
						if(list1.get(2) == list2.get(6)){//1~2��� ������
							rotation(tNum - 1, -roDir);//2��� ȸ��
						}else{//1~2��� �ٸ���
							rotation(tNum - 1, -roDir);//2��� ȸ��
							rotation(tNum - 2, roDir);//1��� ȸ��
						}
					}
				}else{//3~4��� �ٸ���
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum, roDir);//3��� ȸ��
						rotation(tNum + 1, -roDir);//4��� ȸ��
					}else{//2~3��� �ٸ���
						rotation(tNum, roDir);//3��� ȸ��
						rotation(tNum + 1, -roDir);//4��� ȸ��
						if(list1.get(2) == list2.get(6)){//1~2��� ������
							rotation(tNum - 1, -roDir);//2��� ȸ��
						}else{//1~2��� �ٸ���
							rotation(tNum - 1, -roDir);//2��� ȸ��
							rotation(tNum - 2, roDir);//1��� ȸ��
						}
					}
				}
			}else{
				if(list3.get(2) == list4.get(6)){//3~4��� ������
					rotation(tNum, roDir);//4��� ȸ��
				}else{//3~4��� �ٸ���
					rotation(tNum, roDir);//4��� ȸ��
					if(list2.get(2) == list3.get(6)){//2~3��� ������
						rotation(tNum - 1, -roDir);//3��� ȸ��
					}else{//2~3��� �ٸ���
						rotation(tNum - 1, -roDir);//3��� ȸ��
						if(list1.get(2) == list2.get(6)){//1~2��� ������
							rotation(tNum - 2, roDir);//2��� ȸ��
						}else{//1~2��� �ٸ���
							rotation(tNum - 2, roDir);//2��� ȸ��
							rotation(tNum - 3, -roDir);//1��� ȸ��
						}
					}
				}
			}
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
		
		if(roDir == 1){//�ð���� ȸ�� -> tail�� head�� �ٿ��ش�
			list.addFirst(list.removeLast());
		}else{//�ð���� ȸ�� -> head�� tail�� �ٿ��ش�
			list.addLast(list.removeFirst());
		}
	}
}


