//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴
// 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 350 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int left, right;
        if (arr[0] >= x) {
            left = 0;
            right = k - 1;
        } else if (arr[n - 1] <= x) {
            left = n - k;
            right = n - 1;
        } else {
            // 找到初始left和right位置
            right = 0;
            while (arr[right] <= x) {
                right++;
            }
            right -= (getDiff(arr, right, x) < getDiff(arr, right - 1, x)) ? 0 : 1;
            left = right;
            while (right - left + 1 < k) {
                if (right == n - 1) {
                    left--;
                } else if (left == 0) {
                    right++;
                } else if (getDiff(arr, right + 1, x) < getDiff(arr, left - 1, x)) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        for (int idx = left; idx <= right; idx++) {
            ans.add(arr[idx]);
        }
        return ans;
    }

    private int getDiff(int[] arr, int idx, int x) {
        return Math.abs(arr[idx] - x);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
