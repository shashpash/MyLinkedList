import java.util.*;

/**
 * Created by Shashpash on 28.12.2015.
 */
public class MyLinkedList implements List<Integer> {
    private int size = 0;
    private static Node head;

    public MyLinkedList() {
        head = null;
    }

    public MyLinkedList(Integer element) {
        Node node = new Node(element);
        head = node;
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
        for (Node node = head; node != null; node = node.next) {
            if (node.item == o) {
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
        for (Node node = head; node != null; node = node.next)
            result[i++] = (Integer) node.item;
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return null;
        int i = 0;
        for (Node node = head; node != null; node = node.next)
            a[i++] = (T) node.item;
        return a;
    }

    @Override
    public boolean add(Integer element) {
        Node node = new Node(element);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;

        return true;
    }

    //TODO late
    @Override
    public boolean remove(Object o) {
        if (head == null)
            throw new NoSuchElementException();

        remove(indexOf(o));
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object integer : c) {
            if (!contains(integer)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean modified = false;
        for (Object element : c)
            if (add((Integer) element))
                modified = true;
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object object : c) {
            remove(object);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Node node = head; node != null; ) {
            Node next = node.next;
            node.item = null;
            node.next = null;
            node = next;
        }
        head = null;
        size = 0;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index + 1 > size)
            return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (Integer) current.item;
    }

    @Override
    public Integer set(int index, Integer element) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        Node current = head;
        while (index-- != 0) {
            current = current.next;
        }
        System.out.println("item: " + current.item);

        current.item = element;
        return element;
    }


    //TODO late
    @Override
    public void add(int index, Integer element) {
        Node current = head;
        while (index-- != 0) {
            current = current.next;
        }
        System.out.println("item: " + current.item);

        current.item = element;
        //Node temp = current;
        //current.item = element;
        //
        // current.next = temp;
    }

    private Integer pop(Node node) {
        Node temp = node.next;
        node.next = temp.next;
        return (Integer) temp.item;
    }

    @Override
    public Integer remove(int index) {
        Integer result = null;
        if (index + 1 > size || index < 0) {
        } else if (index == 0) {
            result = (Integer) head.item;
            size--;
            head = head.next;
        } else {
            size--;
            Node node = head;
            while (--index != 0) {
                node = node.next;
            }
            result = pop(node);
        }
        return result;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (head == null)
            throw new NoSuchElementException();

        for (Node node = head; node != null; node = node.next, index++) {
            if (o.equals(node.item)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int lastIndex = -1;
        for (Node node = head; node != null; node = node.next, index++) {
            if (o.equals(node.item))
                lastIndex = index;
        }
        return lastIndex;
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


    private static class Node<Integer> implements Cloneable {
        Integer item;
        Node<Integer> next;

        Node(Integer element) {
            this.item = element;
            this.next = null;
        }
    }
}
