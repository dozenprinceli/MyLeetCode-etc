package string;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/26 23:52
 */
public class String09 {
    @Test
    public void test273() {
        int num = 1_234_567_891;
        System.out.println(numberToWords(num));
    }

    private final String[] numStrArr = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] digit2StrArr = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] tenthStrArr = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder ans = new StringBuilder();
        int[] digitsBy3 = new int[]{num / 1_000_000_000, num / 1_000_000 % 1_000, num / 1_000 % 1_000, num % 1000};
        String[] digitsBy3Strs = new String[]{"Billion", "Million", "Thousand", ""};
        for (int i = 0; i < 4; i++) {
            if (digitsBy3[i] != 0) {
                ans.append(get3DigitStr(digitsBy3[i])).append(" ").append(digitsBy3Strs[i]).append(" ");
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        if (ans.charAt(ans.length() - 1) == ' ') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }

    private String get3DigitStr(int num) {
        StringBuilder ans = new StringBuilder();
        int hundred = num / 100;
        int ten = num / 10 % 10;
        int one = num % 10;
        if (hundred != 0) {
            ans.append(numStrArr[hundred]).append(" Hundred ");
        }
        if (ten != 0) {
            if (ten == 1) {
                ans.append(tenthStrArr[one]).append(" ");
                one = 0;
            } else {
                ans.append(digit2StrArr[ten]).append(" ");
            }
        }
        if (one != 0) {
            ans.append(numStrArr[one]).append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
