import sun.awt.image.ImageWatched;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tailor
 * @create 2020/4/14 - 14:11
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode minList = new ListNode(0);
        ListNode maxList = new ListNode(0);

        ListNode min = minList;
        ListNode max = maxList;

        while (head != null){
            if(head.val < x){
                min.next = head;
                min = min.next;
            }else {
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        max.next = null;
        min.next = maxList.next;
        return minList.next;
    }
}
