import java.util.function.Predicate;

/**
 * @author tailor
 * @create 2020/4/14 - 22:06
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode end = dummyHead;
        while (end.next != null){
            for (int i = 0; i<k&&end!=null; i++) {
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode startNode = prev.next;
            ListNode nextNode = end.next;
            end.next = null;
            prev.next = reverseList(startNode);

            // 开始的节点变成最后一个节点了
            startNode.next = nextNode;
            prev = startNode;
            end = prev;
        }


        return dummyHead.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return cur;
    }
}
