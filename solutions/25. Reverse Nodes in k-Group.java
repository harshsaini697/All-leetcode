/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        
        while(true){
            ListNode p = start;
            start = p.next;
            ListNode end = p;
            for(int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null) break;
            for(int i = 0; i < k - 1; i++){ // 0, 1
                ListNode temp = p.next;
                p.next = temp.next;
                temp.next = end.next;
                end.next = temp;
            }
        }
        return dummy.next;
    }
}
