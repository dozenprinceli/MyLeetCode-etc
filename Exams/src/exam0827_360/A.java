package exam0827_360;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 15:05
 */
public class A {
    private static final List<Character> symmetricLetters = Arrays.asList('A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y');

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str = scan.next();
            boolean isLegalLetters = true;
            for (int i = 0; i < str.length(); i++) {
                if (!symmetricLetters.contains(str.charAt(i))) {
                    System.out.println("NO");
                    isLegalLetters = false;
                    break;
                }
            }
            if (!isLegalLetters) {
                continue;
            }
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    System.out.println("NO");
                    isLegalLetters = false;
                    break;
                }
                left++;
                right--;
            }
            if (isLegalLetters) {
                System.out.println("YES");
            }
        }
    }
}
