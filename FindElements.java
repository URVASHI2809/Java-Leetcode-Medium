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
class FindElements {
    private BitSet recoveredValues;

    public FindElements(TreeNode root) {
        recoveredValues = new BitSet();
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int value) {
        node.val = value;
        
        recoveredValues.set(value); 
        if(node.left!=null)
            recoverTree(node.left, 2 * value + 1);
        if(node.right!=null)
            recoverTree(node.right, 2 * value + 2);
    }

    public boolean find(int target) {
        return recoveredValues.get(target); 
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
