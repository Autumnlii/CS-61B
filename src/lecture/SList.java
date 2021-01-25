package lecture;

/**
 * Created by qiuying on 2021/1/21.
 *
 * Why private？
 * Why nested class?
 *  * It is useful when class doesn't stand on its ownnad is subordinate to another class
 *  ** make the nested class private if other classes should never use the nested class
 *  ** make nested class static private if it never uses any of SList's instance variables or methods
 *
 *
 *  About Sentinel:
 *      1. sentinel is never null, always points to sentinel node
 *      2. sentinel node's item needs to be some integer, but doesn't matter what value we pick
 *      3. had to fix constructor and methods to be compatible with sentinel
 *      4. with sentinel, there's no need for a special case to check if sentinel is null
 *
 * Invariant:
 *      1. An invariant is a condition that is guaranteed to be true during code execution -assume no bugs
 *      2. A SList with a sentinel node has following invariants:
 *          - The sentinel reference always points to a sentinel node
 *          - The first node(if exists), is always at sentinel.next
 *          -the size variale is always the total number of the items that have been added
 *      3. Invariants make it easier to reason about code:
 *          - Can assume they are true to simplify code, like no need to worry about the nulls
 *          - Must ensure that methods preseve invariants
 *
 */


public class SList {

    public static void main (String[] args) {
        SList l = new SList(10);
        l.addFirst(10);
        l.addFirst(5);
        l.addLast(9);
        System.out.println(l.getFirst());
        System.out.println(l.size());

        SList b = new SList();
        b.addFirst(10);
        b.addFirst(5);
        b.addLast(9);
        System.out.println(b.getFirst());
        System.out.println(b.size());

        IntNode test = new IntNode(5, null);
        System.out.println(l.oddEvenList(test));

    }

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    } // ListNode can be a seperated class, or it can be the nested class


    // Constructor:

    //private IntNode first; // use private keyword to prevent change of code in other class

    private int size;
    private IntNode sentinel;

    public SList() { // create an empty SList
        sentinel = new IntNode(63,null);
        size = 0;
    }


    public SList(int x) {
        sentinel = new IntNode(63,null);
        sentinel.next = new IntNode(x, null); // first node is always the sentinel.next

    }



    public int getFirst () {
        return sentinel.next.item;
    }



    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel);
        size += 1;
    }

    public void addLast(int x) {
        IntNode p = sentinel.next;

        while( p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    // we need a recursive helper function for the size method;
    // but this method will be very slow, then we need a new method
//    private static int size(IntNode p){
//        if(p.next == null) {
//            return 1;
//        }
//        return 1+ size(p.next);
//    }
//
//    public int size( ) {
//        return size(first);
//
//    }


    // This is cache: putting aside data to speed up retrieval

    public int size() {
        return size;
    }

    public IntNode oddEvenList(IntNode head) {
        if(head == null) {
            return null;
        }
        IntNode odd = head;
        IntNode even = head.next;
        IntNode evenhead = even;

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
