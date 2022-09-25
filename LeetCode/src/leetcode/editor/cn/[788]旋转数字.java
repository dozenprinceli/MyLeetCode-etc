//我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。 
//
// 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况
//下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。 
//
// 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？ 
//
// 
//
// 示例： 
//
// 输入: 10
//输出: 4
//解释: 
//在[1, 10]中有四个好数： 2, 5, 6, 9。
//注意 1 和 10 不是好数, 因为他们在旋转之后不变。
// 
//
// 
//
// 提示： 
//
// 
// N 的取值范围是 [1, 10000]。 
// 
//
// Related Topics 数学 动态规划 👍 147 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final int[] underDigit = new int[]{0, 4, 40, 316, 2320};

    public int rotatedDigits(int n) {
        int len = String.valueOf(n).length();
        int ans = underDigit[len - 1];

        int start = (int) Math.pow(10, len - 1);
        for (int i = start; i <= n; i++) {
            String val = String.valueOf(i);
            if (val.contains("2") || val.contains("5") || val.contains("6") || val.contains("9")) {
                if (!val.contains("3") && !val.contains("4") && !val.contains("7")) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
