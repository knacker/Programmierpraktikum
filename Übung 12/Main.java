//@author maximilian raspe
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(2);
        list.add(9);
        list.insert(5, 3);
        list.delete(3);
        list.get(2);
        list.length();
        System.out.println(list.toString());
    }
}
