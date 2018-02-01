package study;

import java.util.Arrays;
import java.util.Scanner;

public class SE1860 {

	static int testCaseCnt;//testcase ����
	static int n, m ,k;//��� ��, �ؾ ���� �ֱ�, �ؾ ������
	static int[] people;
	static String answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase ���� �Է�

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			init();//���� �ʱ�ȭ
			
			n = in.nextInt();//��� �� �Է�
			m = in.nextInt();//�ؾ ���� �ֱ� �Է�
			k = in.nextInt();//�ؾ ������ �Է�
			
			people = new int[n];//��� ���� �ð�
			
			for(int i = 0; i < n; i++){//��� ���� �ð� �Է�
				people[i] = in.nextInt();
			}
			
			Arrays.sort(people);//��� ���� �ð� �������� ����
			
			execute();//����
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void init() {
		people = null;
	}

	public static void execute() {
		int mSum = m;//ù��° �ؾ���� �ֱ� �ʱ�ȭ
		int peopleIdx = 0;//ù��° ������� �ʱ�ȭ
		int curSec = 0;//���� �ð�(��)
		int fishSum = 0;//������ �ؾ ��
		while(peopleIdx != n){//���� �ʰ� �����ϴ� ��� �ʱ��� ������
			
			//��� �����ð� �ߺ�
			if(curSec > people[peopleIdx]){//�ʴ� ���������� �����ð��� �������� �ʾ��� ���
				if(fishSum > 0){//������ �ؾ�� ������
					fishSum--;//�ؾ ����
					peopleIdx++;//���� ������ ������� �ε��� ����
					curSec--;//�ش� �ʸ� �״�� �����ϰ� ����
				}else{//������ �ؾ�� ������
					answer = "Impossible";
					return;
				}
				continue;//�ؾ�� �����ϸ� �ȵǹǷ� ���� �ݺ������� �Ѿ
			}
			
			//�ؾ ����
			if(curSec == mSum){//���� �ð��� �ؾ� ���� �ֱⰡ �Ǹ�
				fishSum += k;//������ �ؾ ����
				mSum += m;//���� �ֱ�� ����
			}
			
			//�ؾ ����
			if(curSec == people[peopleIdx]){//��� �����ð��� �Ǹ� 
				if(fishSum > 0){//������ �ؾ�� ������
					fishSum--;//�ؾ ����
					peopleIdx++;//���� ������ ������� �ε��� ����
				}else{//������ �ؾ�� ������
					answer = "Impossible";
					return;
				}
			}
			curSec++;//������
		}
		answer = "Possible";//��� ��� �ؾ �����ϸ� ����
	}
}