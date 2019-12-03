public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {

        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
    }

    // Referencia para o primeiro elemento da lista encadeada.
    private Node head;
    // Referencia para o ultimo elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    /**
     * Construtor da lista
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }

    public Node head() { 
        Node aux = head;
        return aux;
    }

    public int get(int pos){
        Node aux = head;
        for(int i = 0; i < pos; i++){
            aux = aux.next;
        }
        return aux.element;
    }

    public boolean remove(Integer element) {
        if (element == null) {
            return false;
        }
        if (count == 0) {
            return false;
        }

        if (head.element.equals(element)) { // remocao do primeiro
            head = head.next;
            if (count == 1) { // se havia so um elemento na lista
                tail = null;
            }
            count--;
            return true;
        }

        Node ant = head;
        Node aux = head.next;

        for (int i = 1; i < count; i++) {
            if (aux.element.equals(element)) {
                if (aux == tail) { // remocao do ultimo
                    tail = ant;
                    tail.next = null;
                } else { // remocao do meio
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
            ant = ant.next;
            aux = aux.next;
        }

        return false;		
    }

    public int size() { return count; }

    public void add(Integer element) {
        Node aux = new Node(element);
        if (head == null) {
            head = aux;
        } else {
            tail.next = aux;
        }
        tail = aux;
        count++;
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            while(aux.element == 0 && aux.next != null) {
                aux = aux.next;           
            }
            if(aux.element!=0){
                s.append(aux.element.toString());
                s.append(" "); 
            }
            aux = aux.next;
        }
        return s.toString();
    }
}
