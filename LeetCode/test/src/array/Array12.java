package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/10/6 23:32
 */
public class Array12 {
    @Test
    public void test927() {
        int[] arr = new int[]{1, 0, 1, 0, 1};
        System.out.println(Arrays.toString(threeEqualParts(arr)));
    }

    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        for (int p2 = n - 2; p2 > 0; p2--) {
            for (int p1 = p2 - 1; p1 >= 0; p1--) {
                if (equals(arr, p1, p2)) return new int[]{p1, p2 + 1};
            }
        }
        return new int[]{-1, -1};
    }

    private boolean equals(int[] arr, int p1, int p2) {
        int p3 = arr.length - 1;
        int s1 = p1, s2 = p2;
        while (p1 >= 0 && p2 > s1 && p3 > s2) {
            if (arr[p1] != arr[p2] || arr[p2] != arr[p3]) return false;
            p1--;
            p2--;
            p3--;
        }
        for (int i = 0; i <= p1; i++) {
            if (arr[i] != 0) return false;
        }
        for (int i = s1 + 1; i <= p2; i++) {
            if (arr[i] != 0) return false;
        }
        for (int i = s2 + 1; i <= p3; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}
