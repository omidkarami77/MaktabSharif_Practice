package Question3;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Question3 diameter = new Question3();

    }

    public Question3() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int asterisOndiameter = 2 * n + 1;//ستاره ها
        int lineOfdiameter = n + 1;
        int sidewayofsquare = (lineOfdiameter / 2 - 1) * 2 + 1;
        int lineOfstartsubtracing = (asterisOndiameter - sidewayofsquare) / 2 + 1;
        for (int i = 1; i <= n + 1; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print(" ");
            }
            if (i < lineOfstartsubtracing) {
                for (int k = 2 * i - 1; k >= 1; k--) {
                    System.out.print("*");
                }
            } else {
                for (int k = (2 * i - 1 - sidewayofsquare) / 2; k >= 1; k--) {
                    System.out.print("*");
                }
                for (int k = 1; k <= sidewayofsquare; k++) {
                    System.out.print(" ");
                }
                for (int k = (2 * i - 1 - sidewayofsquare) / 2; k >= 1; k--) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = n + 1; i >= 1; i--) {
            for (int j = i; j <= n + 1; j++) {
                System.out.print(" ");
            }
            if (i <= lineOfstartsubtracing) {
                for (int j = i * 2 - 1; j >= 3; j--) {
                    System.out.print("*");
                }
            } else {
                for (int k = (2 * i - 1 - sidewayofsquare) / 2; k > 1; k--) {
                    System.out.print("*");
                }
                for (int k = 1; k <= sidewayofsquare; k++) {
                    System.out.print(" ");
                }
                for (int k = (2 * i - 1 - sidewayofsquare) / 2; k > 1; k--) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

}
