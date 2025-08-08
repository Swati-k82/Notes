package main.dsa.twoPointers;
/*
https://leetcode.com/problems/linked-list-cycle/description/?envType=problem-list-v2&envId=two-pointers
https://leetcode.com/problems/linked-list-cycle-ii/description/?envType=problem-list-v2&envId=two-pointers
Floyd's Cycle Detection Algorithm (Tortoise and Hare):
Detection:
If a cycle exists, the fast pointer will eventually "catch up" to and meet the slow pointer within the cycle. If there's no cycle, the fast pointer will reach the end of the sequence (e.g., NULL in a linked list).
Finding Cycle Start:
Once the pointers meet, reset one pointer to the beginning of the sequence and move both pointers one step at a time. The point where they meet again is the start of the cycle.


 */
public class LinkedListCycleII {
    class ListNode {
     int val;
    ListNode next;
     ListNode(int x) {
         val = x;
          next = null;
     }
  }

    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr= slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr==fastPtr)
                break;
        }

        if(fastPtr==null || fastPtr.next==null)
            return null;

        slowPtr = head;
        while(slowPtr!=fastPtr){
            slowPtr= slowPtr.next;
            fastPtr= fastPtr.next;
        }
        return slowPtr;
    }
}
