package string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/8/26 3:47
 */
public class String08 {
    @Test
    public void test443() {
        char[] test = "abbbbbbbbbbbb".toCharArray();
        System.out.println(compress(test));
    }

    @Test
    public void testSplitDigits() {
        System.out.println(Arrays.toString(splitDigits(12)));
    }

    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int ptr = 1;
        int curLength = 1;
        int cur = 0;
        while (ptr < chars.length + 1) {
            if (ptr == chars.length) {
                chars[cur] = chars[ptr - 1];
                cur++;
                if (curLength != 1) {
                    char[] curDigits = splitDigits(curLength);
                    System.arraycopy(curDigits, 0, chars, cur, curDigits.length);
                    cur += curDigits.length;
                }
            } else if (chars[ptr] != chars[ptr - 1]) {
                chars[cur] = chars[ptr - 1];
                cur++;
                if (curLength != 1) {
                    char[] curDigits = splitDigits(curLength);
                    System.arraycopy(curDigits, 0, chars, cur, curDigits.length);
                    cur += curDigits.length;
                    curLength = 1;
                }
            } else {
                curLength++;
            }
            ptr++;
        }
        return cur;
    }

    private char[] splitDigits(int num) {
        return String.valueOf(num).toCharArray();
    }
}
