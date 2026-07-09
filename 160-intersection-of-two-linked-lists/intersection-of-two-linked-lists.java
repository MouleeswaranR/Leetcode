/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if(head1==null||head2==null){
            return null;
        }
        ListNode t1=head1,t2=head2;
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if(t1==t2){
                return t1;
            }
            if(t1==null){
                t1=head2;
            }
            if(t2==null){
                t2=head1;
        }

        }
        return t1;
    }
}