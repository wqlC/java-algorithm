/**
 * @author tailor
 * @create 2020/4/15 - 10:54
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next==null || head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }// slow 为中间节点

        ListNode head2 = reverseList(slow.next);
        slow.next = null;
        ListNode cur = head;
        ListNode temp ;
        while (cur !=null && head2!=null){
            temp = head2.next;
            head2.next = cur.next;
            cur.next = head2;
            cur = cur.next.next;
            head2 = temp;
        }
        return;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp;
        while (cur!=null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        // printList(prev);
        return prev;
    }

    private void printList(ListNode prev) {
        ListNode cur = prev;
        while (cur!=null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
