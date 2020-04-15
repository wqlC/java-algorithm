/**
 * @author tailor
 * @create 2020/4/14 - 18:05
 * @mail wql2014302721@gmail.com
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevNode = dummyHead;
        ListNode curNode = dummyHead.next;
        ListNode nextNode = curNode.next;
        boolean remove = false;
        while (curNode!=null && nextNode!= null) {
            if(curNode.val == nextNode.val){
                remove = true;
                nextNode = nextNode.next;
                curNode.next = nextNode;
            }else if(remove == true){
                curNode = curNode.next;
                nextNode = nextNode.next;
                prevNode.next = curNode;
                prevNode = prevNode.next;
                remove = false;
            }else{
                curNode = curNode.next;
                nextNode = nextNode.next;
                prevNode = prevNode.next;
            }
        }
        if(remove == true){
            prevNode.next = null;
        }
        return dummyHead.next;
    }

}
