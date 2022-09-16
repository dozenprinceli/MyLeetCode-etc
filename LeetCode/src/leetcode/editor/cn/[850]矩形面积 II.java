//我们给出了一个（轴对齐的）二维矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是
//矩形 i 左下角的坐标，
// (xi1, yi1) 是该矩形 左下角 的坐标，
// (xi2, yi2) 是该矩形 右上角 的坐标。 
//
// 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。 
//
// 返回 总面积 。因为答案可能太大，返回
// 10⁹ + 7 的 模 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
//输出：6
//解释：如图所示，三个矩形覆盖了总面积为6的区域。
//从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
//从(1,0)到(2,3)，三个矩形都重叠。
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[0,0,1000000000,1000000000]]
//输出：49
//解释：答案是 10¹⁸ 对 (10⁹ + 7) 取模的结果， 即 49 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 200 
// rectanges[i].length = 4
// 
// 0 <= xi1, yi1, xi2, yi2 <= 10⁹ 
// 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。 
// 
//
// Related Topics 线段树 数组 有序集合 扫描线 👍 109 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rectangleArea(int[][] rectangles) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int[] rect : rectangles) {
            minX = Math.min(rect[0], minX);
            maxX = Math.max(rect[2], maxX);
        }

        int MOD = (int) 1e9 + 7;
        int n = rectangles.length;
        long totalArea = 0;
        Arrays.sort(rectangles, Comparator.comparingInt(o -> o[0]));

        Queue<int[]> curScan = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int curLine = minX;
        for (int i = 0; i < n; i++) {
            int[] rect = rectangles[i];
            // 添加左边界为lineX到扫描列表
            if (i != n - 1 && rectangles[i + 1][0] == curLine) {
                curScan.add(rect);
                continue;
            }
            curScan.add(rect);

            // 计算扫描线每次扫描长度变化前的面积
            while (true) {
                if (i == n - 1) { // 最后一个, 收尾操作
                    while (!curScan.isEmpty()) {
                        int curLen = getLength(curScan);
                        int end = Objects.requireNonNull(curScan.poll())[2];
                        totalArea += (long) curLen * (end - curLine);
                        curLine = end;
                    }
                    break;
                } else { // 计算到需要添加下一个Rect为止
                    if (curScan.isEmpty()) {
                        curLine = rectangles[i + 1][0];
                        break;
                    }
                    int firstEnd = curScan.peek()[2];
                    int curLength = getLength(curScan);
                    if (firstEnd >= rectangles[i + 1][0]) {
                        totalArea += (long) curLength * (rectangles[i + 1][0] - curLine);
                        curLine = rectangles[i + 1][0];
                        break;
                    } else {
                        curScan.poll();
                        totalArea += (long) curLength * (firstEnd - curLine);
                        if (!curScan.isEmpty()) {
                            curLine = firstEnd;
                        }
                    }
                }
            }
        }
        return (int) (totalArea % MOD);
    }

    private int getLength(Queue<int[]> scanRectSet) {
        List<int[]> sortedRectList = new ArrayList<>(scanRectSet);
        sortedRectList.sort(Comparator.comparingInt(o -> o[1]));
        int length = 0;
        int[] curLine = new int[]{0, 0};
        for (int[] rect : sortedRectList) {
            int curStart = rect[1];
            int curEnd = rect[3];
            if (curStart > curLine[1]) {
                length += curLine[1] - curLine[0];
                curLine[0] = curStart;
                curLine[1] = curEnd;
            } else {
                curLine[1] = Math.max(curLine[1], curEnd);
            }
        }
        length += curLine[1] - curLine[0];
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
