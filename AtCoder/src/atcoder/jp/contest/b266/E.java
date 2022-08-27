package atcoder.jp.contest.b266;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 19:59
 */
public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(getProbability(n));
    }

    private static double getProbability(int n) {
        if (n == 1) {
            return 3.5;
        }
        int biggerSum = 0;
        int biggerCnt = 0;
        double nextProbability = getProbability(n - 1);
        for (int i = 6; i > nextProbability; i--) {
            biggerSum += i;
            biggerCnt++;
        }
        return biggerSum / 6.0 + (6.0 - biggerCnt) / 6.0 * nextProbability;
    }
}
