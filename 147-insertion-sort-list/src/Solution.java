import java.util.zip.CRC32;

/**
 * @author tailor
 * @create 2020/4/14 - 22:39
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode end = dummyHead;
        ListNode cur = head;

        ListNode temp = null;
        while (cur!=null){
            if(end.val <= cur.val){
                end.next = cur;
                end = cur;
                cur = cur.next;
            }else{ // end.val > cur
                temp = cur.next;
                end.next = temp;
                while (pre.next!=null && pre.next.val<=cur.val){
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;

                pre = dummyHead;
                cur = temp;
            }
        }
        return dummyHead.next;
    }

}
