import jdk.nashorn.internal.ir.WhileNode;

import java.util.Scanner;

/**
 * @author tailor
 * @create 2020/4/14 - 19:01
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode firstNode = null;
        ListNode secondNode = null;
        while (prev.next!=null && prev.next.next!=null){
            firstNode = prev.next;
            secondNode = prev.next.next;
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prev = firstNode; // 第一个节点变成了第二个节点。
        }
        return dummyHead.next;
    }
}
