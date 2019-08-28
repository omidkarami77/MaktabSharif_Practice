import java.util.Scanner;
    public class Question3 {
        public static void main(String[] args) {
            int n;
            Scanner input = new Scanner(System.in);
            n = input.nextInt();
            for (int i = 0; i < n; i++) {
                int a = input.nextInt();
                int counter = 0;
                int num = 2;
                while (counter != a) {
                    if (aval(num)) {
                        counter++;
                    }
                    num++;
                }

                System.out.println(num - 1);
            }

        }

        public static boolean aval(int n) {
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