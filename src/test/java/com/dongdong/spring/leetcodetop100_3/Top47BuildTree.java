package com.dongdong.spring.leetcodetop100_3;

import java.util.HashMap;
import java.util.Map;

/**
 *从前序遍历和中序遍历重建二叉树
 */
public class Top47BuildTree {
    Map<Integer,Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int length=preorder.length;
       for(int i=0;i<length;i++){
           indexMap.put(inorder[i],i);
       }
       return myBuild(preorder,inorder,0,length-1,0,length-1);
    }

    private TreeNode myBuild(int[] preorder, int[] inorder,
                             int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        //根节点序号
        int pre_root = pre_left;
        //获取根节点在中序遍历中的序号
        final Integer inorder_root = indexMap.get(preorder[pre_root]);
        //根节点
        TreeNode root = new TreeNode(preorder[pre_root]);
        //左子树数量
        int inorder_left_size = inorder_root - in_left;
        root.left = myBuild(preorder, inorder,
                pre_left + 1, pre_left + inorder_left_size,
                in_left, inorder_root - 1);
        root.right = myBuild(preorder, inorder,
                pre_left + inorder_left_size + 1, pre_right,
                inorder_root + 1, in_right);
        return root;
    }


}
