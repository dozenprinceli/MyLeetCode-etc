package matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/10/25 23:24
 */
public class Matrix04 {
    @Test
    public void test934() {
        int[][] grid = new int[][]{{0, 1}, {1, 0}};
        System.out.println(shortestBridge(grid));
    }

    private List<int[]> borders = new ArrayList<>();

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break;
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
