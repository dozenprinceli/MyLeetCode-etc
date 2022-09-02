package codeforces.com.rated.r818div2;

import java.util.Scanner;

/**
 * TODO WA
 * @author Dozen Lee<br/>
 * 2022/9/2 23:14
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            int[] ai = new int[n];
            int[] bi = new int[n];
            for (int j = 0; j < n; j++) {
                ai[j] = scan.nextInt();
            }
            int maxIdx = 0;
            for (int j = 0; j < n; j++) {
                bi[j] = scan.nextInt();
                if (bi[j] > bi[maxIdx]) {
                    maxIdx = j;
                }
            }
            boolean isLegal = true;
            int move = n - 1 - maxIdx;
            for (int idx = n - 1; idx >= 0; idx--) {
                int j = (idx - move + n) % n;
                int dif = bi[j] - ai[j];
                if (dif == 0) {
                    continue;
                }
                if (dif < 0 || (j != n - 1 && bi[j + 1] < bi[j] - 1) || (j == n - 1 && bi[1] < bi[j] - 1)) {
                    System.out.println("NO");
                    isLegal = false;
                    break;
                }
            }
            if (isLegal) {
                System.out.println("YES");
            }
        }
    }
}
