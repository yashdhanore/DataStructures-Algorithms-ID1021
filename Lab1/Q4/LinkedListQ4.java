public class LinkedListQ4<T> {

    private Node<T> head;
    private Node<T> tail;
    int size;

    private class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;
    }

    LinkedListQ4() {
        head = tail = null;
        size = 0;
    }

    void insert_AtStart(T x) {
        Node<T> newnode = new Node<>();
        newnode.value = x;
        if (size == 0) {
            head = tail = newnode;
            newnode.next = head;
            newnode.previous = tail;
        } else {
            newnode.next = head;
            head.previous = newnode;
            newnode.previous = tail;
            tail.next = newnode;
            head = newnode;
        }
        size++;
    }

    void insert_AtEnd(T x) {
        Node<T> newnode = new Node<>();
        newnode.value = x;
        if (size == 0) {
            head = tail = newnode;
            tail.next = tail;
            tail.previous = tail;
        } else {
            tail.next = newnode;
            newnode.previous = tail;
            newnode.next = head;
            head.previous = newnode;
            tail = newnode;
        }
        size++;
    }

    T delete_FromStart() {
        T x = head.value;
        if (size == 0) {
            System.out.println("Empty!!");
        } else if (head == head.next) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = tail;
            tail.next = head;
        }
        size--;
        return x;
    }

    T delete_FromEnd() {
        T x = head.value;
        if (size == 0) {
            System.out.println("Empty!!");
        }
        size--;
        return x;
    }

    void viewContents() {
        if (head == null) {
            System.out.println("Nothing to see here!");
        } else {
            Node<T> iterate = new Node<>();
            iterate = head;
            while (iterate != tail) {
                System.out.print(iterate.value + " ");
                iterate = iterate.next;
            }
            System.out.print(iterate.value);
        }
    }

}