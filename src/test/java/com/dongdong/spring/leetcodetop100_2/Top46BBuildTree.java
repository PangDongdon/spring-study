package com.dongdong.spring.leetcodetop100_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构建二叉树
 */
public class Top46BBuildTree {
    Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuild(preorder, inorder, 0, size - 1, 0, size - 1);
    }

    private TreeNode myBuild(int[] preorder, int[] inorder, int pre_left, int pre_right,
                             int in_left, int in_right) {


        if (pre_left > pre_right) {
            return null;
        }
        //根节点序号
        int pre_root = pre_left;
        //获取根节点在中序遍历中的序号
        final Integer inorder_root = indexMap.get(preorder[pre_root]);
        //根节点
        TreeNode root = new TreeNode(preorder[pre_root]);
        //左子树的数量
        int inorder_left_size = inorder_root - in_left;


        //左子树
        root.left = myBuild(preorder, inorder, pre_left + 1, pre_left + inorder_left_size, in_left, inorder_root - 1);
        //右子树
        root.right = myBuild(preorder, inorder, pre_left + inorder_left_size + 1, pre_right, inorder_root + 1, in_right);
        return root;
    }
}
