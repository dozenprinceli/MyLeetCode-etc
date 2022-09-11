package contest.weekly.c310;

import org.junit.Test;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/9/11 10:29
 */
public class C {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<Integer> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ansList.isEmpty()) {
                ansList.add(interval[1]);
                continue;
            }
            if (ansList.get(0) < interval[0]) {
                ansList.remove(0);
            }
            insert(ansList, interval[1]);
        }
        return ansList.size();
    }

    private void insert(List<Integer> list, int num) {
        if (list.isEmpty() || list.get(list.size() - 1) <= num) {
            list.add(num);
            return;
        }
        if (list.get(0) >= num) {
            list.add(0, num);
            return;
        }
        int left = 0, right = list.size() - 1;
        while (left < right - 1) {
            int mid = (left + right) >> 1;
            int midNum = list.get(mid);
            if (midNum == num) {
                list.add(mid, num);
                return;
            }
            if (midNum < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        list.add(right, num);
    }
}
