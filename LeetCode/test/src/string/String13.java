package string;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/29 3:47
 */
public class String13 {
    @Test
    public void testOneDigitMulti() {
        char c = '9';
        String num = "2342974193242325";
        System.out.println(multiByOneDigit(c, num));
        System.out.println(Long.parseLong(String.valueOf(c)) * Long.parseLong(num));
    }

    private String multiByOneDigit(char oneDigit, String num) {
        int digit = oneDigit - '0';
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            int cur = num.charAt(i) - '0';
            int res = cur * digit + carry;
            sb.append(res % 10);
            carry = res / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
