package CtCILibrary;

public class MyGenericLinkedList<T> {
    public LinkedListNode head;
    public LinkedListNode last;
    public int size;

    public MyGenericLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public MyGenericLinkedList(LinkedListNode node) {
        head = node;
        last = node;
        size = 1;
        while (last.next != null) {
            last = last.next;
            size++;
        }
    }

    public LinkedListNode<T> add(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);
        if (size == 0) {
            head = node;
            last = head;
        } else {
            last.setNext(node);
            last = last.next;
        }
        size++;
        return node;
    }

    public void print() {
        if (head != null) {
            System.out.println(head.printForward());
        } else {
            System.out.println("[]");
        }
    }

    public void insertBefore(T data) {
        LinkedListNode node = new LinkedListNode(data);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public T removeFirst() {
        T elem = (T) head.data;
        head = head.next;
        return elem;
    }

    public void removeNode(LinkedListNode<T> pointer) {
        if (pointer == head) {
            head = pointer.next;
        }
        if (pointer == last) {
            last = pointer.prev;
        }
        pointer.prev.next = pointer.next;
        pointer.next.prev = pointer.prev;
        size--;
    }

    public static class LinkedListNode<T> {
        public LinkedListNode next;
        public LinkedListNode prev;
        public LinkedListNode last;
        public T data;
        public LinkedListNode(T d, LinkedListNode n, LinkedListNode p) {
            data = d;
            setNext(n);
            setPrevious(p);
        }

        public LinkedListNode(T d) {
            data = d;
        }

        public LinkedListNode() { }

        public void setNext(LinkedListNode n) {
            next = n;
            if (this == last) {
                last = n;
            }
            if (n != null && n.prev != this) {
                n.setPrevious(this);
            }
        }

        public void setPrevious(LinkedListNode p) {
            prev = p;
            if (p != null && p.next != this) {
                p.setNext(this);
            }
        }

        public String printForward() {
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return data.toString();
            }
        }

        public LinkedListNode clone() {
            LinkedListNode next2 = null;
            if (next != null) {
                next2 = next.clone();
            }
            LinkedListNode head2 = new LinkedListNode(data, next2, null);
            return head2;
        }
    }
}
