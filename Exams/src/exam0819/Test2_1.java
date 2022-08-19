package exam0819;

/**
 * @author Dozen Lee<br/>
 * 2022/8/19 17:06
 */
public class Test2_1 {
    static class A {
        public int num;
    }

    public static void main(String[] args) {
        A[] a = new A[10];
        a[0] = new A();
        a[1] = new A();
        a[0].num = 1;
        a[1].num = 2;
        for (int i = 2; i < 10; ++i) {
            a[i] = new A();
            a[i].num = a[i - 1].num * a[i - 2].num;
        }
        System.out.print(a[9].num);
    }
}

