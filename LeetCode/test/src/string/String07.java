package string;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/26 3:25
 */
public class String07 {
    @Test
    public void testFormatString() {
        String s = "33222511";
        System.out.println(formatString(s));
    }

    private String formatString(String str) {
        if (str.equals("1")) {
            return "11";
        }
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        int curLength = 1;
        int ptr = 1;
        while (ptr < n + 1) {
            while (ptr < n && str.charAt(ptr) == str.charAt(ptr - 1)) {
                curLength++;
                ptr++;
            }
            sb.append(curLength).append(str.charAt(ptr - 1));
            ptr++;
            curLength = 1;
        }
        return sb.toString();
    }
}
