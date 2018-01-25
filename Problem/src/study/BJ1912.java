package study;

import java.util.Scanner;

public class BJ1912 {
   
   static int n;//���� ����
   static int[] numbers = new int[100000];//����
   static int max;//�ִ밪
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      
      n = in.nextInt();
      
      //���� �Է�
      for(int i = 0; i < n; i++){
         numbers[i] = in.nextInt();
      }
      
      execute();//����
      
      System.out.println(max);//�ִ� ���
   }
   
   public static void execute(){
      max = numbers[0];//�ִ밪 ���� ù°������ �ʱ�ȭ
      int sum = numbers[0];//������ ����� ���� ����
      for(int i = 1; i < n; i++){
         if(sum + numbers[i] < numbers[i]){//������� �������� ������������� ������ 
            sum = numbers[i];//���� ���������� �ٽ� ��������
         }else{
            sum += numbers[i];//������ ���
         }
         max = Math.max(max, sum);//�ִ밪 ����
      }
   }
}