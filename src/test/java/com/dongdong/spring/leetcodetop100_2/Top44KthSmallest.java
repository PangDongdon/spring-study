package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Top44KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
               stack.push(root);
               root=root.left;
            }
            root = stack.pop();
            k--;
            if(k==0){
               break;
            }
            root=root.right;
        }
        return root.val;
    }
}
