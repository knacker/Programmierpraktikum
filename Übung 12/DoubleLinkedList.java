//@author maximilian raspe
public class DoubleLinkedList<T> implements List<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;
        //konstruktor für neuen knoten
        public Node(T data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node <T> current;
    private Node<T> tail;
    private Node<T> head;
    private int counter;

    //fügt das element am ende der liste an
    @Override
    public void add(T t)  {
        try {
            Node node = new Node(t, null, null);
            if(head == null) {
                head = node;
                head.previous = null;
                head.next = null;
            }
            else {
                current = head;

                while(current.next != null) {

                }
                current.next = node;
                node.previous = current;
                node.next = null;
            }
        } catch(Exception e) {
            System.out.println("Fehler" + e.getMessage());
        }

    }
    //fügt das gewünschte objekt an i-ter stelle ein. die schleife wird solange durchlaufen bis man am gewünschten index angekommen ist und dort wird das element eingefügt
    @Override
    public void insert(T obj, int index){
        try {
            Node node = new Node(obj, null, null);
            Node<T> temp;
            int iteration = 1;

            head = node;
            while (iteration != index) {

                iteration++;

            }
            temp = current.next;
            node.next = temp;
            temp.previous = node;
            node.previous = current;
        } catch(Exception e) {
            System.out.println("Fehler" + e.getMessage());
        }
    }
    //durchläuft die liste solange bis man am gewünschten index angekommen ist und gibt dann das element der liste zurück
    @Override
    public T get(int index){
        try {
            Node current = head;
            counter = 0;

            while (current != null) {
                if (counter == index) {
                    return (T) current.data;
                }
                counter++;
                current = current.next;
            }
        }
        catch(Exception e) {
            System.out.println("Fehler : " + e.getMessage());
        }
        return null;
    }
    //löscht das element an stelle vom index.
    @Override
    public void delete(int index) {
        try {
            int iterator = 1;

            current = head;
            if (index == 1) {
                head = current.next;
                current.next = null;
                current.previous = null;
            } else {
                while (iterator != index) {
                    current = current.next;
                    iterator++;
                }
                if (current.next == null) {
                    current.previous.next = null;
                    current.previous = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
            }
        } catch(Exception e) {
            System.out.println("Fehler" + e.getMessage());
        }
    }
    //itieriert solange durch die liste bis ein objekt gefunden wurde, wenn nicht wird nichts zurückgegeben
    @Override
    public int indexOf(T obj) {
        try {
        for(int i = 1; i < counter; i++) {
            if (obj.equals(current.data)) {
                return i;
            }
            current = current.next;
        }

        } catch (Exception e) {
            System.out.println("Fehler : " + e.getMessage());
        }
        return -1;
    }
    //gibt die länge der liste an, wird mit counter gezählt
    @Override
    public int length() {
        return counter;
    }

    //gibt den inhalt des "knotens" als string zurück
    @Override
    public String toString() {
        Node node = head;
        while(node != null) {
            System.out.println(" " + node.data);
            node = node.next;
        }
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Node)) {
            return false;
        }
        Node<T> element = (Node<T>) obj;
        if(current.data == null) {
            return element.data == null;
        }
        return element.equals(element.data);
    }
}