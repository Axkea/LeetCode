package binarytree;

//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//路径和 是路径中各节点值的总和。
//
//给你一个二叉树的根节点 root ，返回其 最大路径和 。
public class L124Solution {
    private int maxValue=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root==null){
            return 0;
        }
        maxPathValue(root);
        return maxValue;
    }

    private int maxPathValue(TreeNode node){
        if (node==null){
            return 0;
        }
        int maxLeftValue=Math.max(0,maxPathValue(node.left));
        int maxRightValue=Math.max(0,maxPathValue(node.right));
        int maxNodeValue=maxLeftValue+maxRightValue+ node.val;
        maxValue=Math.max(maxValue,maxNodeValue);
        return Math.max(maxLeftValue,maxRightValue)+node.val;
    }
}
