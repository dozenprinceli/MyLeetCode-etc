package weekly.c311;

/**
 * @author Dozen Lee<br/>
 * 2022/9/18 10:29
 */
public class A {
    public int smallestEvenMultiple(int n) {
        if ((n & 1) == 0) {
            return n;
        } else {
            return n << 1;
        }
    }
}
