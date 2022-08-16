//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5128 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        for (int p1 = 0; p1 < length - 2; p1++) {
            if (p1 == 0 || nums[p1] != nums[p1 - 1]) {
                int p3 = length - 1;
                for (int p2 = p1 + 1; p2 < length - 1; p2++) {
                    if (p2 == p1 + 1 || nums[p2] != nums[p2 - 1]) {
                        while (p3 > p2 && nums[p1] + nums[p2] + nums[p3] > 0) {
                            p3--;
                        }
                        if (p3 == p2) break;
                        if (nums[p1] + nums[p2] + nums[p3] == 0) {
                            List<Integer> lst = Arrays.asList(nums[p1], nums[p2], nums[p3]);
                            res.add(lst);
                        }
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
