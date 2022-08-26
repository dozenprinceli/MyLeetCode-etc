package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 5:14
 */
public class String11 {
    @Test
    public void test522() {
        String[] strs = new String[]{"aabbcc", "aabbcc", "bc", "bcc", "aabbccc"};
        System.out.println(findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            boolean isSub = true;
            for (int j = i + 1; j < strs.length; j++) {
                isSub = false;
                if (isSubsequence(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                max = strs[i].length();
            }
        }
        return max == 0 ? -1 : max;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        int tPtr = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            boolean hasLetter = false;
            while (tPtr < t.length()) {
                if (t.charAt(tPtr) == curChar) {
                    hasLetter = true;
                    tPtr++;
                    break;
                }
                tPtr++;
            }
            if (!hasLetter) {
                return false;
            }
        }
        return true;
    }
}
