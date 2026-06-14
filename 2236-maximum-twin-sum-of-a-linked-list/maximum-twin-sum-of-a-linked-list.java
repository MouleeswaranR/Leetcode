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
    public int pairSum(ListNode head) {
        List<Integer> nums=new ArrayList<>();

        while(head!=null){
            nums.add(head.val);
            head=head.next;
        }

        int sum=Integer.MIN_VALUE;

        int i=0,j=nums.size()-1;
        while(i<j){
            sum=Math.max(sum,nums.get(i)+nums.get(j));
            i++;
            j--;
        }

        return sum;
    }
}