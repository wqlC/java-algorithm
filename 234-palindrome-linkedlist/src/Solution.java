import java.time.chrono.HijrahEra;
import java.time.temporal.Temporal;

/**
 * @author tailor
 * @create 2020/4/15 - 11:22
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome2(ListNode head) {
        if (head==null || head.next==null){
            return true;
        }
        ListNode slow =head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverseList(slow.next);
        while (head2!=null){
            if(head.val != head2.val) return false;
            else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next ;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // 使用递归
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
