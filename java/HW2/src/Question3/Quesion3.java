package Question3;

public class Quesion3 {
    public static void main(String[] args) {
        A[] elements = {new D(), new A(), new C(), new B()};
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i].method1());
            System.out.println(elements[i].method2());
            System.out.println();
        }
    }
}

class A {
    public String method1() {
        if (getClass().getSimpleName().contains("B")){
            return "A1";
        }
        return getClass().getSimpleName()+"1";
    }
    public String method2() {
            if (getClass().getSimpleName().contains("A")){
                return "A2";
            }else if (getClass().getSimpleName().contains("B")){
                return "A1B2";
            }
            return getClass().getSimpleName() + "1B2";
    }


}

class B extends A {

//    @Override
//    public String method2() {
//        return method1() + "B2";
//    }


}

class C extends A {

//    @Override
//    public String method2() {
//        return method1() + "B2";
//    }

}
class D extends A {

    }
//    @Override
//    public String method2() {
//        return method1() + "B2";
//    }

