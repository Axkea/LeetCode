package binarytree;

public class L106Solution {
    private int[] inorder;
    private int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        return build(0,inorder.length,0,postorder.length);
    }

    private TreeNode build(int inBegin,int inEnd,int postBegin,int postEnd){
        if (postEnd<=postBegin||inEnd<=inBegin){
            return null;
        }
        int midNodeVal=postorder[postEnd-1];
        TreeNode midNode=new TreeNode(midNodeVal);
        int midIndex=inBegin;
        for (int i = inBegin; i < inEnd; i++) {
            if (inorder[i]==midNodeVal){
                midIndex=i;
                break;
            }
        }
        midNode.left=build(inBegin,midIndex,postBegin,postBegin+midIndex-inBegin);
        midNode.right=build(midIndex+1,inEnd,postBegin+midIndex-inBegin,postEnd-1);
        return midNode;
    }
}
