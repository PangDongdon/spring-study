package com.dongdong.spring.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *从前序与中序遍历序列构造二叉树
 */
public class Top47BuildTree {
    Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         int n=preorder.length;
         indexMap=new HashMap<>();
         for(int i=0;i<n;i++){
             indexMap.put(inorder[i],i);
         }
         return myBuild(preorder,0,n-1,inorder,0,n-1);
    }

    private TreeNode myBuild(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
      if(preLeft>preRight){
          return null;
      }
      //前序遍历的第一个节点就是根节点
      int preLeft_root=preLeft;
      //在中序遍历中定位根节点
      int inorder_root=indexMap.get(preorder[preLeft_root]);
      //把根节点建立起来
      TreeNode root=new TreeNode(preorder[preLeft_root]);
      //得到左子树的节点数目
      int size_left_subtree=inorder_root-inLeft;
      //左子树
      root.left=myBuild(preorder,preLeft+1,preLeft+size_left_subtree,
              inorder,inLeft,inorder_root-1);
      //右子树
      root.right=myBuild(preorder,preLeft+size_left_subtree+1,preRight,inorder,
              inorder_root+1,inRight);
      return root;
    }
}
