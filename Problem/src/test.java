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
			if(num[i]/10 < 1){ // ���ڸ���
				for(int j = i+1; j < num.length; j++){
					if(num[j]/10 < 1){// ���ڸ���
						if(num[i] > num[j]){
							max = num[i];
						}else{
							max = num[j];
						}
					}else{// ���ڸ���
						if(num[i] > num[j]/10){
							max = num[i];
						}else{
							max = num[j];
						}
					}
				}
				sortedNum[i] = max;
			}else{// ���ڸ���
				for(int j = i+1; j < num.length; j++){
					if(num[j]/10 < 1){// ���ڸ���
						if(num[i]/10 > num[j]){
							max = num[i];
						}else{
							max = num[j];
						}
						
					}else{// ���ڸ���
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

//1. ���� �̾� ���̱�
//
//���� ���� �ڿ����� ǥ�� �Է�(standard input)���� ���� ��, �� ������ �̾� �ٿ��� ���� �� �ִ� ���� ū ���� ���� ���� ���� ���� ���ϼ���.
//
//
//
//[�Է�]
//
//�־����� �Է��� 10�� �����̸�, ������ ���ڴ� 2�ڸ� ������ �ڿ����Դϴ�.
//���ڴ� �������� ���е˴ϴ�.
//�� ��° ���ÿ� ���� ���� ��� ���캸�ñ� �ٶ��ϴ�.
// 
//[���]
//�ùٸ� ����� �ϳ��� �����̾�� �ϸ�, ������ �������� ���ʿ��� ���� ���� ���� ����(newline, \n)�� ������ �մϴ�. 
// 
//
//[���� ���� (1)]
//
//�Է��� 1 2 3�� ���, ���� �� �ִ� ���� ū ���� 321�̰� ���� ���� ���� 123�̸� �� ���� ���� 444�̴�. 
//���� ����� ������ ����.
//444
// 
//
//[���� ���� (2)] 
//
//�Է��� 2 9 10 21 24�� ���, 
//���� �� �ִ� ���� ū ���� 92422110�̰�, ���� ���� ���� 10212249�̸� �� ���� ���� 102634359
//���� ����� ������ ����. 
//102634359