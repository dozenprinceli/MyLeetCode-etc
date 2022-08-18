package matrix;

import org.junit.Test;

import java.util.Random;

/**
 * @author Dozen Lee<br/>
 * 2022/8/18 22:25
 */
public class Matrix01 {
    @Test
    public void test1() {
        Random rand = new Random();
        int n = 5;
        int m = 5;
        System.out.println(n + " " + m);
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < m; j++) {
                s.append(rand.nextInt(2));
            }
            System.out.println(s);
        }
    }
}
