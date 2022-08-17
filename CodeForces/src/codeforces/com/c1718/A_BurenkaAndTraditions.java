package codeforces.com.c1718;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/17 23:40
 */
public class A_BurenkaAndTraditions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }
            process(arr, n);
        }
    }

    private static void process(int[] arr, int n) {
        Map<Integer, Boolean> xorMap = new HashMap<Integer, Boolean>();
        int ans = n;
        int curXor = 0;
        xorMap.put(0, true);
        for (int i = 0; i < n; i++) {
            curXor ^= arr[i];
            if (xorMap.containsKey(curXor)) {
                ans--;
                xorMap.clear();
            }
            xorMap.put(curXor, true);
        }
        System.out.println(ans);
    }
}
