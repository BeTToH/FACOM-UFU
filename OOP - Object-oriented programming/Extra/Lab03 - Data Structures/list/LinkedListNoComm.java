class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push_front(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void push_back(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;


        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
    }

    static Node GetNode(int data) {
        return new Node(data);
    }

    static Node insert_pos(Node headNode, int pos, int data) {
        Node head = headNode;

        if (pos < 1)
            System.out.print("Posicao invalida");

        if (pos == 1) {
            Node newNode = new Node(data);
            newNode.nextNode = headNode;
            head = newNode;
        } else {
            while (pos-- != 0) {
                if (pos == 1) {
                    Node newNode = GetNode(data);
                    newNode.nextNode = headNode.nextNode;
                    headNode.nextNode = newNode;
                    break;
                }
                headNode = headNode.nextNode;
            }
            if (pos != 1)
                System.out.print("Posicao fora de alcance");
        }
        return head;
    }

    public static Node insert_sorted(Node head, Node newNode) {

        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node current = head;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public int size() {
        Node temp = head;
        int size = 0;

        while (size != null) {
            size++;
            temp = temp.next;
        }
        return count;
    }

    static Node pop_front(Node head) {
        if (head == null)
            return null;

        Node temp = head;
        head = head.next;

        return head;
    }

    static Node pop_back(Node head) {
        if (head == null)
            return null;

        if (head.next == null) {
            return null;
        }

        Node second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;

        second_last.next = null;

        return head;
    }


    void erase_data() {
        head = null;
    }


    void erase_pos(int pos) {
        if (head == null)
            return;

        Node temp = head;

        if (pos == 0) {
            head = temp.next;
            return;
        }


        for (int i = 0; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;

        temp.next = next;
    }

    int front() {
        if (head != null)
            return head.data;
    }

    public int back(int lastItem) {
        Node current;
        current = head;
        int count = 0;
        int lastIndex = 0;
        while (current.next != null) {
            if (current.dataItem == lastItem) {
                lastIndex = count;
            }
            count++;
            current = current.next;
        }
        return lastIndex;
    }

    public int find_pos(int item) {
        int index = 0;
        Node current = head;

        while (current != null) {
            if (current.data == item) {
                return index;
            }

            current = current.next;
            index++;
        }
        return -1;
    }

/*
public int find_pos(int item){
    Node current = head;
    for(int index = 0; i < size; index++) {
        current = current.next;
        if(current.data == item){
        return index+1;
        }
    }
    return -1;
}
*/

    public int get_pos(int index) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }

        assert (false);
        return 0;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}