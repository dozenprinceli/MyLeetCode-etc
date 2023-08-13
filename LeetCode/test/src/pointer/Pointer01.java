package pointer;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2023/8/13 14:19
 */
public class Pointer01 {
    @Test
    public void test680() {
        String testStr = "cupuuuupucu";
        System.out.println(validPalindrome(testStr));
    }

    private boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean flag = false;
        boolean can = true;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            if (flag) {
                can = false;
                break;
            }
            if (left + 1 == right) {
                return true;
            }
            if (s.charAt(left + 1) == s.charAt(right)) {
                flag = true;
                left += 2;
                right -= 1;
                continue;
            }
            if (s.charAt(left) == s.charAt(right - 1)) {
                flag = true;
                left += 1;
                right -= 2;
                continue;
            }
            can = false;
            break;
        }
        if (can) {
            return true;
        }

        left = 0;
        right = s.length() - 1;
        flag = false;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            if (flag) {
                return false;
            }
            if (left + 1 == right) {
                return true;
            }
            if (s.charAt(left) == s.charAt(right - 1)) {
                flag = true;
                left += 1;
                right -= 2;
                continue;
            }
            if (s.charAt(left + 1) == s.charAt(right)) {
                flag = true;
                left += 2;
                right -= 1;
                continue;
            }
            return false;
        }
        return true;
    }
}
