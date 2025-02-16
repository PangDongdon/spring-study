package com.dongdong.spring.leetcodetop100_2;
/**
 *将有序数组转化为二叉搜索树
 */
public class Top41SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //1,2,3,4,5
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }
}
