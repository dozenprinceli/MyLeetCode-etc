//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 如果方程中只有一个解，要保证返回值 'x' 是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
//
// Related Topics 数学 字符串 模拟 👍 98 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
        int[] coefs = new int[2];
        int isConst = 1;
        StringBuffer cur = new StringBuffer();
        String eqFormat = getEqFormat(equation) + "+"; // 最后的"+"号用于添加最后一个系数
        for (char c : eqFormat.toCharArray()) {
            switch (c) {
                case '+': // 符号项用于添加前一个参数, 并重置StringBuffer
                    coefs[isConst] += parseInt(cur.toString());
                    cur.setLength(0);
                    isConst = 1;
                    break;
                case '-':
                    coefs[isConst] += parseInt(cur.toString());
                    cur.setLength(0);
                    cur.append('-');
                    isConst = 1;
                    break;
                case 'x': // 设置为x系数项并检查当其为"1"或"-1"时的合法性
                    isConst = 0;
                    String curStr = cur.toString();
                    if (curStr.equals("") || curStr.equals("-")) {
                        cur.append('1');
                    }
                    break;
                default:
                    cur.append(c);
            }
        }
        // 判断结果类型
        if (coefs[0] == 0) {
            return coefs[1] == 0 ? "Infinite solutions" : "No solution";
        } else {
            int res = -coefs[1] / coefs[0];
            return "x=" + String.valueOf(res);
        }
    }

    /**
     * 将A=B形式的方程修改为C=0的形式并返回左边部分
     */
    private String getEqFormat(String equation) {
        String[] eqSplit = equation.split("=");
        StringBuffer sb = new StringBuffer(eqSplit[1]);
        if (sb.charAt(0) != '-') {
            sb.insert(0, '+');
        }
        for (int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            if (c == '+') {
                sb.setCharAt(i, '-');
            } else if (c == '-') {
                sb.setCharAt(i, '+');
            }
        }
        return eqSplit[0] + sb.toString();
    }

    /**
     * 重写parseInt()方法
     */
    private int parseInt(String str) {
        return str.equals("") ? 0 : Integer.parseInt(str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
