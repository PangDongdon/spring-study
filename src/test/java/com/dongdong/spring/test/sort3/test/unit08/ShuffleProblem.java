package com.dongdong.spring.test.sort3.test.unit08;

public class ShuffleProblem {
    public static void shuffle(int[] arr) {
        if (arr != null && arr.length > 0 && (arr.length & 1) == 0) {
            shuffle(arr, 0, arr.length - 1);
        }
    }

    public static void shuffle(int[] arr, int l, int r) {
        while (r - l + 1 > 0) {
            int lenAndOne = r - l + 2;
            int bloom = 3;
            int k = 1;
            while (bloom <= lenAndOne / 3) {
                bloom *= 3;
                k++;
            }
            int m = (bloom - 1) / 2;
            int mid=(r+l)/2;
            rotate(arr,l+m,mid,mid+m);
            cycles(arr,l-1,bloom,k);
            l=l+bloom-1;
        }
    }
    public static void cycles(int[] arr, int base, int bloom, int k) {
        for(int i=0,trigger=1;i<k;i++,trigger*=3){
            int next=(2*trigger)%bloom;
            int cur=next;
            int record=arr[next+base];
            int tmp=0;
            arr[next+base]=arr[trigger+base];
            while(cur!=trigger){
                next=(2*cur)%bloom;
                tmp=arr[next+base];
                arr[next+base]=record;
                cur=next;
                record=tmp;
            }
        }
    }



    private static void rotate(int[] arr, int l, int m, int r) {
        reverse(arr, l, m);
        reverse(arr, l + m, r);
        reverse(arr, l, r);
    }

    private static void reverse(int[] arr, int l, int r) {
        while(l<r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        shuffle(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
