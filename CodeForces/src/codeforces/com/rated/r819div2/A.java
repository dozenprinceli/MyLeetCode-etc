package codeforces.com.rated.r819div2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/9/6 22:26
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int test = 0; test < testCases; test++) {
            int n = scan.nextInt();
            if (n == 1) {
                scan.nextInt();
                System.out.println(0);
                continue;
            }
            List<Integer> minLocs = new ArrayList<>();
            List<Integer> maxLocs = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int[] arr = new int[n];
            int ans = Integer.MIN_VALUE;
            int last = 0;
            for (int i = 0; i < n; i++) {
                int cur = scan.nextInt();
                if (i != 0) {
                    ans = Math.max(ans, last - cur);
                }
                arr[i] = cur;
                if (cur <= min) {
                    if (cur < min) {
                        min = cur;
                        minLocs.clear();
                    }
                    minLocs.add(i);
                }
                if (cur >= max) {
                    if (cur > max) {
                        max = cur;
                        maxLocs.clear();
                    }
                    maxLocs.add(i);
                }
                last = cur;
            }
            ans = Math.max(arr[n - 1] - arr[0], ans);
            boolean isEnd = false;
            for (int maxIdx : maxLocs) {
                if (maxIdx != n - 1 && arr[maxIdx + 1] == min || maxIdx == n - 1 && arr[0] == min) {
                    ans = max - min;
                    isEnd = true;
                    break;
                }
                if (maxIdx != n - 1) {
                    ans = Math.max(ans, max - arr[maxIdx + 1]);
                } else {
                    ans = Math.max(ans, max - arr[0]);
                }
            }
            ans = Math.max(ans, max - arr[0]);
            if (!isEnd) {
                for (int minIdx : minLocs) {
                    if (minIdx != 0) {
                        ans = Math.max(ans, arr[minIdx - 1] - min);
                    } else {
                        ans = Math.max(ans, arr[0] - min);
                    }
                }
            }
            ans = Math.max(ans, arr[n - 1] - min);
            System.out.println(ans);
        }
    }
}
