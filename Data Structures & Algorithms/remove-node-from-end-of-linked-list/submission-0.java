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
        ListNode curr = head;
        ListNode prev = null;
        int count = 0;

        while(curr != null){
            prev = curr;
            curr = curr.next;
            count++;
        }

        curr = head;
        prev = null;

        int times = count - n;

        if(times == 0){
            head = head.next;
        }
        else{
            while(times > 0){
                prev = curr;
                curr = curr.next;
                times--;
            }

            prev.next = curr.next;
        }

        return head;

    }
}
