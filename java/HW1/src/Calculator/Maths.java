package Calculator;
    public class Maths {
        public double add(double a, double b) {
            double answer = a + b;
            return answer;
        }

        public double subtract(double a, double b) {
            double answer = a - b;
            return answer;
        }

        public double multiply(double a, double b) {
            double answer = a * b;
            return answer;
        }

        double divide(double a, double b) {
            double answer = a / b;
            return answer;
        }

        double power(double a, double b) {
            double answer = a;
            for (int i = 2; i <= b; i++) {
                answer *= a;
            }
            return answer;
        }

    }


