package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayList;
import java.util.List;

/**
 *二叉树展开为链表
 */
public class Top46Flatten {
    public void flatten(TreeNode root) {
     if(root==null){
         return;
     }
     TreeNode temp=root;
     List<TreeNode> res=new ArrayList<>();
     addNode(temp,res);
     for(int i=1;i<res.size();i++){
         TreeNode prev=res.get(i-1);
         TreeNode curr=res.get(i);
         prev.left=null;
         prev.right=curr;
     }
    }

    private void addNode(TreeNode temp, List<TreeNode> res) {
        if(temp==null){
            return;
        }
        res.add(temp);
        addNode(temp.left,res);
        addNode(temp.right,res);
    }
}
