package agh.ii.prinjava.proj1.impl;

/**
 *
 * @param <E> allows the user to use different types for the methods in the class
 */
public class DLinkList<E> {
    /**
     * initialize the beginning of the list with head
     */
    Node<E> head=null;

    /**
     *
     * @param <T> allows the user to use different types in the class
     */
    private static class Node<T> {
        /**
         * an element of T type
         */
        T elem;
        /**
         * points to the next node in the list
         */
        Node<T> next;
        /**
         * points to the previous node in the list
         */
        Node<T> prev;

        /**
         * constructor of Node
         * initialize Node with parameters values
         * @param elem
         */
        public Node(T elem) {
            this.elem=elem;
            this.prev=null;
            this.next=null;
        }
    }

    /**
     * @return the first element of the list
     */
    public E returnFirstElem(){
        return head.elem;
    }

    /**
     * @return the last element of the list
     */
    public E returnLastElem() {
        if (head==null || head.next==null){
            return head.elem;
        }
        else{
            Node<E> p = head;
            while (p.next!=null){
                p=p.next;
            }
            return p.elem;
        }
    }

    /**
     *
     * @return the number of elements in the list
     */
    public int countElements(){
        Node<E> p = head;
        int c = 0;
        if (head==null){ return 0;}
        while (p.next!=null){
            p=p.next;
            c+=1;
        }
        c+=1;
        return c;
    }

    /**
     * add an element at the last position of the list
     * @param elem , the element the user wants to add in first
     */
    public void addFirst(E elem){
        Node<E> n = new Node<>(elem);
        if (head==null){ head = n;}
        else {
            head.prev = n;
            n.next = head;
            head = n;
        }
    }

    /**
     * add an element at the last position of the list
     * @param elem the element the user wants to add
     * @param <E> the type of the elements the user wants to add
     */
    public <E> void addLast(E elem){
        Node<E> n = new Node<>(elem);
        Node p = head;
        if (head==null){
            head=null;
        }
        else{
            while(p.next!=null){
                p=p.next;
            }
            p.next=n;
            n.prev=p;
        }
    }

    /**
     * remove the first node in the list
     */
    public void removeFirst(){
        if (head.next==null || head==null){
            head=null;
        }
        else{
            head=head.next;
            head.prev=null;
        }
    }

    /**
     * remove the last element in the list
     */
    public void removeLast(){
        if (head==null || head.next==null) {head=null;}
        else {
            Node<E> p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            p.next=null;
        }
    }

    @Override
    /**
     * displays the content of the list
     */
    public String toString() {
        Node <E> p = head;
        System.out.println("DLinkList{");
        while (p != null) {
            System.out.println(p.elem);
            p = p.next;
        }
        return ("}");
    }
}
