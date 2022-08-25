//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// Related Topics 数组 数学 字符串 排序 👍 213 👎 0


import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = parseTimeString(timePoints.get(i));
        }
        Arrays.sort(times);
        int ans = diffMinutes(times[0], times[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, diffMinutes(times[i], times[i + 1]));
            if (ans == 0) {
                return 0;
            }
        }
        return ans;
    }

    private int parseTimeString(String timeStr) {
        return Integer.parseInt(timeStr.substring(0, 2)) * 100 + Integer.parseInt(timeStr.substring(3));
    }

    private int diffMinutes(int time1, int time2) {
        int prevTime = Math.min(time1, time2);
        int laterTime = Math.max(time1, time2);
        int prevHour = prevTime / 100;
        int prevMinute = prevTime % 100;
        int laterHour = laterTime / 100;
        int laterMinute = laterTime % 100;
        return Math.min(
                laterMinute - prevMinute + 60 * (laterHour - prevHour),
                prevMinute - laterMinute + 60 * (prevHour + 24 - laterHour)
        );
    }
}
//leetcode submit region end(Prohibit modification and deletion)
