//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
//
// Related Topics 数学 字符串 模拟 👍 124 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionAddition(String expression) {
        List<int[]> fracList = parseFracString(expression);
        int[] ans = new int[2];
        ans[0] = 0;
        ans[1] = 1;
        for (int[] frac : fracList) {
            ans = calcFrac(ans, frac);
        }
        return ans[0] + "/" + ans[1];
    }

    private List<int[]> parseFracString(String expression) {
        int n = expression.length();
        List<int[]> returnList = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < n) {
            int[] curFrac = new int[2];
            returnList.add(curFrac);
            while (expression.charAt(right) != '/') {
                right++;
            }
            curFrac[0] = Integer.parseInt(expression.substring(left, right));
            left = right + 1;
            right = left;
            while (right < n && expression.charAt(right) != '+' && expression.charAt(right) != '-') {
                right++;
            }
            curFrac[1] = Integer.parseInt(expression.substring(left, right));
            left = right;
        }
        return returnList;
    }

    private int[] calcFrac(int[] frac1, int[] frac2) {
        int deno1 = frac1[0];
        int deno2 = frac2[0];
        int numer1 = frac1[1];
        int numer2 = frac2[1];

        int lcm = lcm(numer1, numer2);
        int newDeno = lcm / numer1 * deno1 + lcm / numer2 * deno2;
        int newGcd = gcd(Math.abs(newDeno), lcm);

        int[] ans = new int[2];
        ans[0] = newDeno / newGcd;
        ans[1] = lcm / newGcd;
        return ans;
    }

    private int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0) {
            return 1;
        }
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, (num1 % num2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
