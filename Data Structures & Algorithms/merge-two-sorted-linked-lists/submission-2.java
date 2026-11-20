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

        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        ListNode ans = new ListNode(0);
        ListNode tail = ans;

        while(curr1 != null && curr2 != null){

            if(curr2.val < curr1.val){
                tail.next = curr2;
                tail = curr2;
                curr2 = curr2.next;
            }
            else{
                tail.next = curr1;
                tail = curr1;
                curr1 = curr1.next;
            }
        }

        if(curr1 == null){
            while(curr2 != null){
                tail.next = curr2;
                tail = curr2;
                curr2 = curr2.next; 
            }
        }

        if(curr2 == null){
            while(curr1 != null){
                tail.next = curr1;
                tail = curr1;
                curr1 = curr1.next;
            }
        }

        return ans.next;
    }
}