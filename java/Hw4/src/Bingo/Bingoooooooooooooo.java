package Bingo;

import java.util.Random;

public class Bingoooooooooooooo {

    public static int[][] d() {
        Random r = new Random();
        //رندوم 3 در 5
        int[][] c = {{r.nextInt() % 90, r.nextInt() % 90, r.nextInt() % 90, r.nextInt() % 90, r.nextInt() % 90},
                {r.nextInt() % 90, r.nextInt() % 90
                , r.nextInt() % 90, r.nextInt() % 90, r.nextInt() % 90}, {r.nextInt() % 90, r.nextInt() % 90, r.nextInt() % 90, r.nextInt() % 90, r.nextInt() % 90}};
        return c;
    }

    public static void main(String[] args) {
        Random r = new Random();
        Player[] a = new Player[3];
        Card[] b = new Card[4];
        b[0] = new Card(d());
        b[1] = new Card(d());
        b[2] = new Card(d());
        b[3] = new Card(d());
        Card[] c = new Card[3];
        c[0] = new Card(d());
        c[1] = new Card(d());
        c[2] = new Card(d());
        Card[] u = new Card[2];
        u[0] = new Card(d());
        u[1] = new Card(d());
        a[0] = new Player("ali", b);
        a[1] = new Player("saeed", c);
        a[2] = new Player("hamid", u);
        Bingo bing = new Bingo(a);
        for (int i = 0; i < 1000; i++) {
            System.out.print(i + ":");
            System.out.print(bing.play(r.nextInt() % 90));
        }

    }
}

class Card {
    int[][] numbers;
    boolean[][] mark;

    public Card(int[][] numbers) {
        this.numbers = numbers;
        this.mark = new boolean[3][5];
        for (int i = 0; i < this.mark.length; i++) {
            for (int j = 0; j < mark[i].length; j++) {
                mark[i][j] = false;
            }
        }
    }

    public int getNumber(int row, int column) {
        return numbers[row][column];
    }

    public boolean isMarked(int row, int column) {
        return mark[row][column];
    }

    public void markNumber(int number) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == number) {
                    mark[i][j] = true;
                }
            }
        }
    }
}

class Player {
    public Card[] cards;
    public String name;

    public Card[] getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public Player(String name, Card[] cards) {
        this.cards = cards;
        this.name = name;
    }

    public boolean isWinner() {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].numbers.length; j++) {
                int temp = 0;
                for (int k = 0; k < cards[i].numbers[j].length; k++) {
                    if (cards[i].isMarked(j, k)) {
                        temp += 1;
                    }
                }
                if (temp == cards[i].numbers.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public void markNumber(int number) {
        for (int i = 0; i < cards.length; i++) {
            cards[i].markNumber(number);
        }
    }
}

class Bingo {
    public Player[] players;

    public Bingo(Player[] players) {
        this.players = players;
    }

    public String play(int number) {
        String temp = "";
        for (int i = 0; i < players.length; i++) {
            players[i].markNumber(number);
            if (players[i].isWinner()) {
                temp += players[i].name + " ";
            }
        }
        return temp;
    }
}
