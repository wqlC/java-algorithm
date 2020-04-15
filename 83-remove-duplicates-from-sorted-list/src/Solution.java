/**
 * @author tailor
 * @create 2020/4/14 - 12:47
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while (cur.next!=null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
}
