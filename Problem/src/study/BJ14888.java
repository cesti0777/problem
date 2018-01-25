package study;

import java.util.Scanner;

public class BJ14888 {
   static int n;//���� ����
   static int[] numbers = new int[11];//����
   static char[] operators = new char[10];//������
   static long max = Long.MIN_VALUE;
   static long min = Long.MAX_VALUE;
   static int total;//������ �� ����

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      n = in.nextInt();// ���� ���� �Է�

      for (int i = 0; i < n; i++) {// ���� �Է�
         numbers[i] = in.nextInt();
      }

      // ������ �迭�� �Ϸķ� ���
      int operatorCnt = in.nextInt();
      int idx = 0;

      for (int i = idx; i < operatorCnt; i++, idx = i) {
         operators[i] = '+';
         total++;
      }
      operatorCnt += in.nextInt();
      for (int i = idx; i < operatorCnt; i++, idx = i) {
         operators[i] = '-';
         total++;
      }
      operatorCnt += in.nextInt();
      for (int i = idx; i < operatorCnt; i++, idx = i) {
         operators[i] = '*';
         total++;
      }
      operatorCnt += in.nextInt();
      for (int i = idx; i < operatorCnt; i++) {
         operators[i] = '/';
         total++;
      }

      execute(0, numbers[0]);// ����

      System.out.println(max);//�ִ� ���
      System.out.println(min);//�ּ� ���
   }

   public static void execute(int numIdx, long result) {
      if (numIdx == total) {//������ ������ŭ ��� ��������� �ִ�, �ּ� ���
         max = Math.max(max, result);
         min = Math.min(min, result);
      }

      for (int i = 0; i < total; i++) {
         if (operators[i] == '.') {//���� �����ڴ� pass
            continue;
         }

         char temp = operators[i];
         operators[i] = '.';//����� ������ ǥ��

         if (temp == '+') {
            execute(numIdx + 1, result + numbers[numIdx + 1]);
         } else if (temp == '-') {
            execute(numIdx + 1, result - numbers[numIdx + 1]);
         } else if (temp == '*') {
            execute(numIdx + 1, result * numbers[numIdx + 1]);
         } else if (temp == '/') {
            if (result < 0) {//������� ���ڰ� �����϶� ����ιٲ� �� ������ ������ �ٲ��ش� 
               execute(numIdx + 1, -(Math.abs(result) / numbers[numIdx + 1]));
            } else {
               execute(numIdx + 1, result / numbers[numIdx + 1]);
            }
         }
         operators[i] = temp;//��Ʈ��ŷ
      }
   }
}