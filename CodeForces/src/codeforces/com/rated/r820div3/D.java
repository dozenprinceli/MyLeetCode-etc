package codeforces.com.rated.r820div3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/9/12 22:21
 */
public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scan.nextInt();
            int[] dif = new int[n];
            for (int i = 0; i < n; i++) {
                dif[i] = scan.nextInt();
            }
            for (int i = 0; i < n; i++) {
                dif[i] = scan.nextInt() - dif[i];
            }
            Arrays.sort(dif);
            int left = 0, right = n - 1;
            int ans = 0;
            while (dif[right] >= 0) {
                while (dif[left] < -dif[right] && left < right) {
                    left++;
                }
                if (left >= right) {
                    break;
                } else {
                    ans++;
                    left++;
                    right--;
                }
            }
            System.out.println(ans);
        }
    }
}
