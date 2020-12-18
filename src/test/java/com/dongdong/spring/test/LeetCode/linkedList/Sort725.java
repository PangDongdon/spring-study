package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

/**
 * @Description: 分隔链表
 * @Date: 2020/12/14  17:42
 * @Author: dongdong
 */
public class Sort725 {

    public  ListNode  ListNode(ListNode root,int n){
        int count=0;
        if(root==null){
            return  null;
        }
        //明确当前联链表数量
        while(root!=null){
            root=root.next;
            count++;
        }
        if(count==n){
            ListNode node=null;
            while (root!=null){
              node=root;
              node.next=null;
              root=root.next;
            }
            return  node;
        }else if(count>n){
            if(count%n==0){
               int s=count/n;
               int m=0;
                while(root!=null){
                    root=root.next;
                    m++;
                    if(m==s){
                        ListNode v=root;
                        v.next=null;
                        m=0;
                    }
                }
            }else{


            }
        }else if(count<n){
             while(root!=null){
                 ListNode d=root;
                 d.next=null;
                 root=root.next;
             }
             int c=n-count;
             for(int i=0;i<c;i++){
                 ListNode h=new ListNode(-1);
                 ListNode cc=h.next=null;
             }
        }
        return  null;
    }

    @Test
    public void test(){
        System.out.println(5%2);
    }
     public  ListNode[] splitListToParts(ListNode root,int k){//5 2
           int len=getLength(root);
           int aveSize=len/k; //2
           int extra=len%k;//1
           ListNode[] result=new ListNode[k];
           for(int i=0;i<k;i++){//2
               result[i]=root;
               int aveSizeTmp=aveSize;//2
               aveSizeTmp+=extra-->0?1:0;//1
               int aveSizeTmp2=aveSizeTmp;//1
               while(aveSizeTmp-->0){
                   root=root.next;
               }
               if(result[i]!=null){
                   ListNode tmp=result[i];
                   while(tmp.next!=null && aveSizeTmp2-->1){
                       tmp=tmp.next;
                   }
                   tmp.next=null;
               }
           }
           return  result;
     }

     private int getLength(ListNode root){
        int len=0;
        ListNode tmp=root;
        while(tmp!=null){
            len++;
            tmp=tmp.next;
        }
        return  len;
     }

     public ListNode[]  splitListToParts2(ListNode root,int k){ //1->2->3->4->5
        int len =getLength(root);//5  k=2
        int aveSize=len/k; //2
        int extra=len%k;//1
        ListNode[] result=new ListNode[k];
        ListNode prev=null;
        for(int i=0;i<k;i++,extra--){
            result[i]=root;
            for(int j=0;j<aveSize+(extra>0?1:0);j++){
                prev=root;
                root=root.next;
            }
            if(prev!=null){
                prev.next=null;
            }
        }
        return  result;
     }

}
