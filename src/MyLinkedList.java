import java.util.*;

/**
 * Created by Shashpash on 28.12.2015.
 */
public class MyLinkedList implements List<Integer> {
    private int size = 0;
    private static Node top;

    public MyLinkedList() {
    }

    public MyLinkedList(Integer element) {
        final Node f = top;
        final Node newNode = new Node<>(element, f);
        top = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size != 0)
            return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Node node = top; node != null; node = node.next) {
            if (node.item == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        int i = 0;
        for (Node node = top; node != null; node = node.next)
            result[i++] = (Integer) node.item;
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer element) {
        final Node f = top;
        final Node newNode = new Node<>(element, f);
        top = newNode;
        size++;
        return true;
    }

    //do later
    @Override
    public boolean remove(Object o) {
        if (top == null)
            throw new NoSuchElementException();

        for (Node node = top; node != null; node = node.next) {
            if (o.equals(node.item)) {
                return true;
            }
        }
    return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c)
            if (add((Integer) element))
                modified = true;
        return modified;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Node node = top; node != null; ) {
            Node next = node.next;
            node.item = null;
            node.next = null;
            node = next;
        }
        top = null;
        size = 0;
    }

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
            for (Node node = top; node != null; index--) {
                if (o.equals(node.item))
                    return index;
            }
        return -1;
    }


    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
    }

    private static class Node<Integer> {
        Integer item;
        Node<Integer> next;

        Node(Integer element, Node<Integer> next) {
            this.item = element;
            this.next = next;
        }
    }
}
