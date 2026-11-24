
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nodeBeforeSublist = null;
        ListNode nodeAfterSublist = null;
        ListNode sublistTail = null;
        ListNode sublistHead = null;
        ListNode newHead = null;
        int position = 1;

        while(curr != null){
            if(position == left){
                nodeBeforeSublist = prev;
                sublistHead = curr;
            }

            if(position == right){
                sublistTail = curr;
                nodeAfterSublist = curr.next;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        if(left == 1){
            reverse(head, sublistTail);
            head = sublistTail;
            sublistHead.next = nodeAfterSublist;
        }else{
            reverse(nodeBeforeSublist.next, sublistTail);
            nodeBeforeSublist.next = sublistTail;
            sublistHead.next = nodeAfterSublist;
        }

        return head;
    }

    private void reverse(ListNode left,ListNode right){
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = left;

        while(prev != right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
