package com.dongdong.spring.test.alBook.unit05String;

/**
 * 完美洗牌问题
 */
public class Class09_PerfectShuffleCards {

    public static int modifyIndex2(int i, int len) {
        return (2 * i) % (len + 1);
    }

    //主函数，数组必须不为空，且长度为偶数
    public static void shuffle(int[] arr) {
        if (arr != null && arr.length != 0 && (arr.length & 1) == 0) {
            shuffle(arr, 0, arr.length - 1);
        }
    }

    //在 arr[L..R]上做完美洗牌调整
    private static void shuffle(int[] arr, int L, int R) {
        while (R - L + 1 > 0) {
            int len = R - L + 1;
            int base = 3;
            int k = 1;
            //计算小于或等于len 且距离len 最近的，满足（3^K-1）的数
            //也就是找到最大的k,满足3^<=len+1
            while (base <= (len + 1) / 3) {
                base *= 3;
                k++;
            }
            //当前要解决长度base-1的块，一半就是再除以2
            int half = (base - 1) / 2;
            //[L..R]的中点位置
            int mid = (L + R) / 2;
            //要旋转的左部分为 [L+half..mid],右部分为[mid+1...mid+half]
            //注意，这里arr 下标是从0开始的
            rotate(arr, L + half, mid, mid + half);
            //旋转完成后，从L 开始算起，长度为base-1的部分进行下标连续推
            cycles(arr, L, base - 1, k);
            //解决了前base-1的部分，剩下的部分继续处理
            L = L + base - 1;
        }
    }

    //从start 位置开始，往右len 的长度这一段做下标连续推
    public static void cycles(int[] arr, int start, int len, int k) {
        //找到每一个出发位置trigger,一共k 个
        // 每一个trigger 都进行下标连续推
        //出发位置是重1开始算的，而数组下标是从0开始算的
        for (int i = 0, trigger = 1; i < k; i++, trigger *= 3) {
            int preValue = arr[trigger + start - 1];
            int cur = modifyIndex2(trigger, len);
            while (cur != trigger) {
                int temp = arr[cur + start - 1];
                arr[cur + start - 1] = preValue;
                preValue = temp;
                cur = modifyIndex2(cur, len);
            }
            arr[cur + start - 1] = preValue;
        }
    }

    //[L..M] 为左部分,[M+1..R]为右部分，左右两部分互换
    public static void rotate(int[] arr, int L, int M, int R) {
        reverse(arr, L, M);
        reverse(arr, M + 1, R);
        reverse(arr, L, R);
    }

    //[L..R] 做逆序调整
    public static void reverse(int[] arr, int L, int R) {
        while (L < R) {
            int temp = arr[L];
            arr[L++] = arr[R];
            arr[R--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        shuffle(arr);
        for(int i:arr){
            System.out.print(i+",");
        }
    }

}
