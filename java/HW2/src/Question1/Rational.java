package Question1;

public class Rational {
    private int num;
    private int den;

    // create and initialize a new Rational object
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Denominator is zero");
        }
        int g = gcd(numerator, denominator);
        num = numerator / g;
        den = denominator / g;

    }

    public Rational(){
        num = 0;
        den = 1;
    }

    // return string representation of (this)
    public String toString() {
        if (den == 1) return num + "";
        else return num + "/" + den;
    }

    // return (this * b)
    public Rational mul(Rational b) {
        return new Rational(this.num * b.num, this.den * b.den);
    }


    // return (this + b)
    public Rational add(Rational b) {
        int numerator = (this.num * b.den) + (this.den * b.num);
        int denominator = this.den * b.den;
        return new Rational(numerator, denominator);
    }

    // return (this - b)
    public Rational sub(Rational b) {
        int numerator = (this.num * b.den) - (this.den * b.num);
        int denominator = this.den * b.den;
        return new Rational(numerator, denominator);
    }

    // return (1 / this)
    public Rational reciprocal() {
        return new Rational(den, num);
    }

    // return (this / b)
    public Rational div(Rational b) {
        return this.mul(b.reciprocal());
    }

    public double toFloatingPoint (){
        return (double)num / (double)den;
    }

    public String toMakhlotString(){
        int mod = num % den;
        int sah = num / den;
        if(sah == 0){
            return mod + " / " + den;
        } else {
            return sah + " + " + mod + " / " + den;
        }
    }



    // return gcd(m, n)
    private static int gcd(int m, int n) {
        if (0 == n) return m;
        else return gcd(n, m % n);
    }



    public static void main(String[] args) {
        Rational a = new Rational();
        System.out.println(a.toString());
        Rational b = new Rational(1,9);
        System.out.println(b.toString());
        System.out.println(b.toMakhlotString());
        System.out.println(b.toFloatingPoint());
        Rational c = new Rational(5,2);
        System.out.println(c.toString());
        System.out.println(c.toMakhlotString());
        System.out.println(c.toFloatingPoint());
        System.out.println(c.add(b).toString());
        System.out.println(c.sub(b).toString());
        System.out.println(c.div(b).toString());
        System.out.println(c.mul(b).toString());
    }
}
