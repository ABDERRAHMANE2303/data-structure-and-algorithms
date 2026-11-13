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
        if (head == null || head.next == null ) return null;
        ListNode curr = head , prevNode =null;
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

        //getting to the Nth node from the end
        for (int i=0 ; i< length - n ; i++) {
            if (i == length-n-1) {
                prevNode = curr;
            }
            curr = curr.next;
        }
        prevNode.next = curr.next;
        return head;

    }
}

