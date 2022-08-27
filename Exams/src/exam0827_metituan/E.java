package exam0827_metituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 15:49
 */
public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int t = scan.nextInt();
        int[] ti = new int[k];
        for (int i = 0; i < k; i++) {
            ti[i] = scan.nextInt();
        }
        int[] ei = new int[n];
        for (int i = 0; i < n; i++) {
            ei[i] = scan.nextInt();
        }

        int cnt = 0;
        List<Integer> curK = new ArrayList<>();
        for (int e : ei) {
            if (e == 0) {
                if (curK.isEmpty()) {
                    cnt += t;
                } else {
                    cnt += curK.remove(0);
                }
            } else {
                if (ti[e - 1] < t) {
                    insert(curK, ti[e - 1]);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void insert(List<Integer> curK, int i) {
        if (curK.isEmpty()) {
            curK.add(i);
            return;
        }
        if (curK.get(0) >= i) {
            curK.add(0, i);
            return;
        }
        if (curK.get(curK.size() - 1) <= i) {
            curK.add(curK.size(), i);
            return;
        }
        int left = 0;
        int right = curK.size() - 1;
        while (left < right - 1) {
            int mid = (left + right) >> 1;
            int midNum = curK.get(mid);
            if (midNum == i) {
                curK.add(mid, i);
                return;
            } else if (midNum > i) {
                right = mid;
            } else {
                left = mid;
            }
        }
        curK.add(right, i);
    }
}
