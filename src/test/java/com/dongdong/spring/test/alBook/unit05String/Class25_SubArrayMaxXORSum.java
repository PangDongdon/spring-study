package com.dongdong.spring.test.alBook.unit05String;

/**
 * 子数组的最大异或和
 */
public class Class25_SubArrayMaxXORSum {

    public static int maxXorSubarray1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] eor = new int[arr.length];
        eor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            eor[i] = eor[i - 1] ^ arr[i];
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i <= j; i++) {
                max = Math.max(max, i == 0 ? eor[j] : eor[j] ^ eor[i - 1]);
            }
        }
        return max;
    }

    //前缀树的节点类型，每个节点向下只可能有走向0或1的路
    public static class Node {
        public static Node[] nexts = new Node[2];
    }

    //基于本题，定制前缀树的实现
    public static class NumTrie {
        //头节点
        public static Node head = new Node();

        //把某个数字newNum 加入到这棵树前缀树里
        //num 是一个32位的整数，所以加入的过程一共32步
        public static void add(int newNum) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int path = ((newNum >> move) & 1);
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        //给定一个eorj,eorj 表示eor[j],即以j位置结尾的情况下，arr[0..j]的异或和
        //因为之前把eor[0] eor[1] eor[j-1] 都加入了前缀树，所以选择出一条最优路径
        //maxXor 方法 就是把最优路径找到，并且返回eor[j] 与最优路径结合之后得到的最大异或和
        public static int maxXor(int eorj) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (eorj >> move) & 1;
                int best = move == 31 ? path : (path ^ 1);
                best = cur.nexts[best] != null ? best : (best ^ 1);
                res |= (path ^ best) << move;
                cur = cur.nexts[best];
            }
            return res;
        }
    }

    public static int maxXorSubrray2(int[] arr){
        if(arr==null || arr.length==0){
            return  0;
        }
        int max=Integer.MIN_VALUE;
        int eor=0;
        NumTrie numTrie=new NumTrie();
        numTrie.add(0);
        for(int j=0;j<arr.length;j++){
            eor^=arr[j];
            max=Math.max(max,numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={3,-28,-29,2};
        System.out.println(maxXorSubarray1(arr));
        System.out.println(maxXorSubrray2(arr));
    }
}

