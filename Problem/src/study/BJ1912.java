package study;

import java.util.Scanner;

public class BJ1912 {
   
   static int n;//수열 갯수
   static int[] numbers = new int[100000];//수열
   static int max;//최대값
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      
      n = in.nextInt();
      
      //수열 입력
      for(int i = 0; i < n; i++){
         numbers[i] = in.nextInt();
      }
      
      execute();//실행
      
      System.out.println(max);//최대 출력
   }
   
   public static void execute(){
      max = numbers[0];//최대값 수열 첫째값으로 초기화
      int sum = numbers[0];//누적합 계산을 위한 변수
      for(int i = 1; i < n; i++){
         if(sum + numbers[i] < numbers[i]){//현재까지 누적합이 현재수열값보다 작으면 
            sum = numbers[i];//현재 수열값부터 다시 누적시작
         }else{
            sum += numbers[i];//누적합 계산
         }
         max = Math.max(max, sum);//최대값 갱신
      }
   }
}