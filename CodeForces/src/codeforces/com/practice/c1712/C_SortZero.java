package codeforces.com.practice.c1712;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 22:59
 */
public class C_SortZero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        for (int i = 0; i < times; i++) {
            int length = scan.nextInt();
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                arr[j] = scan.nextInt();
            }
            System.out.println(getAns(arr));
        }
    }

    private static int getAns(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        Map<Integer, Integer> hasNums = new HashMap<Integer, Integer>();
        int p = arr.length - 1;
        while (p > 0) {
            if (arr[p] < arr[p - 1]) {
                break;
            }
            p--;
        }
        for (int i = 0; i < p; i++) {
            hasNums.put(arr[i], 1);
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = arr.length - 1; i >= p; i--) {
                if (hasNums.containsKey(arr[i])) {
                    flag = true;
                    for (int j = p; j < i; j++) {
                        hasNums.put(arr[j], 1);
                    }
                    p = i + 1;
                }
            }
        }
        return hasNums.keySet().size();
    }
}
