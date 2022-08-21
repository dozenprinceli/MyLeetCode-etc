package atcoder.jp.contest.r146;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 20:01
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        List<List<Integer>> nums = new ArrayList<>(6);
        List<Integer> digit1 = new ArrayList<>();
        List<Integer> digit2 = new ArrayList<>();
        List<Integer> digit3 = new ArrayList<>();
        List<Integer> digit4 = new ArrayList<>();
        List<Integer> digit5 = new ArrayList<>();
        List<Integer> digit6 = new ArrayList<>();
        nums.add(digit1);
        nums.add(digit2);
        nums.add(digit3);
        nums.add(digit4);
        nums.add(digit5);
        nums.add(digit6);
        int pow = 10;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] / pow == 0) {
                nums.get(idx).add(arr[i]);
            } else {
                pow *= 10;
                i--;
                idx++;
            }
        }

        List<Integer> maxDigit = null;
        idx = 0;
        for (int i = 5; i >= 0; i--) {
            if (nums.get(i).size() != 0) {
                maxDigit = nums.get(i);
                idx = i;
                break;
            }
        }
        assert maxDigit != null;
        int size = maxDigit.size();
        if (size >= 3) {
            System.out.println("" + maxDigit.get(size - 1) + maxDigit.get(size - 2) + maxDigit.get(size - 3));
            return;
        }

        List<Integer> subMaxDigit = null;
        for (int i = idx - 1; i >= 0; i--) {
            if (nums.get(i).size() != 0) {
                subMaxDigit = nums.get(i);
                idx = i;
                break;
            }
        }
        assert subMaxDigit != null;
        if (size == 2) {
            int d1 = maxDigit.get(0);
            int d2 = maxDigit.get(1);
            int d3 = subMaxDigit.get(subMaxDigit.size() - 1);
            printBiggest(d1, d2, d3);
            return;
        }

        size = subMaxDigit.size();
        if (size >= 2) {
            int d1 = maxDigit.get(0);
            int d2 = subMaxDigit.get(size - 1);
            int d3 = subMaxDigit.get(size - 2);
            printBiggest(d1, d2, d3);
            return;
        }

        int d1 = maxDigit.get(0);
        int d2 = subMaxDigit.get(size - 1);
        int d3 = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if (nums.get(i).size() != 0) {
                d3 = nums.get(i).get(nums.get(i).size() - 1);
                break;
            }
        }
        printBiggest(d1, d2, d3);
    }

    private static void printBiggest(int d1, int d2, int d3) {
        int[] digits = new int[]{d1, d2, d3};
        long max = 0;
        String s = "" + d1 + d2 + d3;
        long cur = Long.parseLong(s);
        max = Math.max(cur, max);
        s = "" + d1 + d3 + d2;
        cur = Long.parseLong(s);
        max = Math.max(cur, max);
        s = "" + d2 + d1 + d3;
        cur = Long.parseLong(s);
        max = Math.max(cur, max);
        s = "" + d2 + d3 + d1;
        cur = Long.parseLong(s);
        max = Math.max(cur, max);
        s = "" + d3 + d1 + d2;
        cur = Long.parseLong(s);
        max = Math.max(cur, max);
        s = "" + d3 + d2 + d1;
        cur = Long.parseLong(s);
        max = Math.max(cur, max);
        System.out.println(max);
    }
}
