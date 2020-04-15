import java.util.DuplicateFormatFlagsException;

/**
 * @author tailor
 * @create 2020/4/14 - 18:33
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            cur.next = l2;
        }else//(l2 == null){
            cur.next = l1;
        return dummyHead.next;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        prev.next = l1;
        ListNode temp = null;
        while (prev.next != null && l2 != null){
            if(prev.next.val >= l2.val){
                temp = l2.next;
                l2.next = prev.next;
                prev.next = l2;
                l2 = temp;
            }
            prev = prev.next;
        }
        if(l2 != null){
            prev.next = l2;
        }
        return  dummyHead.next;

    }
}
