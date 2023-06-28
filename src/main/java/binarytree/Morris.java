package binarytree;

public class Morris {
    public void mid(TreeNode root){
        TreeNode cur=root,pre=null;
        while(cur!=null){
            if(cur.left==null){
                System.out.println(cur.val);
                cur=cur.right;
            }else{
                pre=cur.left;
                while(pre.right!=null&&pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                }else{
                    pre.right=null;
                    System.out.println(cur.val);
                    cur=cur.right;
                }
            }
        }
    }
}
