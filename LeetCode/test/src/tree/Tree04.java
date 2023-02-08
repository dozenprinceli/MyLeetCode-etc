package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2023/2/8 19:26
 */
public class Tree04 {
    @Test
    public void test1233() {
        String[] paths = {"/a", "/a/b/c", "/a/b/d"};
        removeSubfolders(paths);
    }

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
