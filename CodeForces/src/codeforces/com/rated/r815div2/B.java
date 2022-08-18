package codeforces.com.rated.r815div2;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/18 21:33
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            int max = 0;
            int subMax = 0;
            int min = Integer.MAX_VALUE;
            int subMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int cur = scan.nextInt();
                if (cur >= max) {
                    subMax = max;
                    max = cur;
                }
                if (cur <= min) {
                    subMin = min;
                    min = cur;
                }
                if (max > cur && cur >= subMax) {
                    subMax = cur;
                }
                if (min < cur && cur <= subMin) {
                    subMin = cur;
                }
            }
            System.out.println(max + subMax - min - subMin);
        }
    }
}
