package LinkedLists;

import CtCILibrary.MyLinkedList;

public class DeleteMiddleNode {

    public static void deleteNode(MyLinkedList.LinkedListNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
}
