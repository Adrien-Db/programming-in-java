package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

/**
 * interface of abstract methods useful for MyStack class
 * @param <E>
 */
public interface MyStack<E> {
    /**
     * remove the first element of the stack
     */
    void pop();

    /**
     *
     * @return the first element of the stack
     */
    E firstElemStack();

    /**
     * add element in the first place of the stack
     * @param x
     *          the parameter correspond to what we want to add to the list
     */
    void push(E x);

    /**
     * Useful only if the list is empty
     * if the list(stack) is empty return 0 which is the number of elements
     * @return 0, only if the stack is empty
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * count the elements contains in the list
     * @return an integer, the number of elements in the list
     */
    int numOfElems();

    /**
     *
     * @return the data of the first node in list
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
