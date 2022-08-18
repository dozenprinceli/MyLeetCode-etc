package codeforces.com.rated.r815div2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/18 21:33
 */
public class D {
    // TODO
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }
            process(n, arr);
        }
    }

    private static void process(int n, int[] b) {
        int[] a = Arrays.copyOf(b, n);
        Arrays.sort(b);
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int curLength = 1;
            int curB = i;
            for (int j = i + 1; j < n; j++) {
                if ((a[curB] ^ j) < (a[j] ^ curB)) {
                    curLength++;
                    curB = j;
                }
            }
            maxLength = Math.max(maxLength, curLength);
        }
        System.out.println(maxLength);
    }
}
