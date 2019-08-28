package Question1;

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        Container a = new Container();
        a.add(3);
        a.add(5);
        a.add(10);
        a.add(8);
        a.deleteByIndex(1);
        System.out.println(a);
    }
}

class Container {

    private int[] numbers;
    private int tedad;

    public Container() {
        numbers = new int[0];
        tedad = 0;
    }

    public void sortPtB() {

        for (int i = 0; i < tedad; i++) {
            for (int j = i + 1; j < tedad; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public void sortBtp() {
        this.sortPtB();
        int[] a = new int[numbers.length];
        for (int i = 0; i < tedad; i++) {
            a[tedad - i - 1] = numbers[i];
        }
        numbers = a;
    }

    public void add(int n) {
        int[] temp = Arrays.copyOf(numbers, numbers.length);
        numbers = new int[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            numbers[i] = temp[i];
        }
        numbers[numbers.length - 1] = n;
        tedad++;
    }

    public void deleteByIndex(int i) {
        int[] temp = Arrays.copyOf(numbers, numbers.length);
        numbers = new int[numbers.length - 1];
        for (int j = 0; j < i; j++) {
            numbers[j] = temp[j];
        }
        for (int j = i; j < temp.length - 1; j++) {
            numbers[j] = temp[j];
        }
    }

    public void deleteByValue(int i) {
        for (int j = 0; j < tedad; j++) {
            if (numbers[j] == i)
                deleteByIndex(j);
        }
    }

    public int find(int i) {
        for (int j = 0; j < tedad; j++) {
            if (i == numbers[j])
                return j;
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }
}
