package com.dongdong.spring.leetcodetop100_2;

import java.util.LinkedList;
import java.util.Queue;

public class Top37MaxDepth {
    public int maxDepth(TreeNode root) {
      if(root==null){
          return 0;
      }
      return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
             int size = queue.size();
             while (size>0){
                 TreeNode node=queue.poll();
                 if(node.left!=null){
                     queue.offer(node.left);
                 }
                 if (node.right!=null){
                     queue.offer(node.right);
                 }
                 size--;
             }
             res++;
        }
        return res;
    }
}
