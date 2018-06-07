package cym.leetcode.test1;

import java.math.BigDecimal;

/**
 * Date time: 2018/6/6 16:23
 * Author: yiming.chen@navercorp.com
 * Description:
 */
public class AddTwoNumbers {

    private static final BigDecimal BASE_BIG_DECIMAL = new BigDecimal(10);

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
//        System.out.println(addTwoNumbers(listNode1, listNode2));
        System.out.println(addTwoNumbers2(listNode1, listNode2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal bigDecimal1 = getValue(l1);
        BigDecimal bigDecimal2 = getValue(l2);
        BigDecimal value = bigDecimal1.add(bigDecimal2);
        return toListNode(value);
    }

    private static BigDecimal getValue(ListNode listNode) {
        int r = 0;
        BigDecimal x = BigDecimal.valueOf(listNode.val).multiply(BASE_BIG_DECIMAL.pow(r));
        while (listNode.next != null) {
            r++;
            listNode = listNode.next;
            x = x.add(BigDecimal.valueOf(listNode.val).multiply(BASE_BIG_DECIMAL.pow(r)));
        }
        return x;
    }
    private static ListNode toListNode(BigDecimal value) {
        int r = String.valueOf(value).length();
        ListNode result = new ListNode(value.divideAndRemainder(BASE_BIG_DECIMAL)[1].intValue());
        ListNode temp = result;
        for (int i = 1; i < r; i++) {
            value = value.divide(BASE_BIG_DECIMAL, BigDecimal.ROUND_DOWN);
            temp.next = new ListNode(value.divideAndRemainder(BASE_BIG_DECIMAL)[1].intValue());
            temp = temp.next;
        }
        return result;
    }

    /**
     * coding this after mine acceptted
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int l1v, l2v, sum;
        int carry = 0;
        int remainder = 10;
        while (l1 != null || l2 != null) {
            l1v = l1 == null ? 0 : l1.val;
            l2v = l2 == null ? 0 : l2.val;
            sum = l1v + l2v + carry;
            if (sum >= remainder) {
                temp.next = new ListNode(sum - remainder);
                carry = 1;
            } else {
                temp.next = new ListNode(sum);
                carry = 0;
            }
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(1);
        }
        return result.next;
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(val);
        while(next != null) {
            sb.append(", ").append(next.val);
            next = next.next;
        }
        return sb.append("]").toString();
    }
}