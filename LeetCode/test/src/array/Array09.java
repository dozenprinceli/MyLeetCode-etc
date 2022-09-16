package array;

import org.junit.Test;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/9/16 9:39
 */
public class Array09 {
    @Test
    public void test850() {
        int[][] rectangles = new int[][]{
                {25, 20, 70, 27},
                {68, 80, 79, 100},
                {37, 41, 66, 76}
        };
        System.out.println(rectangleArea(rectangles));
    }

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
