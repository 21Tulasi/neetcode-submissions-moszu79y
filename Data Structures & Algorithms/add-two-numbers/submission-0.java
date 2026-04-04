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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while(l1!=null && l2!=null){
            int val=l1.val+l2.val+c;
            c=val/10;
            val=val%10;
            temp.next=new ListNode(val);
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;

        }
        while(l1!=null){
            int val=l1.val+c;
            c=val/10;
            val=val%10;
            temp.next=new ListNode(val);
            temp=temp.next;
            l1=l1.next;
        }
        while(l2!=null){
            int val=l2.val+c;
            c=val/10;
            val=val%10;
            temp.next=new ListNode(val);
            temp=temp.next;
            l2=l2.next;
        }
        if(c>0)
            temp.next=new ListNode(c);
        return ans.next;
        
    }
}
