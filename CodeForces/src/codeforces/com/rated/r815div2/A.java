package codeforces.com.rated.r815div2;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/18 21:33
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            long a = scan.nextInt();
            long b = scan.nextInt();
            long c = scan.nextInt();
            long d = scan.nextInt();
            if (a * d == c * b) {
                System.out.println("0");
            } else {
                if ((a * c == 0) || (c * b) % (a * d) == 0 || (a * d) % (c * b) == 0) {
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            }
        }
    }
}
