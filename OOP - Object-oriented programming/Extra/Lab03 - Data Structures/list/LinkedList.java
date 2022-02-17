class LinkedList {
    Node head; // refência à cabeça da lista

    class Node {
        int data;
        Node next;

        Node(int d) // Construtor para criar um novo nó (node)
        {
            data = d;
            next = null;
        }
    }

    // Inserir no início da lista
    public void push_front(int data) {
        Node new_node = new Node(data); // Alocar e inserir os dados no nó
        new_node.next = head; // Fazer o próximo elemento (next) a cabeça (head)
        head = new_node; // Fazendo com que a cabeça seja o novo nó alocado
    }

    // Inserir no final da lista
    public void push_back(int new_data) {
        Node new_node = new Node(new_data); // Aloca o node, coloca-o no data e define o next como null

        if (head == null) // Caso a lista esteja vazia, então o novo nó será definido como cabeça (head)
        {
            head = new Node(new_data);
            return;
        }
        new_node.next = null; // Novo node será o último, então next vai ser null

        // Caso contrário, vai passar por toda lista até o último node
        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node; // Muda o next do último node
        return;
    }

    // Função para criar e retornar um nó
    static Node GetNode(int data) {
        return new Node(data);
    }

    // Inserir node em posição específica/definida
    static Node insert_pos(Node headNode, int pos, int data) {
        Node head = headNode;

        // verifica se a posição a qual se deseja inserir é válida
        if (pos < 1)
            System.out.print("Posicao invalida");

        // Se a posição (pos) é 1, então o novo node está na frente do nó head (headNode)
        // Assim, mudar head node
        if (pos == 1) {
            Node newNode = new Node(data);
            newNode.nextNode = headNode;
            head = newNode;
        } else {
            while (pos-- != 0) {
                if (pos == 1) {
                    Node newNode = GetNode(data); // Adicionando node à posição solicitada
                    newNode.nextNode = headNode.nextNode; // Fazer o novo node apontar para o antigo node na mesma posição
                    headNode.nextNode = newNode; // Substituindo o atual (current) com o novo node para o antigo node, para apontar ao novo node
                    break;
                }
                headNode = headNode.nextNode;
            }
            if (pos != 1)
                System.out.print("Posicao fora de alcance");
        }
        return head;
    }

    // Inserir nó em lista ordenada em sua posiçao correta para continuar ordenado
    public static Node insert_sorted(Node head, Node newNode) {
        // Caso especial para o fim da cabeça
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        // localizar o node antes do ponto de inserção
        Node current = head;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    // Retornar tamanho (comprimento) da lista
    public int size() {
        Node temp = head;
        int size = 0;

        // Alternativamente pode-se utilizar o laço for:
        // for(Node temp = head; temp.next != null; temp = temp.next)
        //       size++;
        while (size != null) {
            size++;
            temp = temp.next;
        }
        return count;
    }

    // Remover o primeiro nó (node) de uma lista
    static Node pop_front(Node head) {
        if (head == null) // Verifica se a lista está vazia
            return null;

        // Mover o ponteiro head ao próximo nó (next node)
        Node temp = head;
        head = head.next;

        return head;
    }

    // Remover o último nó (node) de uma lista
    static Node pop_back(Node head) {
        if (head == null) // Verifica se a lista está vazia
            return null;

        if (head.next == null) {
            return null;
        }

        // Encontrar o penúltimo nó
        Node second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;

        second_last.next = null; // Mudar o next do penúltimo nó

        return head;
    }

    // Apagar dados (dados/elementos/nós) da lista
    void erase_data() {
        head = null;
    }

    // Deletar node em posição específica/definida
    void erase_pos(int pos) {
        if (head == null) // Verifica se a lista está vazia
            return;

        Node temp = head; // Armazena o node head

        // Caso o head precise ser removido
        if (pos == 0) {
            head = temp.next; // Mudar o head
            return;
        }

        // Encontra o nó que está antes do nó que vai ser apagado
        for (int i = 0; temp != null && i < pos - 1; i++)
            temp = temp.next;

        // Caso a posição seja maior que o número de nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next é o node a ser deletado
        Node next = temp.next.next; // Armazena o ponteiro ao next do node a ser deletado

        temp.next = next; // Desencadeia o node deletado da lista encadeada
    }

    // Retorna o front (primeiro nó) da lista
    int front() {
        if (head != null)
            return head.data;
    }

    // Retorna o último item da lista (back)
    public int back(int lastItem) {
        Node current;
        current = head;
        int count = 0; // variável para contar
        int lastIndex = 0;// passar pela lista
        while (current.next != null) {
            if (current.dataItem == lastItem) {
                lastIndex = count;
            }
            count++; // incrementa o contador (count) a cada vex que o loop for executado
            current = current.next; // move para o próximo node para checar
        }
        return lastIndex;
    }

    // Encontra posição (índce/index)
    public int find_pos(int item) {
        int index = 0;
        Node current = head;

        while (current != null) { //Enquanto não tiver chegado no fim da lista
            if (current.data == item) { // Se os nós forem iguais, retornar posicao
                return index;
            }
            // Define o atual (current) ao next e incremento o index (índice/posição)
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
    // Retorna o dados de um nó em uma específica posição, considerando a posição como um argumento
    public int get_pos(int index) {
        Node current = head;
        int count = 0; // posição do node o qual se procura

        while (current != null) {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }

        // Caso se chegue nesse ponto, foi solicitado por um elemento não existente, assim, ocorre falha
        assert (false);
        return 0;
    }

    // Imprimir a lista
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}