//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1332 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int p1 = 0; p1 < n - 3; p1++) {
            if (p1 == 0 || nums[p1] != nums[p1 - 1]) {
                for (int p2 = p1 + 1; p2 < n - 2; p2++) {
                    if (p2 == p1 + 1 || nums[p2] != nums[p2 - 1]) {
                        for (int p3 = p2 + 1; p3 < n - 1; p3++) {
                            if (p3 == p2 + 1 || nums[p3] != nums[p3 - 1]) {
                                int p4 = n - 1;
                                while (nums[p1] + nums[p2] + nums[p3] + nums[p4] > target && p4 > p3) {
                                    p4--;
                                }
                                if (p4 > p3 && (long) nums[p1] + (long) nums[p2] + (long) nums[p3] + (long) nums[p4] == (long) target) {
                                    List<Integer> lst = Arrays.asList(nums[p1], nums[p2], nums[p3], nums[p4]);
                                    res.add(lst);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
