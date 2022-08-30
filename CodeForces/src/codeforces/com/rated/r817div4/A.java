package codeforces.com.rated.r817div4;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/8/30 22:21
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int len = scan.nextInt();
            String name = scan.next();
            if (len != 5) {
                System.out.println("NO");
                continue;
            }

            Set<Character> charSet = new HashSet<>();
            charSet.add('T');
            charSet.add('i');
            charSet.add('m');
            charSet.add('u');
            charSet.add('r');

            boolean isLegal = true;
            for (char c : name.toCharArray()) {
                if (!charSet.contains(c)) {
                    System.out.println("NO");
                    isLegal = false;
                    break;
                } else {
                    charSet.remove(c);
                }
            }
            if (isLegal) {
                System.out.println("YES");
            }
        }
    }
}
