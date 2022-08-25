package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/8/26 2:48
 */
public class String06 {
    @Test
    public void testParseInt() {
        String s = "+4";
        System.out.println(Integer.parseInt(s));
    }

    @Test
    public void testParseFracString() {
        String s = "-1/6-3/5+2/5-3/5+101/891";
        for (int[] frac : parseFracString(s)) {
            System.out.println(Arrays.toString(frac));
        }
    }

    @Test
    public void test592() {
        System.out.println(fractionAddition("-1/2+1/2"));
    }

    public String fractionAddition(String expression) {
        List<int[]> fracList = parseFracString(expression);
        int[] ans = new int[2];
        ans[0] = 0;
        ans[1] = 1;
        for (int[] frac : fracList) {
            ans = calcFrac(ans, frac);
        }
        return ans[0] + "/" + ans[1];
    }

    private List<int[]> parseFracString(String expression) {
        int n = expression.length();
        List<int[]> returnList = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < n) {
            int[] curFrac = new int[2];
            returnList.add(curFrac);
            while (expression.charAt(right) != '/') {
                right++;
            }
            curFrac[0] = Integer.parseInt(expression.substring(left, right));
            left = right + 1;
            right = left;
            while (right < n && expression.charAt(right) != '+' && expression.charAt(right) != '-') {
                right++;
            }
            curFrac[1] = Integer.parseInt(expression.substring(left, right));
            left = right;
        }
        return returnList;
    }

    private int[] calcFrac(int[] frac1, int[] frac2) {
        int deno1 = frac1[0];
        int deno2 = frac2[0];
        int numer1 = frac1[1];
        int numer2 = frac2[1];

        int lcm = lcm(numer1, numer2);
        int newDeno = lcm / numer1 * deno1 + lcm / numer2 * deno2;
        int newGcd = gcd(Math.abs(newDeno), lcm);

        int[] ans = new int[2];
        ans[0] = newDeno / newGcd;
        ans[1] = lcm / newGcd;
        return ans;
    }

    private int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0) {
            return 1;
        }
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, (num1 % num2));
    }
}
