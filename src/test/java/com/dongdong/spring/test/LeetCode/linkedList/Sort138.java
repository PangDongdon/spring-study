package com.dongdong.spring.test.leetCode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:  复制带随机指针的链表
 * @Date: 2020/10/20  17:12
 * @Author: dongdong
 */
public class Sort138 {

    public  RandomListNode copyRandomList(RandomListNode head){
        Map<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode node=head;
        while(node !=null){
            map.put(node,new RandomListNode(node.label));
            node=node.next;
        }
        node=head;
        while(node!=null){
            map.get(node).next=map.get(node.next);
            map.get(node).random=map.get(node.random);
            node=node.next;
        }
        return  map.get(head);
    }


}
