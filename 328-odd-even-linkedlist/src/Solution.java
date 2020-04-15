/**
 * @author tailor
 * @create 2020/4/14 - 14:29
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode oddEvenList(ListNode head) {
        // 奇数 odd
        ListNode oddList = new ListNode(0);
        ListNode odd = oddList;
        // 偶数 even
        ListNode evenList = new ListNode(0);
        ListNode even = evenList;

        int count = 1;
        while (head != null){
            if(count%2 != 0){
                odd.next = head;
                odd = odd.next;
            }else{
                even.next = head;
                even = even.next;
            }
            count++;
            head = head.next;
        }
        even.next = null;
        odd.next = evenList.next;
        return oddList.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null){
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
