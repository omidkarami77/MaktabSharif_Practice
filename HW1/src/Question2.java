public class Question2 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        a = f(a, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static int[] f(int[]a, int n){
        int[] b = new int[a.length];
        int y = 0;
        for (int i = a.length - n; i < a.length; i++) {
            b[y] = a[i];
            y++;
        }
        for (int i = 0; i < a.length - n; i++) {
            b[y] = a[i];
            y++;
        }
        return b;
    }
}
