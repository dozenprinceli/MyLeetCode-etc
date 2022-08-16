package codeforces.com.c1719;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/16 22:54
 */
public class C_FightingTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scan.nextInt();
            int q = scan.nextInt();
            int[] participants = new int[n];
            for (int j = 0; j < n; j++) {
                participants[j] = scan.nextInt();
            }
            for (int j = 0; j < q; j++) {
                int i = scan.nextInt();
                int k = scan.nextInt();
                process(participants, i, k);
            }
        }
    }

    private static void process(int[] participants, int i, int k) {
        if (k <= i - 2) {
            System.out.println(0);
            return;
        }
        int curStrength = participants[i - 1];
        // 检查前i-1个
        for (int tmp = 0; tmp < i - 1; tmp++) {
            if (participants[tmp] > curStrength) {
                System.out.println(0);
                return;
            }
        }
        // 从第i+1个往后遍历找到第一个更大的
        for (int tmp = i; tmp < Math.min(participants.length, k + 1); tmp++) {
            if (participants[tmp] > curStrength) {
                int add = i == 1 ? 0 : 1;
                System.out.println(tmp - i + add);
                return;
            }
        }
        int add = i == 1 ? 1 : 2;
        System.out.println(k - i + add);
    }
}
