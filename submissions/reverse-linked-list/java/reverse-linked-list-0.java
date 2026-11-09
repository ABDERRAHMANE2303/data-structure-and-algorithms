/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;

        while (curr != null){
            if (curr == head){
                prev = curr;
                curr.next = null;
                curr = next;
            }else {
        // ex : node2 (val2,next==node3) | prev == node1(val1,null), curr == node2,next ==curr
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
        // becomes : curr = node3(val3,node4), next  = node3 , curr.next = pev, prev = node2
            }
        }
        return prev;
    }
}