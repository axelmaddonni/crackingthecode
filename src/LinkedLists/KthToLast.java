package LinkedLists;

import CtCILibrary.MyLinkedList;

public class KthToLast {

    public static int kthToLast(MyLinkedList linkedList, int k) {
        MyLinkedList.LinkedListNode iterator = linkedList.head;
        MyLinkedList.LinkedListNode runner = linkedList.head;
        while (k > 0) {
            runner = runner.next;
            k--;
        }
        while (runner.next != null) {
            runner = runner.next;
            iterator = iterator.next;
        }
        return iterator.data;
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
        int res = kthToLast(list, 3);
        System.out.println(res);
    }
}
