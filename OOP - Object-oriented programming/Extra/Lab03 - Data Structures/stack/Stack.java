import static java.lang.System.exit;
// importando pacote com método exit para encerrar a execução do programa rodando na máquina virtual do java (JVM)

// Criação da pilha (stack) ussando lista encadeada (Linked list)
class StackLinkedList {

    // Nó (node) da lista encadeada (Linked list)
    private class Node {
        int data; // variável data com tipo inteiro
        Node next; // ponteiro para o próximo nó (node)
    }

    private Node top; // cria uma variável global do tipo Node com referência ao top
    private int nodesCount // variável do tipo inteiro para contar os nós (nodes)

    StackLinkedList() // Construtor
    {
        this.top = null;
        this.nodesCount = 0;
    }

    // Função para inserir um elemento x na pilha (stack)
    public void push(int x) { // inserção no início
        Node temp = new Node(); // cria um node temp e aloca memória

        if (temp == null) { // se a pilha (heap) estiver cheia, inserir um elemento resultaria em estouro de pilha (stack overflow)
            System.out.print("\nHeap Overflow");
            return;
        }
        temp.data = x; // inicializa os dados (data) no campo temp data
        temp.next = top; // coloca a refência top em temp next
        top = temp; // atualiza a referência top
        this.nodesCount += 1; // aumenta o tamanho da pilha em 1
    }

    // Função para verificar se a pilha está vazia ou não
    public boolean isEmpty() {
        return top == null;
    }

    // Função que tem como retorno o elemento top da pilha
    public int top() {
        if (!isEmpty()) { // verifica se pilha está vazia
            return top.data;
        } else {
            System.out.println("Pilha está vazia");
            return -1;
        }
    }

    // Função para remover (pop) o elmento que está a menos tempo (top) da pilha
    public void pop() { // remove no início
        if (top == null) { // verfica se há estouro negativo (stack underflow)
            System.out.print("\nStack Underflow");
            return;
        }
        top = (top).next; // atualizar ponteiro top para apontar para o próximo nó (node)
        this.nodesCount -= 1; // diminui o tamanho da pilha em 1
    }

    // Função que retorna o tamanho da pilha
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
                System.out.println("%d->", temp.data); // imprime dados do nó (node data)
                temp = temp.next; // designa temp next à variável temporária (temp)
            }
        }
    }
}

// classe princial (programa principal)
public class Pilha {
    public static void main(String[] args) {
        StackLinkedList obj = new StackLinkedList(); // criando classe do objeto de implementação
        
        // inserção dos valores da pilha 
        obj.push(111);
        obj.push(222);
        obj.push(333);
        obj.push(444);
        obj.push(555);
        // vou parar aqui, não vou colocar a próxima sequência rsrs

        // mostrar elementos da pilha
        obj.print();
        
        // mostrar tamanho da pilha
        System.out.println("\nA pilha possui %d elementos\n", obj.size());

        // mostrar elemento top da pilha
        System.out.println("\nElemento top eh %d\n", obj.top());

        // remover elemento top da pilha
        obj.pop();
        obj.pop();

        // print Stack elements
        obj.print();

        // mostrar tamanho da pilha
        System.out.println("\nA pilha possui %d elementos\n", obj.size());

        // print Top element of Stack
        System.out.println("\nElemento top eh %d\n", obj.top());
    }
}