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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode curr1 = list1 , curr2 = list2 , dummy = new ListNode(), tail = dummy;

        while (curr1 != null || curr2 != null){
            if (curr2 == null || (curr1 != null && curr1.val<curr2.val)) {
                tail.next = curr1;
                tail = tail.next;
                curr1 = curr1.next;
            }else {
                tail.next = curr2;
                tail = tail.next;
                curr2 = curr2.next;
            }  
        }
        return dummy.next;
    }
}