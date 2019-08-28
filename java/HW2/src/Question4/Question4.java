package Question4;

import java.util.Random;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        String array[] ={"omid","navid","hamid","mahdi","saeed","vahid","reza"};
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("tedad talash haye khod ra vard konid ");
        int tryO = input.nextInt();//تلاش ها
        int n = random.nextInt(array.length);
        String str = array[n];
        boolean rrr[] = new boolean[str.length()];
        for (int i = 0; i < rrr.length; i++) {
            rrr[i] = false;
        }
        int r = 0;
        String miss = "";
        while (true){
            if(tryO == 0){
                System.out.println("خراب کردی داداش ");
                break;
            }
            if(r == str.length()){
                System.out.println("cong");
                break;
            }
            char temp = input.next().charAt(0);
            tryO--;
            int o = r;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == temp){
                    rrr[i] = true;
                    r++;
                }
            }
            if(o == r){
                miss += temp;
            }
            for (int i = 0; i < str.length(); i++) {
                if(rrr[i] == true){
                System.out.print(str.charAt(i));
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
            System.out.println("try = " + tryO);
            System.out.println("miss = " + miss);
            System.out.println("guees = " + temp);
        }
    }
}
