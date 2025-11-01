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
    public ListNode modifiedList(int[] nums, ListNode head) {
        BitSet excludeVal=new BitSet();
        for(int num:nums)excludeVal.set(num);
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;

        while(curr.next!=null){
            if(excludeVal.get(curr.next.val)){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }

        return dummy.next;
    }
}