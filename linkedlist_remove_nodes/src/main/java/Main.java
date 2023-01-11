public class Main {

    public static void main(String[] args) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(8);
        linkedList.add(3, 4);
        linkedList.add(5, 7);

        System.out.println(linkedList);

        linkedList.clear();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(8);
        linkedList.add(3, 4);
        linkedList.add(5, 7);
        System.out.println(linkedList);
    }

}
