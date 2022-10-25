//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。 
//
// 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。 
//
// 
// 
// 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。 
// 
// 
//
// 返回必须翻转的 0 的最小数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] 为 0 或 1 
// grid 中恰有两个岛 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 389 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<int[]> borders = new ArrayList<>();

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean isEnd = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    isEnd = true;
                    break;
                }
            }
            if (isEnd) break;
        }
        int len = 0;
        while (true) {
            List<int[]> last = borders;
            borders = new ArrayList<>();
            for (int[] loc : last) {
                int r = loc[0], c = loc[1];
                if (r > 0 && grid[r - 1][c] == 1 || r < n - 1 && grid[r + 1][c] == 1 ||
                        c > 0 && grid[r][c - 1] == 1 || c < n - 1 && grid[r][c + 1] == 1) return len;
                if (r > 0 && grid[r - 1][c] == 0) {
                    grid[r - 1][c] = -1;
                    borders.add(new int[]{r - 1, c});
                }
                if (r < n - 1 && grid[r + 1][c] == 0) {
                    grid[r + 1][c] = -1;
                    borders.add(new int[]{r + 1, c});
                }
                if (c > 0 && grid[r][c - 1] == 0) {
                    grid[r][c - 1] = -1;
                    borders.add(new int[]{r, c - 1});
                }
                if (c < n - 1 && grid[r][c + 1] == 0) {
                    grid[r][c + 1] = -1;
                    borders.add(new int[]{r, c + 1});
                }
            }
            len++;
        }
    }

    private void dfs(int[][] grid, int r, int c) {
        if (grid[r][c] != 1) return;
        borders.add(new int[]{r, c});
        grid[r][c] = -1;
        for (int[] loc : getNeighbors(grid, r, c)) {
            dfs(grid, loc[0], loc[1]);
        }
    }

    private List<int[]> getNeighbors(int[][] grid, int r, int c) {
        int n = grid.length;
        List<int[]> res = new ArrayList<>();
        if (r > 0 && grid[r - 1][c] == 1) res.add(new int[]{r - 1, c});
        if (r < n - 1 && grid[r + 1][c] == 1) res.add(new int[]{r + 1, c});
        if (c > 0 && grid[r][c - 1] == 1) res.add(new int[]{r, c - 1});
        if (c < n - 1 && grid[r][c + 1] == 1) res.add(new int[]{r, c + 1});
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
