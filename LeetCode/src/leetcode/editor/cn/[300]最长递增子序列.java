//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 4101 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
//        return oN2Solution(nums);
        return oNLogNSolution(nums);
    }

    /**
     * O(n²)解法
     */
    private int oN2Solution(int[] n) {
        int[] lis = new int[n.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n.length; i++) {
            for (int j = 0; j < i; j++) {
                if (n[i] > n[j]) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        int max = 0;
        for (int l : lis) {
            max = Math.max(max, l);
        }
//        System.gc();
        return max;
    }

    /**
     * O(n log n)解法
     */
    private int oNLogNSolution(int[] n) {
        List<Integer> tails = new ArrayList<>(n.length);
        for (int i : n) {
            if (tails.isEmpty() || i > tails.get(tails.size() - 1)) 
                tails.add(i);
            else {
                int low = binarySearch(tails, i);
                if (low < 0) continue;
                tails.set(low, i);
            }
        }
        return tails.size();
    }
    
    private int binarySearch(List<Integer> list, int i) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right - 1) {
            int mid = (left + right) >> 1;
            Integer m = list.get(mid);
            if (i == m) return -1;
            
            if (i > m) left = mid;
            else right = mid;
        }
        if (list.get(left) == i || list.get(right) == i) return -1;
        if (i < list.get(left)) return left;
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)