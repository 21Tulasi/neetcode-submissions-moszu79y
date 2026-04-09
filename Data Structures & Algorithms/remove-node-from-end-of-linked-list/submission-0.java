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

        if(head==null) return head;
        if(head.next==null) return null;

        ListNode l =head;
        ListNode r=head;
        n--;

        while(n>0){
            r=r.next;
            n--;

        }
            System.out.println(r.val);
        
        while(r.next!=null && r.next.next!=null){
            l=l.next;
            r=r.next;
        }
        if(r.next==null)
            return head.next;
        ListNode re = l.next;
        l.next=l.next.next;
        re.next=null;
        return head;

    }
}
