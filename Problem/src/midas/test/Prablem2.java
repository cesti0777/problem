package midas.test;

import java.util.Scanner;

class Program2 {
	static int result = 0;
	static String line = null;
	
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      
      line = in.nextLine();
      int cnt = Integer.parseInt(line.split(" ")[0]);
      int d = Integer.parseInt(line.split(" ")[1]);
      int[] arr = new int[cnt];
      for (int i = 0; i < cnt; i++) {
         arr[i] = Integer.parseInt(in.nextLine());
      }
      double tmp1 = (double) (cnt - 1) / (d - 1);
      int tmp2 = (int) Math.floor(tmp1);
      result = arr[tmp2] - arr[0];
      System.out.print(result);
    }
}