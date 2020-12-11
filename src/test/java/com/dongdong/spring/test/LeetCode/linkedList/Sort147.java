package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 对链表进行插入排序
 * @Date: 2020/12/2  14:06
 * @Author: dongdong
 */
public class Sort147 {
    //4->2->1->3
    //1->2->3->4

    public ListNode  insertSort(ListNode head){
        ListNode temp=head;
        //节点数据收集
        List<Integer>  list=new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        //转化为数组冒泡排序
       Integer[] nums=list.toArray(new Integer[list.size()]);
      /*  for(int s:nums){
            System.out.println(s);
        }*/
       for(int i=0;i<nums.length-1;i++){
           for(int j=0;j<nums.length-i-1;j++){
               if(nums[j]>nums[j+1]){
                   Integer temp1=nums[j+1];
                   nums[j+1]=nums[j];
                   nums[j]=temp1;
               }
           }
       }
       //重新生成链表
        ListNode head1=head;
        for(int i=0;i<nums.length;i++){
           head1.val=nums[i];
           head1=head1.next;
        }
      // System.out.println(head.val);
       return head;
    }


    @Test
    public void test(){
       ListNode node=new ListNode(4);
       node.next=new ListNode(3);
       node.next.next=new ListNode(2);
       node.next.next.next=new ListNode(1);
       System.out.println("sort before:"+node.val);
       ListNode node1= insertSort(node);
       System.out.println("sort after:"+node1.val);
    }

    public void sort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    Integer temp1=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp1;
                }
            }
        }
    }

    @Test
    public void  test1(){
        int[] ss={4,3,2,1};
        sort(ss);
        for(int s:ss){
            System.out.println(s);
        }
    }


}
