package codeforces.com.rated.r818div2;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/9/2 22:46
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            System.out.println(n + n / 2 * 2 + n / 3 * 2);
        }
    }
}
