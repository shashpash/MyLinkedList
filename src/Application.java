import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shashpash on 29.12.2015.
 */
public class Application {
    public static void main(String... args) {
        LinkedList linkedList = new LinkedList();
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.set(2, new Integer(659));
        myLinkedList.remove(new Integer(33));

//        System.out.println("del: " + myLinkedList.remove(3));

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }

        A a = new A(2);
        f(a);
        //System.out.println(a.a);


    }

    static void f(A a) {
        a.a = 3;
    }
}

class A {
    int a = 2;

    public A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
