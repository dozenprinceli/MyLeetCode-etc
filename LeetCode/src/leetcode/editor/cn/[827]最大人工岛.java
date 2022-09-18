//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。 
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？ 
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。 
//
// 
//
// 示例 1: 
//
// 
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。 
//
// 示例 3: 
//
// 
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 500 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 224 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final List<int[]> addLocs = new ArrayList<>();
    private final List<Integer> area = new ArrayList<>();

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxSize = 1;
        int id = 1;
        int[][] belong = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 && belong[r][c] == 0) {
                    area.add(0);
                    traverseIsland(grid, belong, id, r, c);
                    maxSize = Math.max(maxSize, area.get(id - 1));
                    id++;
                } else if (grid[r][c] == 0) {
                    int cnt = getNextIslandCnt(grid, r, c);
                    if (cnt > 0) {
                        addLocs.add(new int[]{r, c});
                    }
                }
            }
        }

        for (int[] loc : addLocs) {
            List<int[]> neighbors = getNeighbors(grid, loc[0], loc[1]);
            Set<Integer> nextIslands = new HashSet<>();
            int curSize = 1;
            for (int[] neighbor : neighbors) {
                nextIslands.add(belong[neighbor[0]][neighbor[1]]);
            }
            for (int nextId : nextIslands) {
                curSize += area.get(nextId - 1);
            }
            maxSize = Math.max(maxSize, curSize);
        }
        return maxSize;
    }

    private void traverseIsland(int[][] grid, int[][] belong, int id, int r, int c) {
        if (belong[r][c] != 0) {
            return;
        }
        belong[r][c] = id;
        area.set(id - 1, area.get(id - 1) + 1);
        List<int[]> neighbors = getUntrackedNeighbors(grid, belong, r, c);
        for (int[] loc : neighbors) {
            traverseIsland(grid, belong, id, loc[0], loc[1]);
        }
    }

    private List<int[]> getUntrackedNeighbors(int[][] grid, int[][] belong, int r, int c) {
        List<int[]> ans = new ArrayList<>();
        int n = grid.length;
        if (r != 0 && grid[r - 1][c] == 1 && belong[r - 1][c] == 0) {
            ans.add(new int[]{r - 1, c});
        }
        if (r != n - 1 && grid[r + 1][c] == 1 && belong[r + 1][c] == 0) {
            ans.add(new int[]{r + 1, c});
        }
        if (c != 0 && grid[r][c - 1] == 1 && belong[r][c - 1] == 0) {
            ans.add(new int[]{r, c - 1});
        }
        if (c != n - 1 && grid[r][c + 1] == 1 && belong[r][c + 1] == 0) {
            ans.add(new int[]{r, c + 1});
        }
        return ans;
    }

    private int getNextIslandCnt(int[][] grid, int r, int c) {
        int ans = 0;
        int n = grid.length;
        if (r != 0 && grid[r - 1][c] == 1) {
            ans++;
        }
        if (r != n - 1 && grid[r + 1][c] == 1) {
            ans++;
        }
        if (c != 0 && grid[r][c - 1] == 1) {
            ans++;
        }
        if (c != n - 1 && grid[r][c + 1] == 1) {
            ans++;
        }
        return ans;
    }

    private List<int[]> getNeighbors(int[][] grid, int r, int c) {
        List<int[]> ans = new ArrayList<>();
        int n = grid.length;
        if (r != 0 && grid[r - 1][c] == 1) {
            ans.add(new int[]{r - 1, c});
        }
        if (r != n - 1 && grid[r + 1][c] == 1) {
            ans.add(new int[]{r + 1, c});
        }
        if (c != 0 && grid[r][c - 1] == 1) {
            ans.add(new int[]{r, c - 1});
        }
        if (c != n - 1 && grid[r][c + 1] == 1) {
            ans.add(new int[]{r, c + 1});
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
