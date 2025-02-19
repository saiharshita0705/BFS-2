// Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, move root to queue initially. Run a while loop to keep all nodes of same level at once, while queue is not empty pop the
 * top node and check if it is equal to either x or y, if yes turn corresponding bool variable to true. If not check if their 
 * children are equal to x and y if yes return false there itself. If not if the childs are not empty add those to queue and 
 * check if boolean variables of finding x and y return true if not repeat the process. 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/* Iterative Approach */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean x_found = false;
            boolean y_found = false;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.val==x){
                    x_found = true;
                }
                if(node.val==y){
                    y_found = true;
                }
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y) return false;
                    if(node.left.val == y && node.right.val == x) return false;
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if (x_found && y_found) return true; 
        }
        return false;
    }
}

/* Recursive Approach */
class Solution {
    int x_depth = -1;
    int y_depth = -1;
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return (x_depth == y_depth && x_parent!=y_parent);
    }

    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        if(root == null) return;

        //logic
        if(root.val == x){
            x_depth = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_depth = level;
            y_parent = parent;
        }
        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);

    }
}
