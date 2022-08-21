package string;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/22 6:08
 */
public class String03 {
    @Test
    public void test125() {
        String test = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(test));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!isLetter(s.charAt(left))) {
                left++;
            }
            while (!isLetter(s.charAt(right))) {
                right--;
            }
            if (left < right && !isEqualIgnoreCase(s.charAt(left), s.charAt(right))) {
                return false;
            }
        }
        return true;
    }

    private boolean isLetter(char c) {
        return 65 <= c && c <= 90 || 97 <= c && c <= 122;
    }

    private boolean isEqualIgnoreCase(char c1, char c2) {
        if (65 <= c1 && c1 <= 90) {
            return c1 == c2 || c1 + 32 == c2;
        }
        if (97 <= c1 && c1 <= 122) {
            return c1 == c2 || c1 - 32 == c2;
        }
        return false;
    }
}
