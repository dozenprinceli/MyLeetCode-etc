package codeforces.com.community_course.sparse_tables;

import java.util.Scanner;

public class Step1PracticeB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] cities = new int[n];
            for (int j = 0; j < n; j++) {
                cities[j] = sc.nextInt();
            }
            int[][] queries = new int[q][2];
            for (int j = 0; j < q; j++) {
                queries[j][0] = sc.nextInt() - 1;
                queries[j][1] = sc.nextInt() - 1;
            }
            process(cities, queries);
        }
    }
    
    static void process(int[] cities, int[][] queries) {
        // S = sqrt(n) leads to O(sqrt(n))
        int n = cities.length;
        int sqrt = (int) Math.sqrt(n);
        int size = n / sqrt + (n % sqrt == 0 ? 0 : 1);
        
        // preprocess [left, right, max]
        int[][] max = new int[size][3];
        for (int i = 0; i < size; i++) {
            int maxVal = 0;
            int left = i * sqrt;
            int right = Math.min(left + sqrt, cities.length);
            for (int j = left; j < right; j++) {
                maxVal = Math.max(maxVal, cities[j]);
            }
            max[i][0] = left;
            max[i][1] = right - 1;
            max[i][2] = maxVal;
        }
        
        // find max value
        int total = 0;
        for (int[] q : queries) {
            int ql = q[0] + 1;
            int qr = q[1] - 1;
            int tarH = cities[q[0]];
            
            // accepted if interval is empty
            if (ql > qr) {
                total++;
                continue;
            }
            if (ql == qr) {
                total += (cities[ql] <= tarH) ? 1 : 0;
                continue;
            }
            
            boolean flag = true;
            for (int[] m : max) {
                int ml = m[0];
                int mr = m[1];
                // not interacted, pass
                if (mr < ql || qr < ml) continue;
                // fully cover, use saved maximum
                if (ql <= ml && mr <= qr) {
                    if (m[2] > tarH) {
                        flag = false;
                        break;
                    }
                    continue;
                }
                // partially cover, compare each value
                int fl = Math.max(ql, ml);
                int fr = Math.min(qr, mr);
                for (int i = fl; i <= fr; i++) {
                    if (cities[i] > tarH) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }

            if (flag) total++;
        }
        System.out.println(total);
    }
}
