package atcoder.jp.contest.b266;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 19:59
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong();
        long MOD = 998_244_353;
        if (N >= 0) {
            System.out.println(N % MOD);
        } else {
            if (N % MOD == 0) {
                System.out.println(0);
                return;
            }
            System.out.println(MOD - (Math.abs(N) % MOD));
        }
    }
}
