package array;

import org.junit.Test;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/9/18 13:30
 */
public class Array10 {
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

    @Test
    public void test827() {
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        System.out.println(largestIsland(grid));
    }
}
