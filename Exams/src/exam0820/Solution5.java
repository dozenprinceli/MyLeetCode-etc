package exam0820;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 11:11
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] b = new int[n];
        int[] a = new int[m];
        for (int i = 0; i < n; i++) {
            b[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int minWeight = 0;
        int curJ = 0;
        for (int i = 0; i < n; i++) {
            int curNeed = b[i];
            if (a[m - 1] < curNeed) {
                System.out.println(-1);
                return;
            }
            for (int j = curJ; j < m; j++) {
                if (a[j] >= curNeed) {
                    minWeight += a[j];
                    curJ = j;
                    break;
                }
            }
        }
        System.out.println(minWeight);
    }
}
