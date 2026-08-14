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
class Solution {
    int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       postindex=postorder.length-1;
       return build(inorder,postorder,0,inorder.length-1);
    }
    private TreeNode build(int[] inorder,int[] postorder,int left,int right){
        if(left>right){
            return null;
        }
        int rootvalue=postorder[postindex--];
        TreeNode root=new TreeNode(rootvalue);
        int index=left;
        while(inorder[index]!=rootvalue){
            index++;
        }
        root.right=build(inorder,postorder,index+1,right);
        root.left=build(inorder,postorder,left,index-1);
        return root;
    }
}