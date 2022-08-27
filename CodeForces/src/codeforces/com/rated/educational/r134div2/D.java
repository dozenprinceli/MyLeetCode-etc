package codeforces.com.rated.educational.r134div2;

import java.util.Scanner;

/**
 * TODO WA
 * @author Dozen Lee<br/>
 * 2022/8/27 22:34
 */
public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            int[] ai = new int[n];
            int[] bi = new int[n];
            for (int j = 0; j < n; j++) {
                ai[j] = scan.nextInt();
            }
            for (int j = 0; j < n; j++) {
                bi[j] = scan.nextInt();
            }
            int sum = ai[0] ^ bi[0];
            for (int j = 1; j < n; j++) {
                sum &= ai[j] ^ bi[j];
            }
            System.out.println(sum);
        }
    }
}
