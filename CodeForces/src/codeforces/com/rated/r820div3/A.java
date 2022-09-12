package codeforces.com.rated.r820div3;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/9/12 22:21
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int t = 0; t < testCases; t++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int time1 = a - 1;
            int time2 = Math.abs(b - c) + Math.abs(c - 1);
            if (time1 < time2) {
                System.out.println(1);
            } else if (time1 > time2) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
