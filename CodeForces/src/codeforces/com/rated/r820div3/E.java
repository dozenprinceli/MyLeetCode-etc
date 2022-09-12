package codeforces.com.rated.r820div3;

import java.util.Scanner;

/**
 * TODO WA
 * @author Dozen Lee<br/>
 * 2022/9/12 22:21
 */
public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long left = 1;
        long right = (long) 1e18;
        while (left < right - 1) {
            long mid = (left + right) >> 1;
            System.out.println("? 1 " + mid);
            long ans = scan.nextLong();
            if (ans == -1) {
                right = mid;
            } else {
                if (ans > mid) {
                    left = ans;
                } else {
                    left = mid;
                }
            }
            System.out.flush();
        }
        System.out.println("! " + left);
    }
}
