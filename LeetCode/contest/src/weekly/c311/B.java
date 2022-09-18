package weekly.c311;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/9/18 10:29
 */
public class B {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        boolean isStart = false;
        int cur = 0;
        int curLen = 1;
        for (int i = 0; i < s.length(); i++) {
            if (!isStart && i != s.length() - 1 && s.charAt(i) + 1 == s.charAt(i + 1)) {
                isStart = true;
                cur = s.charAt(i);
            } else if (isStart) {
                if (s.charAt(i) == cur + 1) {
                    curLen++;
                    cur++;
                } else {
                    ans = Math.max(ans, curLen);
                    curLen = 1;
                    isStart = false;
                    i--;
                }
            }
        }
        return Math.max(ans, curLen);
    }

    @Test
    public void test() {
        String s = "nkvexzqgctjxwqnzneuvtuvyvrmhfbawyabanxadvlzllpwnanjxyjhhzzjokcszjeooitnvadkuzsnklxriwo";
        System.out.println(longestContinuousSubstring(s));
    }
}
