//给定一个由 0 和 1 组成的数组
// arr ，将数组分成 3 个非空的部分 ，使得所有这些部分表示相同的二进制值。 
//
// 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来： 
//
// 
// arr[0], arr[1], ..., arr[i] 为第一部分； 
// arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分； 
// arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。 
// 这三个部分所表示的二进制值相等。 
// 
//
// 如果无法做到，就返回 [-1, -1]。 
//
// 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,
//1,1] 和 [1,1] 表示相同的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,0,1,0,1]
//输出：[0,3]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,0,1,1]
//输出：[-1,-1] 
//
// 示例 3: 
//
// 
//输入：arr = [1,1,0,0,1]
//输出：[0,2]
// 
//
// 
//
// 提示： 
// 
//
// 
// 3 <= arr.length <= 3 * 10⁴ 
// arr[i] 是 0 或 1 
// 
//
// Related Topics 数组 数学 👍 185 👎 0


import java.util.Arrays;
// TODO WA
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) return new int[]{-1, -1};
        if (sum == 0) return new int[]{0, 2};

        int n = arr.length;
        for (int p2 = n - 2; p2 > 0; p2--) {
            for (int p1 = p2 - 1; p1 >= 0; p1--) {
                if (equals(arr, p1, p2)) return new int[]{p1, p2 + 1};
            }
        }
        return new int[]{-1, -1};
    }

    private boolean equals(int[] arr, int p1, int p2) {
        int p3 = arr.length - 1;
        int s1 = p1, s2 = p2;
        while (p1 >= 0 && p2 > s1 && p3 > s2) {
            if (arr[p1] != arr[p2] || arr[p2] != arr[p3]) return false;
            p1--;
            p2--;
            p3--;
        }
        for (int i = 0; i <= p1; i++) {
            if (arr[i] != 0) return false;
        }
        for (int i = s1 + 1; i <= p2; i++) {
            if (arr[i] != 0) return false;
        }
        for (int i = s2 + 1; i <= p3; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
