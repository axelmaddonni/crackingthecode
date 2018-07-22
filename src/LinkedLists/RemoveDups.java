package LinkedLists;

import CtCILibrary.MyLinkedList;

public class RemoveDups {

    public static void removeDups(MyLinkedList linkedList) {
        MyLinkedList.LinkedListNode head = linkedList.head;
        while (head.next != null) {
            MyLinkedList.LinkedListNode previous = head;
            MyLinkedList.LinkedListNode iterator = head.next;
            while (iterator != null) {
                if (iterator.data == head.data) {
                    previous.setNext(iterator.next);
                    if (iterator.next == null) {
                        linkedList.last = previous;
                    }
                    linkedList.size--;
                } else {
                    previous = previous.next;
                }
                iterator = previous.next;
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);
        list.print();
        removeDups(list);
        list.print();
        System.out.println(list.size);
        System.out.println(list.head.data);
        System.out.println(list.last.data);
    }
}
