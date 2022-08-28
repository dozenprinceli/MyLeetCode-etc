package string;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/28 3:57
 */
public class String12 {
    @Test
    public void test67() {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.min(a.length(), b.length());
        int add = 0;
        for (int i = 0; i < n; i++) {
            int curA = a.charAt(a.length() - i - 1) == '1' ? 1 : 0;
            int curB = b.charAt(b.length() - i - 1) == '1' ? 1 : 0;
            int cur = curA + curB + add;
            if (cur > 1) {
                add = 1;
            } else {
                add = 0;
            }
            sb.insert(0, cur % 2);
        }
        if (a.length() == b.length()) {
            if (add == 1) {
                sb.insert(0, 1);
            }
            return sb.toString();
        }
        String s = a.length() > b.length() ? a : b;
        for (int i = s.length() - n - 1; i >= 0; i--) {
            int cur = s.charAt(i) == '1' ? 1 : 0;
            cur += add;
            if (cur == 2) {
                add = 1;
            } else {
                add = 0;
            }
            sb.insert(0, cur % 2);
        }
        if (add == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
