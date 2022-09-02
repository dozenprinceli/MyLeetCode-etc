package codeforces.com.rated.r818div2;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/9/2 22:49
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int r = scan.nextInt() - 1;
            int c = scan.nextInt() - 1;
            for (int row = 0; row < n; row++) {
                int idx = r + c - row;
                for (int col = 0; col < n; col++) {
                    if ((col - idx) % k == 0) {
                        System.out.print('X');
                    } else {
                        System.out.print('.');
                    }
                }
                System.out.println();
            }
        }
    }
}
