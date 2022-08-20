package contest.biweekly.c85;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 22:29
 */
public class Solution4 {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<int[], Long> diffs = new HashMap<>();
        List<int[]> locations = new ArrayList<>();
        int[] lastLoc = null;
        for (int i = 0; i < n; i++) {
            int idx = removeQueries[i];
            nums[idx] = 0;
            // 特判
            if (diffs.size() == 0) {
                long sum1 = getSum(nums, 0, idx - 1);
                long sum2 = getSum(nums, idx + 1, n - 1);
                    int[] loc1 = new int[]{0, idx - 1};
                    int[] loc2 = new int[]{idx + 1, n - 1};
                if (sum1 != 0) {
                    diffs.put(loc1, sum1);
                    locations.add(loc1);
                }
                if (sum2 != 0) {
                    diffs.put(loc2, sum2);
                    locations.add(loc2);
                }
                ans[0] = Math.max(sum1, sum2);
                lastLoc = sum1 > sum2 ? loc1 : loc2;
                continue;
            }
            for (int j = 0; j < locations.size(); j++) {
                int[] curLoc = locations.get(j);
                if (curLoc[0] < idx && curLoc[1] > idx) {
                    locations.remove(j);
                    int[] leftLoc = new int[]{curLoc[0], idx - 1};
                    int[] rightLoc = new int[]{idx + 1, curLoc[1]};
                    long leftSum = getSum(nums, curLoc[0], idx - 1);
                    long rightSum = diffs.remove(curLoc) - leftSum;
                    if (leftSum != 0) {
                        diffs.put(leftLoc, leftSum);
                        locations.add(j, leftLoc);
                    }
                    if (rightSum != 0) {
                        diffs.put(rightLoc, rightSum);
                        locations.add(j + 1, rightLoc);
                    }
                    if (Arrays.equals(curLoc, lastLoc)) {
                        ans[i] = findMax(diffs);
                    }
                    lastLoc = curLoc;
                    break;
                }
            }
        }
        return ans;
    }

    private long getSum(int[] arr, int left, int right) {
        if (right < 0 || left >= arr.length) {
            return 0;
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private long findMax(Map<int[], Long> map) {
        long max = 0;
        for (long cur : map.values()) {
            max = Math.max(max, cur);
        }
        return max;
    }
}
