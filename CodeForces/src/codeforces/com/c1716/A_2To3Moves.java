package codeforces.com.c1716;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 1:26
 */
public class A_2To3Moves {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = scan.nextInt();
        for (int i = 0; i < lines; i++) {
            int n = scan.nextInt();
            if (n == 1) {
                System.out.println(2);
            } else if (n <= 3) {
                System.out.println(1);
            } else {
                int minute = n / 3;
                minute += (n % 3 == 0) ? 0 : 1;
                System.out.println(minute);
            }
        }
    }
}
