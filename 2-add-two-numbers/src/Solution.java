/**
 * @author tailor
 * @create 2020/4/14 - 14:56
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int dec = 0;
        int temp = 0;
        int sum = 0;
        while (l1!=null && l2!=null){
            sum = dec + l1.val + l2.val;
            dec = sum/10;
            temp = sum%10;
            cur.next = new ListNode(temp);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            sum = dec + l1.val;
            dec = sum/10;
            temp = sum%10;
            cur.next = new ListNode(temp);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2!=null){
            sum = dec + l2.val;
            dec = sum/10;
            temp = sum%10;
            cur.next = new ListNode(temp);
            cur = cur.next;
            l2 = l2.next;
        }
        if(dec != 0){
            cur.next = new ListNode(dec);
        }
        return head.next;
    }

}
