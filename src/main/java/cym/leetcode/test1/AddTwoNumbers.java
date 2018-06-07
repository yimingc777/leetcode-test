package cym.leetcode.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * Date time: 2018/6/6 16:23
 * Author: yiming.chen@navercorp.com
 * Description:
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        addTwoNumbers(listNode1, listNode2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = getValue(l1) + getValue(l2);
        return toListNode(value);
    }

    private static int getValue(ListNode listNode) {
        int r = 0;
        double x = listNode.val * Math.pow(10.0, r);
        while (listNode.next != null) {
            r++;
            listNode = listNode.next;
            x = x + listNode.val * Math.pow(10.0, r);
        }
        return (int) x;
    }
    private static ListNode toListNode(int value) {
        int r = String.valueOf(value).length();

        List<ListNode> list = new ArrayList<>(r);
        list.add(new ListNode(value % 10));
        for (int i = 1; i < r; i++) {
            value = value / 10;
            list.add(new ListNode(value % 10));
        }
        for (int i = 0; i < r; i++) {
            if (i == r -1) {
                break;
            }
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }



}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}