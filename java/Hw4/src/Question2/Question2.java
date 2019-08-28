package Question2;

import java.util.Scanner;

public class Question2 {

    public static boolean checkWin(int i, int j, String[][] table, String a) {
        //orib shomaleshargh
        if (table[i][j] == a && table[i + 1][j + 1] == a && table[i + 2][j + 2] == a && table[i + 3][j + 3] == a)
            return true;
        if (table[i - 1][j - 1] == a && table[i][j] == a && table[i + 1][j + 1] == a && table[i + 2][j + 2] == a)
            return true;
        if (table[i - 2][j - 2] == a && table[i - 1][j - 1] == a && table[i][j] == a && table[i + 1][j + 1] == a)
            return true;
        if (table[i - 3][j - 3] == a && table[i - 2][j - 2] == a && table[i - 1][j - 1] == a && table[i][j] == a)
            return true;
        //orib shomale ghaarb
        if (table[i][j] == a && table[i - 1][j + 1] == a && table[i - 2][j + 2] == a && table[i - 3][j + 3] == a)
            return true;
        if (table[i + 1][j - 1] == a && table[i][j] == a && table[i - 1][j + 1] == a && table[i - 2][j + 2] == a)
            return true;
        if (table[i + 2][j - 2] == a && table[i + 1][j - 1] == a && table[i][j] == a && table[i - 1][j + 1] == a)
            return true;
        if (table[i + 3][j - 3] == a && table[i + 2][j - 2] == a && table[i + 1][j - 1] == a && table[i][j] == a)
            return true;

        //shomal
        if (table[i][j] == a && table[i][j + 1] == a && table[i][j + 2] == a && table[i][j + 3] == a)
            return true;
        if (table[i][j - 1] == a && table[i][j] == a && table[i][j + 1] == a && table[i][j + 2] == a)
            return true;
        if (table[i][j - 2] == a && table[i][j - 1] == a && table[i][j] == a && table[i][j + 1] == a)
            return true;
        if (table[i][j - 3] == a && table[i][j - 2] == a && table[i][j - 1] == a && table[i][j] == a)
            return true;
        //shargh
        if (table[i][j] == a && table[i - 1][j] == a && table[i - 2][j] == a && table[i - 3][j] == a)
            return true;
        if (table[i + 1][j] == a && table[i][j] == a && table[i - 1][j] == a && table[i - 2][j] == a)
            return true;
        if (table[i + 2][j] == a && table[i + 1][j] == a && table[i][j] == a && table[i - 1][j] == a)
            return true;
        if (table[i + 3][j] == a && table[i + 2][j] == a && table[i + 1][j] == a && table[i][j] == a)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        try {
            if (n <= 0 || m <= 0)
                throw new Exception("n m koochecter");
            String[][] table = new String[n + 6][m + 6];
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    if (i < 3 || i >= n + 3)
                        table[i][j] = "H";
                    else if (j < 3 || j >= m + 3)
                        table[i][j] = "H";
                    else
                        table[i][j] = "O";
                }
            }


            boolean nobat = true;
            outer:
            while (true) {
                for (int i = 0; i < table.length; i++) {
                    for (int j = 0; j < table[i].length; j++) {
                        System.out.print(table[i][j]);
                    }
                    System.out.println();
                }
                for (int i = 0; i < m; i++) {
                    if (table[n + 2][i + 3] == "O") {
                        break;
                    } else if (i == m - 1) {
                        System.out.println("It’s a tie.");
                        break outer;
                    }
                }
                int temp = input.nextInt() + 2;
                for (int j = 0; j < table[temp].length; j++) {
                    if (table[temp][j] == "O") {
                        if (nobat) {
                            table[temp][j] = "R";
                            if (checkWin(temp, j, table, "R")) {
                                System.out.println("amir wins");
                                break outer;
                            }
                            nobat = false;
                        } else {
                            table[temp][j] = "A";
                            if (checkWin(temp, j, table, "A")) {
                                System.out.println("ali wins");
                                break outer;
                            }
                            nobat = true;
                        }
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
