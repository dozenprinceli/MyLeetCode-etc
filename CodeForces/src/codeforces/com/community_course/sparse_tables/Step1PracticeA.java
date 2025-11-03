package codeforces.com.community_course.sparse_tables;

import java.util.Scanner;

public class Step1PracticeA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextLong();
            }
            int q = sc.nextInt();
            int[][] queries = new int[q][2];
            for (int j = 0; j < q; j++) {
                queries[j][0] = sc.nextInt();
                queries[j][1] = sc.nextInt();
            }
            process(arr, queries);
        }
    }
    
    static void process(long[] arr, int[][] queries) {
        // S = sqrt(n) leads to O(sqrt(n))
        int n = arr.length;
        int sqrt = (int) Math.sqrt(arr.length);
        int size = n / sqrt + (n % sqrt == 0 ? 0 : 1);
        
        // preprocess [left, right, min]
        long[][] min = new long[size][3];
        for (int i = 0; i < size; i++) {
            long minVal = Long.MAX_VALUE;
            int left = i * sqrt;
            int right = Math.min(left + sqrt, arr.length);
            for (int j = left; j < right; j++) {
                minVal = Math.min(minVal, arr[j]);
            }
            min[i][0] = left;
            min[i][1] = right - 1;
            min[i][2] = minVal;
        }
        
        // find min value
        for (int[] q : queries) {
            int ql = q[0];
            int qr = q[1];
            long minVal = Long.MAX_VALUE;
            for (long[] interval : min) {
                long il = interval[0];
                long ir = interval[1];
                // not interacted, pass
                if (ir < ql || qr < il) continue;
                // fully cover interval, use saved minimum
                if (ql <= il && ir <= qr) {
                    minVal = Math.min(minVal, interval[2]);
                    continue;
                }
                // partially cover, compare each value
                int fl = (int) Math.max(il, ql);
                int fr = (int) Math.min(ir, qr);
                for (int i = fl; i <= fr ; i++) {
                    minVal = Math.min(minVal, arr[i]);
                }
            }
            System.out.println(minVal);
        }
    }
}
