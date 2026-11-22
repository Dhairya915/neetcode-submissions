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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode secondHalf = null;
        ListNode start = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            secondHalf = reverseList(slow);
        } else {
            secondHalf = reverseList(slow.next);
        }

        arrangePair(start, secondHalf);
    }

    private void arrangePair(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        ListNode list1Prev = null;
        ListNode list2Prev = null;

        while (curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            list1Prev = curr2;
            list2Prev = curr1;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }

        if (curr1 != null) {
            list1Prev.next = curr1;
            curr1.next = null;
        } else {
            list2Prev.next = null;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
