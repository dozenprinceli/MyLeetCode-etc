package atcoder.jp.contest.b265;

import java.util.Scanner;

/**
 * TODO WA/TLE
 * @author Dozen Lee<br/>
 * 2022/8/21 19:57
 */
public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        int q = scan.nextInt();
        int r = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i = 0; i < n - 2; i++) {
            int end = endIdx(arr, i, p);
            if (end != -1) {
                end = endIdx(arr, end + 1, q);
                if (end != -1) {
                    end = endIdx(arr, end + 1, r);
                    if (end != -1) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }

    private static int endIdx(int[] arr, int begin, int target) {
        if (begin > arr.length - 1) {
            return -1;
        }
        int sum = 0;
        for (int i = begin; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target) {
                return i;
            }
        }
        return -1;
    }
}
