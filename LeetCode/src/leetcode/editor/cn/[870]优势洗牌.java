//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数
//目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 排序 👍 195 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        Arrays.sort(nums1);
        List<Integer> numList = new ArrayList<>(length);
        for (int num : nums1) {
            numList.add(num);
        }
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int curNum = nums2[i];
            if (numList.get(numList.size() - 1) <= curNum || numList.get(0) > curNum) {
                res[i] = numList.remove(0);
            } else {
                int left = 0;
                int right = numList.size() - 1;
                while (left < right - 1) {
                    int mid = (left + right) / 2;
                    int midNum = numList.get(mid);
                    if (midNum > curNum) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                res[i] = numList.remove(right);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
