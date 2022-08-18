package codeforces.com.rated.r814div2;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/16 22:39
 */
public class A_ChipGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            if ((n + m) % 2 == 0) {
                System.out.println("Tonya");
            } else {
                System.out.println("Burenka");
            }
        }
    }
}
