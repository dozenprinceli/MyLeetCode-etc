package codeforces.com.practice.c1712;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 22:44
 */
public class A_WonderfulPermutation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        for (int i = 0; i < times; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int curRes = 0;
            for (int j = 0; j < n; j++) {
                int num = scan.nextInt();
                if (j < k && num > k) {
                    curRes++;
                }
            }
            System.out.println(curRes);
        }
    }
}
