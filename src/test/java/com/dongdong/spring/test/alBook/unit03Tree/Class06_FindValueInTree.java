package com.dongdong.spring.test.alBook.unit03Tree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//在二叉树中找到累加和为指定值得最长路径长度
public class Class06_FindValueInTree {


    public static int getMaxLength(Node head, int sum) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);
        return inPreOrder(head, sum, 0, 1, 0, sumMap);
    }

    public static int inPreOrder(Node node, int sum, int preNum, int level, int maxLen, Map<Integer, Integer> sumMap) {
        if (node == null) {
            return maxLen;
        }
        int curSum = preNum + node.value;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        if (sumMap.containsKey(curSum - sum)) {
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
        }
        maxLen = inPreOrder(node.left, sum, curSum, level + 1, maxLen, sumMap);
        maxLen = inPreOrder(node.right, sum, curSum, level + 1, maxLen, sumMap);
        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }
        return maxLen;
    }


    public static void main(String[] args) {

    }

}
