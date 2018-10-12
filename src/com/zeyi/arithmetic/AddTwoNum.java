package com.zeyi.arithmetic;

/**
 *
 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class AddTwoNum {
    public static void main(String args[]){
        ListNode l1 = new ListNode(9);
     /*   l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);*/

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);


        addTwoNumbers(l1,l2);
    }

    /**
     * 转发成数字会出现问题，因为int的长度问题
     * @param l1
     * @param l2
     * @return
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
/*
        long num1= l1.val;
        int i = 1;
        while (true){
            i = i*10;
            if (l1.next==null){
                break;
            }
            l1 = l1.next;
            num1 = num1+ l1.val*i;
            if (l1.next==null){
                break;
            }

        }

        long num2= l2.val;
        int j = 1;
        while (true){
            j= j*10;
            if (l2.next==null){
                break;
            }
            l2 = l2.next;
            num2 = num2+ l2.val*j;
            if (l2.next==null){
                break;
            }

        }

        long num = num1+num2;
        int y = (int) (num%10);
        int k = 1;
        ListNode listNode = new ListNode(y);
        ListNode listNode1 = listNode;
        while (true){
            k=k*10;
           long z = num/k;
           int v = (int) (z %10);
           if (z!=0) {
               listNode.next = new ListNode(v);
           }
           if (z>=10){

               listNode = listNode.next;
           }else{
               break;
           }
        }
      return listNode1;*/



        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }




    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}


