package contest.weekly.c310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/9/11 10:29
 */
public class D {
    public int lengthOfLIS(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }
        int n = nums.length;
        List<int[]> nextList = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int curLen = 0;
            for (int[] next : nextList) {
                if (next[0] <= nums[i]) {
                    continue;
                }
                if (next[0] > nums[i] + k) {
                    break;
                }
                curLen = Math.max(curLen, next[1] + 1);
            }
            insert(nextList, nums[i], curLen == 0 ? 1 : curLen);
        }
        int ans = 1;
        for (int[] ints : nextList) {
            ans = Math.max(ans, ints[1]);
        }
        return ans;
    }

    private void insert(List<int[]> list, int num, int len) {
        if (list.isEmpty() || list.get(list.size() - 1)[0] <= num) {
            list.add(new int[]{num, len});
            return;
        }
        if (list.get(0)[0] >= num) {
            list.add(0, new int[]{num, len});
            return;
        }
        int left = 0, right = list.size() - 1;
        while (left < right - 1) {
            int mid = (left + right) >> 1;
            int midNum = list.get(mid)[0];
            if (midNum == num) {
                list.add(mid, new int[]{num, len});
                return;
            }
            if (midNum < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        list.add(right, new int[]{num, len});
    }
}
