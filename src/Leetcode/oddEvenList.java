package Leetcode;

/**
 * Created by qiuying on 2021/1/21.
 */
public class oddEvenList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }


    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next  = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }



}

