import static java.lang.System.exit;
// importando pacote com método exit para encerrar a execução do programa rodando na máquina virtual do java (JVM)

// Nó (node) de lista encadeada (linked list)
class Node
{
    int data;       // variável inteiro data (dados)
    Node next;      // ponteiro para o próximo node

    public Node(int data)
    {
        // define os dados no node alocado e retorna-o
        this.data = data;
        this.next = null;
    }
}

class Queue
{
    private static Node rear = null, front = null;
    private static int count = 0;

    // Função para inserir um item na fila
    public static void push(int item) { // inserção no final

        Node node = new Node(item); // alocando o novo node na heap

        if (front == null) // caso especial no qual a lista está vazia
        {
            // inicializa ambos front (frente/início) e rear (traseiro/final)
            front = node;
            rear = node;
        }
        else {
            // atualiza o rear
            rear.next = node;
            rear = node;
        }

        // aumenta a contagem de nós em 1
        count += 1;
    }

    // Função para retirar o elemento front da fila
    public static int pop()     // deleta no início
    {
        if (front == null)
        {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }

        Node temp = front;

        // avança o front para o próximo (next) node
        front = front.next;

        // caso a lista fique vazia
        if (front == null) {
            rear = null;
        }
        // diminui a contagem de nodes por 1
        count -= 1;

        // retorna
        return temp.data;
    }

    // Função para retornar o elemento front em uma fila
    public static int front()
    {
        // verifica por uma fila vazia
        if (front == null) {
            System.exit(-1);
        }
        return front.data;
    }

    // Função para verificar se a fila está vazia ou não
    public static boolean isEmpty() {
        return rear == null && front == null;
    }

    // Função para retornar o tamanho da fila
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
                System.out.println("%d->", temp.data); // imprime dados do nó (node data)
                temp = temp.next; // designa temp next à variável temporária (temp)
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