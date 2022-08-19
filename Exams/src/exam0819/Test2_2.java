package exam0819;

/**
 * @author Dozen Lee<br/>
 * 2022/8/19 17:19
 */
public class Test2_2 {
    public static void main(String[] args) {
        int i = 1_0000_0000;
        int base = 16141;
        int cur = base;
        while (cur < i) {
            System.out.println(cur);
            cur += base;
        }
    }
}
