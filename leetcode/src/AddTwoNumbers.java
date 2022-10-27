import java.util.ArrayList;
import java.util.Arrays;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     */
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> digits1 = new ArrayList<>();
        ArrayList<Integer> digits2 = new ArrayList<>();

        ListNode curr1 = l1;
        while (curr1 != null) {
            digits1.add(curr1.val);
            curr1 = curr1.next;
        }

        ListNode curr2 = l2;
        while (curr2 != null) {
            digits2.add(curr2.val);
            curr2 = curr2.next;
        }

        if (digits1.size() > digits2.size()) {
          ArrayList<Integer> temp = digits1;
          digits1 = digits2;
          digits2 = temp;
        }

         int rem;
         int total = digits1.get(0) + digits2.get(0);
         if (total >= 10) {
             rem = 1;
         } else {
             rem = 0;
         }
         ListNode result = new ListNode(total % 10);
         ListNode curr = result;

         for (int i = 1; i < digits1.size(); i++) {
             total = digits1.get(i) + digits2.get(i) + rem;
             if (total >= 10) {
                 rem = 1;
             } else {
                 rem = 0;
             }

             curr.next = new ListNode(total % 10);
             curr = curr.next;
         }

         for (int i = digits1.size(); i < digits2.size(); i++) {
             total = digits2.get(i) + rem;
             if (total >= 10) {
                 rem = 1;
             } else {
                 rem = 0;
             }

             curr.next = new ListNode(total % 10);
             curr = curr.next;
         }

         if (rem == 1) {
             curr.next = new ListNode(rem);
         }
        return result;
     }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        ListNode curr = l2;
        for (int i = 0; i < 9; i++) {
            curr.next = new ListNode(9);
            curr = curr.next;
        }

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

