package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

/**
 * interface of abstract methods useful for MyQueue class
 * @param <E> allows the user to use different types for the methods in the interface
 */
public interface MyQueue<E> {
    /**
     * adding a node at the first place of the queue
     * @param x the data you want to be in the element you will add in the queue
     */
    void enqueue(E x);

    /**
     * remove the last node of the queue
     */
    void dequeue();

    /**
     *
     * @return the data of the first node in the queue
     */
    E getFirstElemQueue();

    /**
     *
     * @return the data of the last node in the queue
     */
    E getLastElementQueue();

    /**
     *
     * @return 0, if the queue is empty
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     *
     * @return the number of elements in the queue
     */
    int numOfElems();

    /**
     * use the method getFirstElementQueue
     *
     * @return the data of the last node in the queue
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
