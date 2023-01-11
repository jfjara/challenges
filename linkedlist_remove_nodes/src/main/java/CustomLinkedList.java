public class CustomLinkedList<T> {

    private Node<T> firstNode;

    public int size() {

        if (isEmpty()) {
            return 0;
        }

        int counter = 1;
        Node<T> nodeToCount = firstNode.getNextNode();
        while (nodeToCount != null) {
            counter++;
            nodeToCount = nodeToCount.getNextNode();
        }
        return counter;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void add(T nodeValue) {
        int lastIndex = getLastIndex();
        Node<T> lastNode = getNode(lastIndex);
        if (lastNode == null) {
            firstNode = new Node<T>(nodeValue);
        } else {
            lastNode.setNextNode(new Node<T>(nodeValue));
        }
    }

    public void add(int index, T value) {

        Node<T> lastNode = getNode(index);
        Node<T> newNode = new Node<T>(value);
        newNode.setNextNode(lastNode);

        if (index > 0) {
            Node<T> previousNode = getNode(index - 1);
            previousNode.setNextNode(newNode);
        }

    }

    public void clear() {
        firstNode = null;
    }

    public T get() {
        int lastIndex = getLastIndex();
        Node<T> lastNode = getNode(lastIndex);
        if (lastNode == null) {
            throw new IndexOutOfBoundsException();
        }
        return lastNode.getValue();
    }

    public T get(int index) {
        Node<T> node = getNode(index);
        return node.getValue();

    }

    private int getLastIndex() {
        int total = size();
        return total == 0 ? 0 : total - 1;
    }

    private Node<T> getNode(int index) {
        int total = size();
        if (index > total) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> nodeToCount = firstNode;
        int counterNode = 0;
        while (counterNode < index) {
            nodeToCount = nodeToCount.getNextNode();
            counterNode++;
        }
        return nodeToCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            sb.append(currentNode.getValue()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        return sb.toString();
    }
    
}
