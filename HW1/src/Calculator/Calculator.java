package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Maths maths = new Maths();
        double answer = 0;
        double inputA = 0;
        double inputB = 0;
        char operator;
        while (true) {
            System.out.println("please enter the number: ");
            if(!input.hasNextDouble()){
                if(input.next().equals("exit")){
                    break ;
                }
            }
            inputA = input.nextDouble();
            operator = input.next().charAt(0);
            inputB = input.nextDouble();
            switch (operator) {
                case '+':
                    answer = maths.add(inputA, inputB);
                    break;
                case '-':
                    answer = maths.subtract(inputA, inputB);
                    break;
                case '*':
                    answer = maths.multiply(inputA, inputB);
                    break;
                case '/':
                    answer = maths.divide(inputA, inputB);
                    break;
                case '^':
                    answer = maths.power(inputA, inputB);
                    break;
            }

            System.out.println(answer);
        }
    }
}
