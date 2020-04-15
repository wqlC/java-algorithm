import javax.print.attribute.standard.OrientationRequested;

/**
 * @author tailor
 * @create 2020/4/15 - 9:53
 * @mail wql2014302721@gmail.com
 */
public class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // 1 2 3 4 5
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0){
            return head;
        }

        int length = 1;// 链表长度
        ListNode tail = head;
        for (; tail.next!=null; tail = tail.next){
            length++;
        }
        int temp = k%length;
        if(temp == 0){
            return head;
        }
        ListNode prev = head;
        for (int i = 0; i < length-temp-1; i++) {// 到新的头节点的前一个位置
            prev = prev.next;
        }

        ListNode newHead = prev.next;
        prev.next = null;
        tail.next = head;
        return newHead;
    }
}
