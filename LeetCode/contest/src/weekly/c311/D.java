package weekly.c311;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO TLE
 * @author Dozen Lee<br/>
 * 2022/9/18 10:29
 */
public class D {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] += words[i].length();
            for (int j = i + 1; j < n; j++) {
                int score = getScore(words[i], words[j]);
                ans[i] += score;
                ans[j] += score;
            }
        }
        return ans;
    }

    private int getScore(String s1, String s2) {
        boolean judge = s1.length() <= s2.length();
        String shorter = judge ? s1 : s2;
        String longer = judge ? s2 : s1;
        int ans = 0;
        int p = 0;
        while (p < shorter.length()) {
            if (shorter.charAt(p) == longer.charAt(p)) {
                ans++;
                p++;
            } else {
                break;
            }
        }
        return ans;
    }
}