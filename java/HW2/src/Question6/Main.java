package Question6;

public class Main {
    public static void main(String[] args) {
        number(-2,-1,2,1);
    }
    public static int number(int... num){
        int min = Math.abs(num[0] - num[1]);
        int max = Math.abs(num[0] - num[1]);
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (Math.abs(num[i] - num[j]) < min){
                    min = Math.abs(num[i] - num[j]);
                }
                if(Math.abs(num[i] - num[j]) > max) {
                    max = Math.abs(num[i] - num[j]);
                }
            }
        }
        System.out.println(max);
        System.out.println(min);
        return 0;
    }
}
