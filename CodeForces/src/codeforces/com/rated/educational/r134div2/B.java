package codeforces.com.rated.educational.r134div2;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 22:33
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int sX = scan.nextInt();
            int sY = scan.nextInt();
            int d = scan.nextInt();
            boolean up = sX - d <= 1;
            boolean down = sX + d >= n;
            boolean left = sY - d <= 1;
            boolean right = sY + d >= m;
            boolean judge1 = up & left;
            boolean judge2 = up & down;
            boolean judge3 = right & down;
            boolean judge4 = left & right;
            if (judge1 || judge2 || judge3 || judge4) {
                System.out.println(-1);
            } else {
                System.out.println(n + m - 2);
            }
        }
    }
}
