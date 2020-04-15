import javafx.css.SimpleStyleableLongProperty;
import sun.reflect.generics.scope.DummyScope;

/**
 * @author tailor
 * @create 2020/4/15 - 8:48
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (left!=null && right!=null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left!=null) cur.next = left;
        if(right!=null) cur.next = right;

        return dummyHead.next;
    }
}
