package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/9/11 11:05
 */
public class Array07 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<Integer> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ansList.isEmpty()) {
                ansList.add(interval[1]);
                continue;
            }
            boolean hasGroup = false;
            for (int i = 0; i < ansList.size(); i++) {
                int curEnd = ansList.get(i);
                if (curEnd < interval[0]) {
                    hasGroup = true;
                    ansList.set(i, interval[1]);
                    break;
                }
            }
            if (!hasGroup) {
                ansList.add(interval[1]);
            }
        }
        return ansList.size();
    }

    @Test
    public void test() {
        int[][] test = new int[][]{
                {5, 10},
                {6, 8},
                {1, 5},
                {2, 3},
                {1, 10}
        };
        System.out.println(minGroups(test));
    }
}
