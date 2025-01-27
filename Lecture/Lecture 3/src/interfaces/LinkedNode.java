package interfaces;

public class LinkedNode<E> {
    private E value;
    private LinkedNode<E> next;

    public LinkedNode(E value, LinkedNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public LinkedNode<E> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        LinkedNode<String> l1 = new LinkedNode<>("1", null);
        LinkedNode<String> l2 = new LinkedNode<>("2", l1);

        System.out.println(l1.getValue() + l2.getValue());

        LinkedNode<Integer> l3 = new LinkedNode<>(20, null);
        LinkedNode<Integer> l4 = new LinkedNode<>(5,l3);

        System.out.println(l3.getValue() + l4.getValue());
    }
}
