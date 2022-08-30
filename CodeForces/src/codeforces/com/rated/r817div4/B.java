package codeforces.com.rated.r817div4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/30 22:21
 */
public class B {
    public static void main(String[] args) {
        List<Character> greenAndBlue = Arrays.asList('G', 'B');
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            String row1 = scan.next();
            String row2 = scan.next();

            boolean isLegal = true;
            for (int j = 0; j < n; j++) {
                if (greenAndBlue.contains(row1.charAt(j))) {
                    if (row2.charAt(j) == 'R') {
                        System.out.println("NO");
                        isLegal = false;
                        break;
                    }
                } else {
                    if (row2.charAt(j) != 'R') {
                        System.out.println("NO");
                        isLegal = false;
                        break;
                    }
                }
            }
            if (isLegal) {
                System.out.println("YES");
            }
        }
    }
}
