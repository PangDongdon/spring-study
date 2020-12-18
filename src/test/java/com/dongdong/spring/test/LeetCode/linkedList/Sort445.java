package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Description: two  number sum
 * @Date: 2020/12/14  14:41
 * @Author: dongdong
 */
public class Sort445 {

    public ListNode  getTwoNumberSum(ListNode L1,ListNode L2){   //7->2->1  4->5->6
        Deque<Integer> stack1=popIntoStack(L1);
        Deque<Integer> stack2=popIntoStack(L2);
        int sum=0;
        ListNode listNode=new ListNode(0);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()){
                sum+=stack1.removeFirst();
            }
            if(!stack2.isEmpty()){
                sum+=stack2.removeFirst();
            }
            listNode.val=sum%10;
            ListNode head=new ListNode(sum/10);
            head.next=listNode;
            listNode=head;
            sum/=10;
        }
        return  listNode.val==0 ? listNode.next:listNode;
    }

    //入栈
    private Deque<Integer>  popIntoStack(ListNode head){
        ListNode tmp=head;
        Deque<Integer> stack=new ArrayDeque<>();
        while(tmp !=null){
            stack.push(tmp.val);
            tmp=tmp.next;
        }
        return  stack;
    }


    //method 2
    public  ListNode addTwoNumbers(ListNode L1,ListNode L2){
        Stack<Integer> stack1=popOntoStack(L1);
        Stack<Integer> stack2=popOntoStack(L2);
        Stack<Integer> resultStack=add(stack1,stack2);
        return  buildResult(resultStack);
    }
    private ListNode  buildResult(Stack<Integer>stack){ //1->2->3  栈：3 2 1     -1(prev)-> 6(head--next) 4 2
        ListNode prev=new ListNode(-1);
        ListNode head=new ListNode(stack.pop());
        prev.next=head;
        while(!stack.isEmpty()){
            head.next=new ListNode(stack.pop());
            head=head.next;
        }
        return prev.next;
    }


    private Stack<Integer> add(Stack<Integer> s1,Stack<Integer> s2){
        Stack<Integer> res=new Stack<>();
        int carry=0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                carry+=s1.pop();
            }
            if(!s2.isEmpty()){
                carry+=s2.pop();
            }
            int value=carry;
            if(carry>9){
                value=carry%10;
                carry=1;
            }else{
                carry=0;
            }
            res.push(value);
        }
        if(carry!=0){
            res.add(carry);
        }
        return res;
    }

    private Stack<Integer>  popOntoStack(ListNode head){
        ListNode temp=head;
        Stack<Integer> stack=new Stack<>();
        while(temp !=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        return  stack;
    }

    @Test
    public void  tess(){
        ListNode node1=new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(3);

        ListNode node2=new ListNode(1);
        node2.next=new ListNode(2);
        node2.next.next=new ListNode(3);

        System.out.println(addTwoNumbers(node1,node2).val);
    }

}
