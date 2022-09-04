package com.dongdong.spring.test.alBook.unit03Tree;

//二叉树节点间的最大距离问题
public class Class20_MaxDistanceInTreeNode {

    public static class ReturnType {
        private int maxDistance;
        private int height;

        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    private static ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDistance = Math.max(leftData.height + rightData.height + 1
                , Math.max(leftData.maxDistance, rightData.height));
        return new ReturnType(maxDistance, height);
    }

    private static int getMaxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        System.out.println(getMaxDistance(node));
    }
}
