/**
 * @author tailor
 * @create 2020/4/14 - 18:00
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        // 使用虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
    // 使用递归解法
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements2(head.next, val);
        if(head.val == val)
            return head.next;
        else{
            return head;
        }
    }
}