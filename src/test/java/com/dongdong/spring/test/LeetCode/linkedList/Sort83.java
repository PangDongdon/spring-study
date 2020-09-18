package com.dongdong.spring.test.leetCode.linkedList;


/**
 * @Description:
 * @Date: 2020/9/18  16:10
 * @Author: dongdong
 */
public class Sort83 {

    public ListNode getLostNode(ListNode node){{

          ListNode curr=node;
          while(curr !=null){
              if(curr.next!=null && curr.val==curr.next.val){
                  curr.next=curr.next.next;
              }
              curr=curr.next;
          }

    }
 return null;
    }
}
