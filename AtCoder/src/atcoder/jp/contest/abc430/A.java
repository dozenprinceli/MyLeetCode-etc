package atcoder.jp.contest.abc430;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        if (C < A) System.out.println("No");
        else if (D < B) System.out.println("Yes");
        else System.out.println("No");
    }
}
