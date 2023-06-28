package binarytree;

public class S26Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null||A==null){
            return false;
        }
        if(A.val!=B.val){
            return isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }else{
            return backTrace(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
    }
    public boolean backTrace(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }else{
            return backTrace(A.left,B.left)&&backTrace(A.right,B.right);
        }
    }
}
