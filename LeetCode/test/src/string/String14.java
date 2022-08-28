package string;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/29 4:23
 */
public class String14 {
    @Test
    public void testStringFeatures() {
        String s1 = "abcefg";
        String s2 = "abc";
        System.out.println(s1.startsWith(s2));
        System.out.println(s2.substring(3).equals(""));
    }

    @Test
    public void test306() {
        String s1 = "111122335588143";
        String s2 = "101";
        String s3 = "000";
        String s4 = "121474836472147483648";
        System.out.println(isAdditiveNumber(s1));
        System.out.println(isAdditiveNumber(s2));
        System.out.println(isAdditiveNumber(s3));
        System.out.println(isAdditiveNumber(s4));
    }

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        // 遍历所有可能的cut1
        for (int cut1 = 1; cut1 < n / 2 + n % 2; cut1++) {
            // first含前导0, 否决
            if (num.startsWith("0") && cut1 > 1) {
                return false;
            }

            int cut2 = cut1 + 1;
            // 保证前两个数中的最大位数不超过剩余位数
            while (Math.max(cut1, cut2 - cut1) <= n - cut2) {
                // second含前导0, 否决
                if (num.charAt(cut1) == '0' && cut2 - cut1 != 1) {
                    break;
                }

                String cur = num.substring(cut2);
                int first = Integer.parseInt(num.substring(0, cut1));
                int second = Integer.parseInt(num.substring(cut1, cut2));
                boolean isFit = true;

                // 当后面还有数的时候往下遍历
                while (!cur.equals("")) {
                    int next = first + second;
                    if (cur.startsWith(String.valueOf(next))) {
                        first = second;
                        second = next;
                        cur = cur.substring(String.valueOf(next).length());
                    } else {
                        isFit = false;
                        break;
                    }
                }
                if (isFit) {
                    return true;
                }
                cut2++;
            }
        }
        return false;
    }
}
