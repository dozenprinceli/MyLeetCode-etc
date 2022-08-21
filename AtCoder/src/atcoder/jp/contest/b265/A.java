package atcoder.jp.contest.b265;

import java.util.Scanner;

/**
 * AC
 * @author Dozen Lee<br/>
 * 2022/8/21 19:57
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int X = scan.nextInt();
        int Y = scan.nextInt();
        int N = scan.nextInt();
        if (X * 3 <= Y) {
            System.out.println(N * X);
            return;
        }
        System.out.println(N / 3 * Y + N % 3 * X);
    }
}
