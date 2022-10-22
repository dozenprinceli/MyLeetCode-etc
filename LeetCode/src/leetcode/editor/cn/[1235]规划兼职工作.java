//你打算利用空闲时间来做兼职工作赚些零花钱。 
//
// 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。 
//
// 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。 
//
// 注意，时间上出现重叠的 2 份工作不能同时进行。 
//
// 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//输出：120
//解释：
//我们选出第 1 份和第 4 份工作， 
//时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
// 
//
// 示例 2： 
//
// 
//
// 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60
//]
//输出：150
//解释：
//我们选择第 1，4，5 份工作。 
//共获得报酬 150 = 20 + 70 + 60。
// 
//
// 示例 3： 
//
// 
//
// 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4 
// 1 <= startTime[i] < endTime[i] <= 10^9 
// 1 <= profit[i] <= 10^4 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 192 👎 0


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] bundle = new int[n][];
        for (int i = 0; i < n; ++i) bundle[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(bundle, Comparator.comparingInt(a -> a[1])); // 按照结束时间排序

        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int idx = search(bundle, i, bundle[i][0]);
            f[i + 1] = Math.max(f[i], f[idx + 1] + bundle[i][2]);
        }
        return f[n];
    }

    private int search(int[][] bundle, int right, int limit) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (bundle[mid][1] <= limit) left = mid;
            else right = mid;
        }
        return left;
    }
//    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//        int[][] bundle = new int[][]{startTime, endTime, profit};
//        Arrays.sort(bundle, Comparator.comparingInt(o -> o[1]));
//
//        int[] f = new int[startTime.length + 1];
//        for (int i = 0; i < startTime.length; i++) {
//            int j = bSearch(bundle, i, bundle[i][0]);
//            f[j + 1] = Math.max(f[i], f[j + 1] + bundle[i][2]);
//        }
//        return f[startTime.length - 1];
//    }
//
//    private int bSearch(int[][] bundle, int right, int limit) {
//        int left = -1;
//        while (left < right - 1) {
//            int mid = (left + right) >> 1;
//            if (bundle[mid][1] <= limit) left = mid;
//            else right = mid;
//        }
//        return left;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
