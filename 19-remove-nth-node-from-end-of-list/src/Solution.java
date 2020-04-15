/**
 * @author tailor
 * @create 2020/4/15 - 9:21
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead  = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode removeNode = dummyHead;
        for(int i=0; i<n; i++){
            cur = cur.next;
        }
        while(cur.next != null){
            cur = cur.next;
            removeNode = removeNode.next;
        }
        removeNode.next = removeNode.next.next;
        return dummyHead.next;

    }
}
