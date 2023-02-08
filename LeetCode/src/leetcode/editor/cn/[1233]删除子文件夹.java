//你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。 
//
// 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。 
//
// 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。 
//
// 
// 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//输出：["/a","/c/d","/c/f"]
//解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
// 
//
// 示例 2： 
//
// 
//输入：folder = ["/a","/a/b/c","/a/b/d"]
//输出：["/a"]
//解释：文件夹 "/a/b/c" 和 "/a/b/d/" 都会被删除，因为它们都是 "/a" 的子文件夹。
// 
//
// 示例 3： 
//
// 
//输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
//输出: ["/a/b/c","/a/b/ca","/a/b/d"] 
//
// 
//
// 提示： 
//
// 
// 1 <= folder.length <= 4 * 10⁴ 
// 2 <= folder[i].length <= 100 
// folder[i] 只包含小写字母和 '/' 
// folder[i] 总是以字符 '/' 起始 
// 每个文件夹名都是 唯一 的 
// 
//
// Related Topics 字典树 数组 字符串 👍 78 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    TreeNode root = null;
    final List<String> result = new ArrayList<>();
    final String SPLIT = "/";

    public List<String> removeSubfolders(String[] paths) {
        for (String path : paths) {
            handlePath(path);
        }
        dfs(root, "");
        return result;
    }

    void dfs(TreeNode head, String curPath) {
        if (head == null) {
            return;
        }

        String append = head.val.equals("") ? "" : SPLIT + head.val;
        String newPath = curPath + append;
        if (head.children.isEmpty()) {
            result.add(newPath);
            return;
        }
        for (TreeNode child : head.children) {
            dfs(child, newPath);
        }
    }

    void handlePath(String path) {
        String[] folders = path.split("/");
        if (root == null) {
            initPath(folders);
            return;
        }
        TreeNode head = root;
        boolean ignore = false;
        for (String folder : folders) {
            if (folder.equals(root.val)) {
                continue;
            }
            if (ignore) {
                TreeNode next = new TreeNode(folder);
                head.addChild(next);
                head = next;
                continue;
            }
            if (head.children.isEmpty()) {
                break;
            }
            TreeNode child = head.getChild(folder);
            if (child == null) {
                ignore = true;
                child = new TreeNode(folder);
                head.addChild(child);
            }
            head = child;
        }
        head.children.clear();
    }

    void initPath(String[] folders) {
        if (folders.length == 0) {
            return;
        }

        TreeNode head = null;
        for (String folder : folders) {
            if (head == null) {
                head = new TreeNode(folder);
                root = head;
                continue;
            }
            TreeNode next = new TreeNode(folder);
            head.addChild(next);
            head = next;
        }
    }

    static class TreeNode {
        String val;
        List<TreeNode> children = new ArrayList<>();

        void addChild(TreeNode child) {
            children.add(child);
        }

        TreeNode getChild(String folder) {
            for (TreeNode child : children) {
                if (child.val.equals(folder)) {
                    return child;
                }
            }
            return null;
        }

        public TreeNode(String val) {
            this.val = val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
