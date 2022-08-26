package string;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 1:46
 */
public class String10 {
    @Test
    public void test481() {
        System.out.println(magicalString(7));
    }

    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }
        int cnt = 1;
        StringBuilder sb = new StringBuilder("122");
        int freqPtr = 2;
        boolean isOne = true;
        while (sb.length() < n) {
            int freq = sb.charAt(freqPtr) == '1' ? 1 : 2;
            char addChar = isOne ? '1' : '2';
            for (int i = 0; i < freq; i++) {
                sb.append(addChar);
            }
            cnt += isOne ? freq : 0;
            freqPtr++;
            isOne = !isOne;
        }
        if (sb.length() == n + 1 && sb.charAt(n) == '1') {
            cnt--;
        }
        return cnt;
    }
}
