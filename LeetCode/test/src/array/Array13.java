package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2023/2/13 21:18
 */
public class Array13 {
    @Test
    public void test1234() {
        String s = "QWER";
        System.out.println(balancedString(s));
    }

    public int balancedString(String s) {
        int[] cnt = new int[4];
        for (char c : s.toCharArray()) {
            cnt[getIdx(c)]++;
        }
        int max = s.length() / 4;
        int min = s.length();
        int l = 0, r = -1;
        while (true) {
            if (Arrays.stream(cnt).max().getAsInt() > max) {
                if (r == s.length() - 1) {
                    break;
                }
                cnt[getIdx(s.charAt(++r))]--;
                continue;
            }
            min = Math.min(min, r - l + 1);
            cnt[getIdx(s.charAt(l++))]++;
            if (l == s.length()) {
                break;
            }
        }
        return min;
    }

    int getIdx(char c) {
        if (c == 'Q') return 0;
        else if (c == 'W') return 1;
        else if (c == 'E') return 2;
        else if (c == 'R') return 3;
        return -1;
    }
}
