package com.dongdong.spring.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径和
 */
public class Top48PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
    if(root==null){
        return 0;
    }
    int ret=0;
    curr+=root.val;
    ret=prefix.getOrDefault(curr-targetSum,0);
    prefix.put(curr,prefix.getOrDefault(curr-targetSum,0)+1);
    ret+=dfs(root.left, prefix, curr, targetSum);
    ret+=dfs(root.right, prefix, curr, targetSum);
    prefix.put(curr,prefix.getOrDefault(curr-targetSum,0)-1);
    return ret;
    }
}
