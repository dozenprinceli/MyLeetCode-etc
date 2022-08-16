package codeforces.com.c1719;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/16 22:42
 */
public class B_MathematicalCircus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            process(n, k);
        }
    }

    private static void process(int n, int k) {
        if (k == 0) {
            System.out.println("NO");
            return;
        }
        if (k % 2 == 1) {
            System.out.println("YES");
            for (int i = 1; i <= n - 1; i += 2) {
                String s = "" + i + " " + (i + 1);
                System.out.println(s);
            }
        } else {
            if (k % 4 == 0) {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            for (int i = 4; i <= n; i += 4) {
                String s = "" + (i - 1) + " " + i;
                System.out.println(s);
            }
            for (int i = 2; i <= n; i += 4) {
                String s = "" + i + " " + (i - 1);
                System.out.println(s);
            }
        }
    }
}
