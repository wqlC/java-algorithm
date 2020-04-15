import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.List;

/**
 * @author tailor
 * @create 2020/4/14 - 12:21
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        int count = 1;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (count<m){
            prev = cur;
            cur = cur.next;
            count++;
        }
        ListNode tempPrev = prev;
        ListNode tempCur  = cur;
        // 以cur为头节点反转
        while(count <= n){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        if(tempPrev!=null)
            tempPrev.next = prev;
        else
            head = prev;
        tempCur.next = cur;

        return head;
    }
}
