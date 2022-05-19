public class ListaEncadeada {
    private Element head;
    private Element tail;
    private int totalDeElementos = 0;

    public ListaEncadeada() {

    }

    public int getTotalDeElementos() {
        return this.totalDeElementos;
    }

    public void fazVazia() {
        head = null;
        tail = null;
    }
    
    public Element getHead() {
        return head;
    }

    public Element getTail() {
        return tail;
    }
    
    public boolean estaVazia() {
        return (head == null);
    }

    public Object getPrimeiroElemento() throws ListaVaziaException {
        if(head == null) {
            throw new ListaVaziaException();
        }

        return head.data;
    }

    public Object getUltimoElemento() throws ListaVaziaException {
        if(tail == null) {
            throw new ListaVaziaException();
        }

        return tail.data;
    }

    public void inserirInicio(Object item) {
        Element temp = new Element (item, head);
        if (head == null) {
            tail = temp;
        }
        head = temp;
        totalDeElementos++;
    }

    public void inserirFim(Object item) {
        Element temp = new Element(item, null);
        if (head == null) {
            head = temp;
        }
        else {
            tail.next = temp;
        }
        tail = temp;
        totalDeElementos++;
    }

    public void atribuir(ListaEncadeada list) {
        if (list != this) {
            this.fazVazia();
            for (Element ptr = list.head; ptr != null; ptr = ptr.next) {
                this.inserirFim(ptr.data);
            }
        }
    }  
    
    public void extrairItem(Object item) throws ObjetoNaoEncontradoExpection {
        Element ptr = head;
        Element prevPtr = null;

        while(ptr != null && ptr.data != item) {
            prevPtr = ptr;
            ptr = ptr.next;
        }
        
        if (ptr == null) {
            throw new ObjetoNaoEncontradoExpection();
        }
        
        if (ptr == head) {
            head = ptr.next;
        }
        else {
            prevPtr.next = ptr.next;
        } 

        if (ptr == tail) {
            tail = prevPtr;
        }
    }
        
    @Override
    public String toString() {
        if (this.estaVazia()) {
            return "[ ]";
        }   
        StringBuilder builder = new StringBuilder("[");
        for (Element element = this.getHead(); element != null; element = element.getNext()) {
            builder.append(element.getData());
            if (element != tail) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public Element getElement(Object o) throws ObjetoNaoEncontradoExpection {
        Element ptr = head;
        Element prevPtr = null;

        while(ptr != null && ptr.data != o) {
            prevPtr = ptr;
            ptr = ptr.next;
        }

        if (ptr == null) {
            throw new ObjetoNaoEncontradoExpection();
        }

        return ptr;
    }

    public void inserirAntes(Object item, Element e) {        
        e.inserirAntes(item);
    }

    public void inserirDepois(Object item, Element e) {
        e.inserirDepois(item);
    }






    

    public final class Element {
        Object data;
        Element next;
        
        public Element (Object d, Element n) {
            data = d;
            next = n;
        }

        public Element() {}
        
        public Object getData() {
            return data;
        }
    
        public Element getNext() {
            return next;
        }

        public void inserirDepois(Object item) {
            next = new Element (item, next);
            if (tail == this) {
                tail = next;
            }
            totalDeElementos++;
        }

        public void inserirAntes(Object item) {
            Element temp = new Element (item, this);
            if (this == head) {
                head = temp;

            } else {
                Element prevPtr = head;
                while (prevPtr != null && prevPtr.next != this) {
                    prevPtr = prevPtr.next;
                }
                prevPtr.next = temp;
            }
            totalDeElementos++;
        }
    }
    
}
