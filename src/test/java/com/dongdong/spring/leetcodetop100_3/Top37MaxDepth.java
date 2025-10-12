package com.dongdong.spring.leetcodetop100_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 */
public class Top37MaxDepth {
    public int maxDepth(TreeNode root) {
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
