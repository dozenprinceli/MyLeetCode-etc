package leetcode.editor.cn.week.contest.c305;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dozen Lee<br/>
 * 2022/8/7 10:53
 */
public class Solution1 {
    public int arithmeticTriplets(int[] nums, int diff) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int res = 0;
        for (int i = 0; i < numList.size() - 2; i++) {
            int num = numList.get(i);
            if (numList.contains(num + diff) && numList.contains(num + 2 * diff)) {
                res++;
            }
        }
        return res;
    }
}
