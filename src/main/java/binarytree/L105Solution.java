package binarytree;

public class L105Solution {
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        this.preorder=preorder;
        this.inorder=inorder;
        return build(0,preorder.length,0,inorder.length);
    }
    private TreeNode build(int preBegin,int preEnd,int inBegin,int inEnd){
        if (preEnd==preBegin){
            return null;
        }
        int begin=preorder[preBegin];
        TreeNode node = new TreeNode(begin);
        int beginIndex=0;
        for (int i = inBegin; i <=inEnd ; i++) {
            if (begin==inorder[i]){
                beginIndex=i;
                break;
            }
        }
        node.left=build(preBegin+1,preBegin+beginIndex-inBegin+1,inBegin,beginIndex);
        node.right=build(preBegin+beginIndex-inBegin+1,preEnd,beginIndex+1,inEnd);
        return node;
    }
}
