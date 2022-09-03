package math;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/9/4 1:53
 */
public class Math03 {
    @Test
    public void testCombine() {
        System.out.println(combine(34, 6));
    }

    private int combine(int n, int m) {
        int ans = 1;
        for (int i = 0; i < m; i++) {
            ans *= n - i;
        }
        for (int i = 0; i < m; i++) {
            ans /= i + 1;
        }
        return ans;
    }
}
