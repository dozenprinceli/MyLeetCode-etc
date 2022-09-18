package biweekly.c85;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 22:29
 */
public class D {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] ans = new long[n];
        int[] reNums = new int[n];
        for (int i = n - 1; i > 0; i--) {
            int idx = removeQueries[i];
            reNums[idx] = nums[idx];
            long cur = nums[idx];
            if (idx != 0 && reNums[idx - 1] != 0) {
                for (int j = idx - 1; j >= 0; j--) {
                    int curNum = reNums[j];
                    if (curNum == 0) {
                        break;
                    }
                    cur += curNum;
                }
            }
            if (idx != n - 1 && reNums[idx + 1] != 0) {
                for (int j = idx + 1; j < n; j++) {
                    int curNum = reNums[j];
                    if (curNum == 0) {
                        break;
                    }
                    cur += curNum;
                }
            }
            ans[i - 1] = Math.max(ans[i], cur);
        }
        return ans;
    }
}
