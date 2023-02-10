package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2023/2/10 17:34
 */
public class Dp02 {
    @Test
    public void test22() {
        int n = 4;
        System.out.println(generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        final String left = "(";
        final String right = ")";
        List<List<String>> dp = new ArrayList<>();
        List<String> init = new ArrayList<>();
        dp.add(init);
        init.add("()");
        while (dp.size() < n) {
            int curN = dp.size() + 1;
            List<String> curList = new ArrayList<>();
            dp.add(curList);
            for (int p = 0; p < curN; p++) {
                int q = curN - 1 - p;
                if (p == 0) {
                    for (int k = 0; k < q; k++) {
                        curList.add(left + right + dp.get(q - 1).get(k));
                    }
                } else if (q == 0) {
                    for (int j = 0; j < p; j++) {
                        curList.add(left + dp.get(p - 1).get(j) + right);
                    }
                } else {
                    for (int j = 0; j < p; j++) {
                        for (int k = 0; k < q; k++) {
                            curList.add(left + dp.get(p - 1).get(j) + right + dp.get(q - 1).get(k));
                        }
                    }
                }
            }
        }
        return dp.get(n - 1);
    }
}
