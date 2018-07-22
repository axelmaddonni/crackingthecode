package LinkedLists;

//Palindrome: Implement a function to check if a linked list is a palindrome.
//        Hints: #5, #13, #29, #61, #101

import CtCILibrary.MyLinkedList.LinkedListNode;

import java.util.Stack;

public class Palindrome {
    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();

//      * Push elements from first half of linked list onto stack. When fast runner
//      * (which is moving at 2x speed) reaches the end of the linked list, then we
//      * know we're at the middle *1
        while (fast != null && fast. next != null) {
            stack.push(slow.data);
            slow = slow. next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow. next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();

//          * If values are different, then it's not a palindrome *1
            if (top != slow.data) {
                return false;
            }
            slow = slow. next;
        }
        return true;
    }
}