package LinkedLists;

import CtCILibrary.MyLinkedList;

public class Partition {

    public static MyLinkedList partition(MyLinkedList linkedList, int k) {
        MyLinkedList.LinkedListNode beforeHead = null;
        MyLinkedList.LinkedListNode beforeIterator = null;

        MyLinkedList.LinkedListNode afterHead = null;
        MyLinkedList.LinkedListNode afterIterator = null;

        MyLinkedList.LinkedListNode iterator = linkedList.head;

        while (iterator != null) {
            if (iterator.data < k) {
                if (beforeHead == null) {
                    beforeHead = iterator;
                    beforeIterator = beforeHead;
                } else {
                    beforeIterator.setNext(iterator);
                    beforeIterator = beforeIterator.next;
                }
            } else {
                if (afterHead == null) {
                    afterHead = iterator;
                    afterIterator = afterHead;
                } else {
                    afterIterator.setNext(iterator);
                    afterIterator = afterIterator.next;
                }
            }
            iterator = iterator.next;
        }

        beforeHead.prev = null;
        afterIterator.next = null;
        beforeIterator.setNext(afterHead);
        return new MyLinkedList(beforeHead);
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
        MyLinkedList res = partition(list, 3);
        res.print();
    }
}
