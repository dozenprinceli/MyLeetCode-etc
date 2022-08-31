package math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/8/31 3:49
 */
public class Math02 {
    @Test
    public void test564() {
        String n = "123";
        System.out.println(nearestPalindromic(n));
    }

    public String nearestPalindromic(String s) {
        int n = s.length();
        List<Long> ansList = new ArrayList<>();
        ansList.add((long) Math.pow(10, n - 1) - 1);
        ansList.add((long) Math.pow(10, n) + 1);
        int isOdd = n % 2 == 0 ? 0 : 1;
        long half = Long.parseLong(s.substring(0, n / 2 + isOdd));
        ansList.add(get(half, isOdd));
        ansList.add(get(half - 1, isOdd));
        ansList.add(get(half + 1, isOdd));
        long dif = Long.MAX_VALUE;
        long cur = Long.parseLong(s);
        long ans = Long.MAX_VALUE;
        for (long num : ansList) {
            long curDif = Math.abs(num - cur);
            if (num != cur && curDif < dif) {
                dif = curDif;
                ans = num;
            } else if (curDif == dif && num < ans) {
                ans = num;
            }
        }
        return String.valueOf(ans);
    }

    private long get(long num, int isOdd) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        for (int i = sb.length() - 1 - isOdd; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}
