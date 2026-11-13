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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head ;
        int length = 0 ;

        //getting the length
        while (curr!=null){
            curr = curr.next;
            length ++;
        }
        if (length == n){
            head=head.next;
            return head;
        }
        curr = head;
        ListNode prevNode = null;

        for (int i = 0; i < length - n - 1; i++) {
            curr = curr.next;
        }
        prevNode = curr;
        curr = curr.next;

        prevNode.next = curr.next;
        return head;
    }
}

