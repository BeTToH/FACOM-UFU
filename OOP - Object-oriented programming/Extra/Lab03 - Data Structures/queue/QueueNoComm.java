import static java.lang.System.exit;

class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private static Node rear = null, front = null;
    private static int count = 0;

    public static void push(int item) {
        Node node = new Node(item);

        if (front == null)
        {
            front = node;
            rear = node;
        }
        else {
            rear.next = node;
            rear = node;
        }
        count += 1;
    }

    public static int pop()
    {
        if (front == null)
        {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }
        Node temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        count -= 1;
        return temp.data;
    }

    public static int front()
    {
        if (front == null) {
            System.exit(-1);
        }
        return front.data;
    }

    public static boolean isEmpty() {
        return rear == null && front == null;
    }

    private static int size() {
        return count;
    }

    public void print() {
        if (front == null) {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        } else {
            Node temp = front;
            while (temp != null) {
                System.out.println("%d->", temp.data);
                temp = temp.next;
            }
        }
    }
}

class Main
{
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.push(2);
        q.push(4);
        q.push(6);
        q.push(8);
        q.push(10);

        q.print();
        System.out.println("\nA fila possui %d elementos\n", q.size());
        System.out.printf("O elemento front eh %d\n", q.front());

        q.pop();
        q.pop();
        q.pop();

        q.print();
        System.out.println("\nA fila possui %d elementos\n", q.size());
        System.out.printf("O elemento front eh %d\n", q.front());

        if (q.isEmpty()) {
            System.out.println("A fila esta vazia");
        }
        else {
            System.out.println("A fila nao esta vazia");
        }
    }
}