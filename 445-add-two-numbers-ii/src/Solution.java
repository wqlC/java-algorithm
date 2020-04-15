import java.util.Stack;

/**
 * @author tailor
 * @create 2020/4/14 - 15:15
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode head = reverseList(addTwoNumbersI(l1, l2));
        return head;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
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

    // 使用栈
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry>0){
            int sum = 0;
            sum += stack1.isEmpty()? 0 : stack1.pop();
            sum += stack2.isEmpty()? 0 : stack2.pop();
            sum += carry;
            carry = sum/10;

            ListNode temp = new ListNode(sum%10);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    // 使用递归-给长度短的补0；
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        // TODO
        return null;
    }
}
