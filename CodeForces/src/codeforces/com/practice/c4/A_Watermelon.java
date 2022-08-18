package codeforces.com.practice.c4;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/6 21:35
 */
public class A_Watermelon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        if (w > 2 && w % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
