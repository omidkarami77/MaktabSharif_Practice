package Question1;

import java.util.Collections;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("please enter the number : ");
            int n = input.nextInt();
            if (n <= 0)
                throw new Exception("اعداد زیر صفر");
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    int temp = input.nextInt();
                    a[i][j] = temp;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (a[i][j] > a[i][j + 1]) {
                        a[i - 1][j] += a[i][j];
                    } else {
                        a[i - 1][j] += a[i][j + 1];
                    }
                }
            }

            System.out.println(a[0][0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//اون مثلث بزرگه شد 1074
    }
}