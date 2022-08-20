package exam0820;

import org.junit.Test;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 11:06
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        List<Integer> ai = new ArrayList<>();
        List<Integer> bi = new ArrayList<>();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            int cur = scan.nextInt();
            a[i] = cur;
            ai.add(cur);
        }
        for (int i = 0; i < m; i++) {
            int cur = scan.nextInt();
            b[i] = cur;
            bi.add(cur);
        }
        if (n == m) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.abs(a[i] - b[i]);
            }
            System.out.println(sum);
        } else if (n > m) {
            int minus = n - m;
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < minus; i++) {
                lists = helper(lists, n, minus);
            }
            int min = Integer.MAX_VALUE;
            for (List<Integer> list : lists) {
                int sum = 0;
                for (int i = minus - 1; i >= 0; i--) {
                    sum += ai.get(list.get(i));
                    ai.remove(list.get(i));
                }
                for (int i = 0; i < m; i++) {
                    sum += Math.abs(ai.get(i) - bi.get(i));
                }
                min = Math.min(min, sum);
            }
            System.out.println(min);
        } else {
            int minus = m - n;
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < minus; i++) {
                lists = helper(lists, m, minus);
            }
            int min = Integer.MAX_VALUE;
            for (List<Integer> list : lists) {
                int sum = 0;
                for (int i = minus - 1; i >= 0; i--) {
                    sum += bi.get(list.get(i));
                    bi.remove(list.get(i));
                }
                for (int i = 0; i < n; i++) {
                    sum += Math.abs(ai.get(i) - bi.get(i));
                }
                min = Math.min(min, sum);
            }
            System.out.println(min);
        }
    }

    private static List<List<Integer>> helper(List<List<Integer>> cur, int n, int maxSize) {
        if (cur.size() != 0 && cur.get(0).size() == maxSize) {
            return cur;
        }
        if (cur.size() == 0) {
            for (int i = 0; i < n - maxSize + 1; i++) {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                cur.add(newList);
            }
            return cur;
        }
        List<List<Integer>> newLists = new ArrayList<>();
        for (List<Integer> oldList : cur) {
            int size = oldList.size();
            for (int i = oldList.get(size - 1) + 1; i < n - maxSize + size + 1; i++) {
                List<Integer> newList = new ArrayList<>(oldList);
                newList.add(i);
                newLists.add(newList);
            }
        }
        return newLists;
    }
}
