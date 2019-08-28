package Question5;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n=input.nextInt();
        System.out.println(checkAval(n));
    }

    public static boolean checkAval(int n){
        for (int i  = 2; i < n; i++) {
            if(aval(i) && aval(n=n - i)){
                System.out.println(i+" + "+n);
                break;
            }
        }
        return true;
    }


    public static boolean aval(int n){
        boolean is_prime = true;
        if (n < 2) {
            is_prime = false;
        }
        for (int factor = 2; factor * factor <= n; factor++) {
            if (n % factor == 0) {
                is_prime = false;
                break;

            }
        }
        if (is_prime) {
            return true;
        } else {
            return false;
        }
    }
}
