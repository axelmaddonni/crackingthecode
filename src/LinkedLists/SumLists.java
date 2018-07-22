package LinkedLists;

import CtCILibrary.MyLinkedList;

public class SumLists {

    public static MyLinkedList sumLists(MyLinkedList listA, MyLinkedList listB) {
        MyLinkedList.LinkedListNode sumHead = null;
        MyLinkedList.LinkedListNode sumIterator = null;

        MyLinkedList.LinkedListNode iteratorA = listA.head;
        MyLinkedList.LinkedListNode iteratorB = listB.head;
        int acum = 0;

        while (iteratorA != null && iteratorB != null) {

            int digitSum = iteratorA.data + iteratorB.data;
            MyLinkedList.LinkedListNode sumNode = new MyLinkedList.LinkedListNode((digitSum + acum) % 10);
            if (sumHead == null) {
                sumHead = sumNode;
                sumIterator = sumHead;
            } else {
                sumIterator.setNext(sumNode);
                sumIterator = sumIterator.next;
            }

            if (digitSum + acum > 9) {
                acum = 1;
            } else {
                acum = 0;
            }

            iteratorA = iteratorA.next;
            iteratorB = iteratorB.next;
        }

        MyLinkedList.LinkedListNode iterator = (iteratorA != null) ? iteratorA : iteratorB;
        while (iterator != null) {

            int digitSum = iterator.data;
            MyLinkedList.LinkedListNode sumNode = new MyLinkedList.LinkedListNode((digitSum + acum) % 10);
            if (sumHead == null) {
                sumHead = sumNode;
                sumIterator = sumHead;
            } else {
                sumIterator.setNext(sumNode);
                sumIterator = sumIterator.next;
            }

            if (digitSum + acum > 9) {
                acum = 1;
            } else {
                acum = 0;
            }

            iterator = iterator.next;
        }

        return new MyLinkedList(sumHead);
    }


    private static void padWithZeros(MyLinkedList linkedList, int n) {
        for (int i = 0; i < n; i++) {
            linkedList.insertBefore(0);
        }
    }

    public static MyLinkedList sumListsOrdered(MyLinkedList listA, MyLinkedList listB) {
        MyLinkedList longer = (listA.size > listB.size) ? listA : listB;
        MyLinkedList shorter = (listA.size > listB.size) ? listB : listA;
        padWithZeros(shorter, longer.size - shorter.size);

        listA.print();
        listB.print();

        PartialSum partialSum = sumListsOrderedHelper(listA.head, listB.head, new PartialSum());
        if (partialSum.carry > 0) {
            partialSum.sum.insertBefore(1);
        }
        return partialSum.sum;
    }

    private static class PartialSum {
        MyLinkedList sum;
        int carry;

        public PartialSum(MyLinkedList linkedList, int val) {
            sum = linkedList;
            carry = val;
        }

        public PartialSum() {
            sum = new MyLinkedList();
            carry = 0;
        }
    }

    private static PartialSum sumListsOrderedHelper(MyLinkedList.LinkedListNode listA, MyLinkedList.LinkedListNode listB, PartialSum partialSum) {

        if (listA.next == null && listB.next == null) {
            return new PartialSum(new MyLinkedList(new MyLinkedList.LinkedListNode(listA.data + listB.data % 10)), (listA.data + listB.data) / 10);
        }

        PartialSum partialSumRec = sumListsOrderedHelper(listA.next, listB.next, partialSum);

        int value = listA.data + listB.data + partialSumRec.carry;
        partialSumRec.sum.insertBefore(value % 10);
        return new PartialSum(partialSumRec.sum, value / 10);
    }


    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        list1.add(1);
        list1.add(4);
        list1.add(2);
        list1.print();

        MyLinkedList list2 = new MyLinkedList();
        list2.add(3);
        list2.add(5);
        list2.add(1);
        list2.add(2);
        list2.print();

        MyLinkedList sum = sumListsOrdered(list1, list2);
        sum.print();
    }
}
