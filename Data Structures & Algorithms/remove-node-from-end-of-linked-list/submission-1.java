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
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        ListNode tempMinusN = dummy;

        for (int i = 0; i <= n; i++) {
            temp = temp.next;
        }

        while (temp != null) {
            temp = temp.next;
            tempMinusN = tempMinusN.next;
        }
        tempMinusN.next = tempMinusN.next.next;
        return dummy.next;
    }
}
