package Bank;

import java.util.ArrayList;

public class Bankdari {
    public static void main(String[] args) {
        Bank a = new Bank();
        Bank b = new Bank();
        try {
            b.createAccount(55604, 200000, "Gharz");
            b.createAccount(5454545, 100000, "Gharz");
            b.createAccount(516132,1000000,"Short");
            b.setDay(365);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        b.Deposit(5454545, 1000);
        System.out.println(b.showAccounts());

    }
}

class Account {
    public int money;
    public int iD;
    public int minMoney;
    public int sood;

    public void Deposit(int money) {
        this.money += money;
    }

    public void withdraw(int money) throws Exception {
        if (money > this.money) {
            throw new Exception("این مقدار را نمی توان برداشت.");
        } else {
            this.money -= money;
            System.out.println("تراکنش با موفقیت انجام شد.");
        }
    }

    public int getID() {
        return this.iD;
    }

    public int benefit(int days) {
        return (days / 365) * (this.sood / 100);
    }

    public int getBalance() {
        return this.money;
    }
}

class ShortTerm extends Account {
    public ShortTerm(int money, int id) {
        this.iD = id;
        this.money = money;
        this.minMoney = 10000;
        this.sood = 17;
    }
}


class LongTerm extends Account {
    public LongTerm(int money, int id) {
        this.iD = id;
        this.money = money;
        this.minMoney = 15000;
        this.sood = 24;
    }
}


class Current extends Account {
    public Current(int money, int id) {
        this.iD = id;
        this.money = money;
        this.minMoney = 0;
        this.sood = 0;
    }
}


class GharzolHasane extends Account {
    public GharzolHasane(int money, int id) {
        this.iD = id;
        this.money = money;
        this.minMoney = money;
        this.sood = 12;
    }
}

class Bank {

    public Bank() {
        this.day = 0;
        accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> accounts;
    public int day;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void Deposit(int ID, int money) {
        for (int i = 0; i < getAccounts().size(); i++) {
            if (getAccounts().get(i).getID() == ID) {
                getAccounts().get(i).Deposit(money);
            }//شماره حساب میدی پول میدی میگرده پیدا میکنه پولو میریزه حساب
        }
    }

    public void withdraw(int ID, int money) {
        for (int i = 0; i < getAccounts().size(); i++) {
            if (getAccounts().get(i).getID() == ID) {
                try {
                    getAccounts().get(i).withdraw(money);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }//ایدی رو میگرده پیدا میکنه پول ازش کم میکنه
            }
        }
    }

    public void setDay(int day) {
        for (int i = 0; i < getAccounts().size(); i++) {
            getAccounts().get(i).Deposit(getAccounts().get(i).benefit(day - this.day));
        }
        this.day = day;
    }//روز بانکی سود

    public void createAccount(int ID, int money, String type) throws Exception {

        for (int i = 0; i < getAccounts().size(); i++) {
            if (getAccounts().get(i).getID() == ID)
                throw new Exception("این شماره حساب تکراری است");
        }


        switch (type) {
            case "Short":
                accounts.add(new ShortTerm(money, ID));
                break;
            case "Long":
                accounts.add(new LongTerm(money, ID));
                break;
            case "Current":
                accounts.add(new Current(money, ID));
                break;
            case "Gharz":
                accounts.add(new GharzolHasane(money, ID));
                break;
        }

    }

    public String showAccounts() {
        String temp = "";
        for (int i = 0; i < getAccounts().size(); i++) {
            temp += "id:" + getAccounts().get(i).getID() + " money:" + getAccounts().get(i).getBalance() + "\n";
        }
        return temp;
    }
}