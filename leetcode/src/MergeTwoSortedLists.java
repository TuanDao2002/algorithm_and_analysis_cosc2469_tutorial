public class MergeTwoSortedLists {
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode result = new ListNode();
        ListNode resultCurr = result;
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        if (list1.val < list2.val) {
            resultCurr.val = list1.val;
            curr1 = curr1.next;
        } else {
            resultCurr.val = list2.val;
            curr2 = curr2.next;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                resultCurr.next = new ListNode(curr1.val);
                resultCurr = resultCurr.next;
                curr1 = curr1.next;

                continue;
            }

            resultCurr.next = new ListNode(curr2.val);
            resultCurr = resultCurr.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            resultCurr.next = new ListNode(curr1.val);
            resultCurr = resultCurr.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            resultCurr.next = new ListNode(curr2.val);
            resultCurr = resultCurr.next;
            curr2 = curr2.next;
        }

        return result;

        /* iterative way
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
        */
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
