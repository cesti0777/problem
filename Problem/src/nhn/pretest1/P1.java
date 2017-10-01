package nhn.pretest1;

import java.util.ArrayList;
import java.util.Scanner;

public class P1 {
   static int n = 0;
   static int[][] arr = null;
   static int[][] union = null;
   static int[] result = null;

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      n = in.nextInt();
      arr = new int[n][n];
      union = new int[2][100];
      result = new int[100];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            arr[i][j] = in.nextInt();
         }
      }

      int cnt = 0;
      int u = 0;

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (arr[i][j] == 1) {
               if (j - 1 >= 0 && arr[i][j - 1] != 0) {
                  arr[i][j] = arr[i][j - 1];
               } else if (i - 1 >= 0 && arr[i - 1][j] != 0) {
                  arr[i][j] = arr[i - 1][j];
               } else {
                  cnt++;
                  arr[i][j] = cnt;
               }
            }
         }
      }

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (j - 1 >= 0 && i - 1 >= 0 && arr[i][j - 1] != 0 && arr[i - 1][j] != 0) {
               if (arr[i][j - 1] != arr[i - 1][j]) {
                  union[0][u] = arr[i][j - 1];
                  union[1][u] = arr[i - 1][j];
                  u++;
               }
            }
         }
      }
      for (int a = 0; a < 100; a++) {
         if (union[0][a] != 0) {
            for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                  if (arr[i][j] == union[1][a]) {
                     arr[i][j] = union[0][a];
                  }
               }
            }
         }
      }

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (arr[i][j] != 0) {
               result[arr[i][j]]++;
            }
         }
      }

      int totalR = 0;
      for (int i = 1; i < 10; i++) {
         if (result[i] != 0) {
            totalR++;
         }
      }

      System.out.println(totalR);

      ArrayList<Integer> al = new ArrayList<Integer>();

      for (int i = 0; i < 100; i++) {
         if (result[i] != 0) {
            al.add(result[i]);
         }
      }
      al.sort(null);
      for (int i = 0; i < al.size(); i++) {
         System.out.print(al.get(i));
         if(i == al.size() -1)
            continue;
         System.out.print(" ");
      }
      System.out.println();
   }
}