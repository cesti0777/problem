package midas.test;
import java.util.Scanner;

class Program1 {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int m = in.nextInt();
      int k = in.nextInt();
      int result;
      if(n <= k) { 
         result = (int)(n+m-k)/3;
      }
      else { 
         result = n/2;
      }
      System.out.print(result);
    }
}