package study;

import java.util.Scanner;

public class BJ14888 {
   static int n;//수열 갯수
   static int[] numbers = new int[11];//수열
   static char[] operators = new char[10];//연산자
   static long max = Long.MIN_VALUE;
   static long min = Long.MAX_VALUE;
   static int total;//연산자 총 갯수

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      n = in.nextInt();// 수열 갯수 입력

      for (int i = 0; i < n; i++) {// 수열 입력
         numbers[i] = in.nextInt();
      }

      // 연산자 배열에 일렬로 담기
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

      execute(0, numbers[0]);// 실행

      System.out.println(max);//최대 출력
      System.out.println(min);//최소 출력
   }

   public static void execute(int numIdx, long result) {
      if (numIdx == total) {//연산자 갯수만큼 모두 사용했으면 최대, 최소 계산
         max = Math.max(max, result);
         min = Math.min(min, result);
      }

      for (int i = 0; i < total; i++) {
         if (operators[i] == '.') {//사용된 연산자는 pass
            continue;
         }

         char temp = operators[i];
         operators[i] = '.';//사용한 연산자 표시

         if (temp == '+') {
            execute(numIdx + 1, result + numbers[numIdx + 1]);
         } else if (temp == '-') {
            execute(numIdx + 1, result - numbers[numIdx + 1]);
         } else if (temp == '*') {
            execute(numIdx + 1, result * numbers[numIdx + 1]);
         } else if (temp == '/') {
            if (result < 0) {//나누기는 분자가 음수일땐 양수로바꾼 후 나누고 음수로 바꿔준다 
               execute(numIdx + 1, -(Math.abs(result) / numbers[numIdx + 1]));
            } else {
               execute(numIdx + 1, result / numbers[numIdx + 1]);
            }
         }
         operators[i] = temp;//백트렉킹
      }
   }
}