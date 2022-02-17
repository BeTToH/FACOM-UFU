import static java.lang.System.exit;

class StackLinkedList {
    private class Node {
        int data;
        Node next;
    }
    private Node top;
    private int nodesCount

    StackLinkedList() {
        this.top = null;
        this.nodesCount = 0;
    }

    public void push(int x) {
        Node temp = new Node();

        if (temp == null) {
            System.out.print("\nHeap Overflow");
            return;
        }
        temp.data = x;
        temp.next = top;
        top = temp;
        this.nodesCount += 1;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int top() {
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Pilha está vazia");
            return -1;
        }
    }

    public void pop() {
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
        top = (top).next;
        this.nodesCount -= 1;
    }

    public int size() {
        return this.nodesCount;
    }

    public void print() {
        if (top == null) {
            System.out.println("\nStack Underflow");
            exit(1);
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.println("%d->", temp.data);
                temp = temp.next;
            }
        }
    }
}

public class Pilha {
    public static void main(String[] args) {
        StackLinkedList obj = new StackLinkedList();

        obj.push(111);
        obj.push(222);
        obj.push(333);
        obj.push(444);
        obj.push(555);

        obj.print();
        obj.size();
        System.out.println("\nElemento top eh %d\n", obj.top());

        obj.pop();
        obj.pop();
        obj.print();
        obj.size();
        System.out.println("\nElemento top eh %d\n", obj.top());
    }
}