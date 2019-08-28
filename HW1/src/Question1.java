import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the number ? ");
        double sum = 0;
        double min = 0;
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            double temp = input.nextDouble();
            if (i == 0) {
                min = temp;
            }

            if (temp < min) {
                min = temp;
            }
            sum += temp;
        }
        double result = sum / n;
        System.out.println("your avg is " + result);
        System.out.println("your min number is " + min);
    }
}
