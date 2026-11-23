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
    int newCarry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode newList = new ListNode(0);
        ListNode start = newList;
        ListNode ans = newList;

        while(curr1 != null && curr2 != null){
            ListNode newNode = sum(curr1 , curr2 , newCarry);
            start.next = newNode;
            start = newNode;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if(curr1 != null){
            while(curr1 != null){
                ListNode newNode = sum(curr1 , curr2 , newCarry);
                start.next = newNode;
                start = newNode;
                curr1 = curr1.next;
            }
        }

        if(curr2 != null){
            while(curr2 != null){
                ListNode newNode = sum(curr1 , curr2 , newCarry);
                start.next = newNode;
                start = newNode;
                curr2 = curr2.next;
            }
        }

        if(curr1 == null && curr2 == null && newCarry != 0){
            ListNode lastOne = new ListNode(newCarry);
            start.next = lastOne;
            start = start.next;
        }

        return ans.next;
    }

    private ListNode sum(ListNode l1, ListNode l2,int prevCarry){
        ListNode newNode = new ListNode(0);

        if(l1 != null && l2 != null){

            int val = l1.val + l2.val + prevCarry;
            
            newCarry = val/10;
            newNode.val = val % 10;
            
            return newNode;
        }
        else if(l1 != null){
            int val = l1.val + prevCarry;
            
            newCarry = val/10;
            newNode.val = val % 10;
            
            return newNode;
        }
        else{
            int val = l2.val + prevCarry;
            
            newCarry = val/10;
            newNode.val = val % 10;
            
            return newNode;
        }
    }
}
