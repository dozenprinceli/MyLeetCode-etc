//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3684 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int capacity = 0;
        // 收集所有极大值点
        List<Integer> peaks = new ArrayList<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || height[i] >= height[i - 1]) { // 与左值比较
                if (i == height.length - 1 || height[i] >= height[i + 1]) { // 与右值比较
                    peaks.add(i);
                }
            }
        }
        // 判断峰值之间的山谷
        if (peaks.size() <= 1) {
            return 0;
        }
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int i = 1; i < peaks.size() - 1; i++) {
                if (height[peaks.get(i)] <= height[peaks.get(i - 1)] && height[peaks.get(i)] <= height[peaks.get(i + 1)]) {
                    isChanged = true;
                    peaks.remove(i);
                    break;
                }
            }
        }
        // 处理每一段山谷的容量
        for (int i = 0; i < peaks.size() - 1; i++) {
            capacity += countCapacity(height, peaks.get(i), peaks.get(i + 1));
        }
        return capacity;
    }

    private int countCapacity(int[] height, int left, int right) {
        int capacity = 0;
        int maxHeight = Math.min(height[left], height[right]);
        for (int i = left + 1; i < right; i++) {
            int curHeight = height[i];
            if (curHeight < maxHeight) {
                capacity += maxHeight - curHeight;
            }
        }
        return capacity;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
