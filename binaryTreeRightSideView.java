// Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, create a queue and initially add root to it. Then, until the queue is empty, add the last element of queue to result list
 * for each level and add left and right nodes of the node added to result to queue for another level processing. Finally, return
 * the result. 
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            Integer temp = null;
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();
                temp = node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

/* Recursive Approach */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root, int level, List<Integer> result){
        if(root == null) return;
        //logic
        if(level == result.size()){
            result.add(root.val);
        }
        dfs(root.right, level+1, result);
        dfs(root.left, level+1, result);
    }
}