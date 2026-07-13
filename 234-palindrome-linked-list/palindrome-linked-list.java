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
    public ListNode reverse(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        ListNode newHead=reverse(node.next);
        ListNode front=node.next;
        front.next=node;
        node.next=null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
       if(head==null||head.next==null){
        return true;
       } 
       ListNode slow=head,fast=head;
       while(fast.next!=null&&fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }
       ListNode newNode=reverse(slow.next);
       ListNode first=head,second=newNode;
       while(newNode!=null){
        if(first.val!=newNode.val){
            return false;
        }
        first=first.next;
        newNode=newNode.next;
       }
       return true;       
    }

}