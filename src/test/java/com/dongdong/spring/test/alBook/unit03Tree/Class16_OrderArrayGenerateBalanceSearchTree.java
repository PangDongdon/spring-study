package com.dongdong.spring.test.alBook.unit03Tree;

/**
 * 通过有序数组生成平衡搜索二叉树
 */
public class Class16_OrderArrayGenerateBalanceSearchTree {


    private static Node generateTree(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }
        return generate(sortArr, 0, sortArr.length - 1);
    }

    private static Node generate(int[] sortArr, int start, int end) {
        if(end<start){
            return null;
        }
        int mid=(start+end)/2;
        Node head=new Node(sortArr[mid]);
        head.left=generate(sortArr,start,mid-1);
        head.right=generate(sortArr,mid+1,1);
        return head;
    }


    public static void main(String[] args) {
        int[] dd={1,2,3};
        System.out.println(generateTree(dd).value+","+generateTree(dd).left.value);
    }

}
