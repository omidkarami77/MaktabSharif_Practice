package Question2;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1 is binary to decimal and 2 is decimal to binary ");
        while (true) {
            System.out.println("please enter the number : ");
            if (input.hasNextInt()) {
                int num = input.nextInt();
                if (num != 1 && num != 2) {
                    break;
                }
                String numberOfbinary;
                int numberOfdecimal;
                if (num == 1) {
                    System.out.println("please enter the binary number : ");
                    numberOfbinary = input.next();
                    System.out.println("decimal number is " + bintodec(numberOfbinary));
                }
                if (num == 2) {
                    System.out.println("please enter the decimal number : ");
                    numberOfdecimal = input.nextInt();
                    System.out.print("binary number is : ");
                    decimaltobinary(numberOfdecimal);
                    System.out.println();

                }
            } else {
                if(input.next().equals("exit")){
                    break;
                }
            }
        }
}


    private static void decimaltobinary(int number) {
        int remainder;

        if (number <= 1) {
            System.out.print(number);
            return;
        }

        remainder = number % 2;
        decimaltobinary(number >> 1);
        System.out.print(remainder);
    }

    private static int bintodec(String bin) {
        int res = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(bin.length() - i - 1) == '1') {
                res += Math.pow(2, i);
            }
        }
        return res;
    }
}
