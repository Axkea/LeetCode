package binarytree;

public class L222Solution {
    private int count=0;
    public int countNodes(TreeNode root) {
        findAll(root);
        return count;
    }
    private void findAll(TreeNode node){
        if(node==null){
            return;
        }
        findAll(node.left);
        count++;
        findAll(node.right);
    }
}
