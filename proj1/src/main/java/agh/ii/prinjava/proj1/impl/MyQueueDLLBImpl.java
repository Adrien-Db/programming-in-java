package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

//%--------------------------------------------------------------------------------------------%
//All the description about the different methods is in the MyQueue interface
//%--------------------------------------------------------------------------------------------%

public class MyQueueDLLBImpl<E> implements MyQueue<E> {

    private DLinkList<E> elems;

    public MyQueueDLLBImpl() {this.elems=new DLinkList<>();}

    @Override
    public void enqueue(E x) {elems.addFirst(x);}

    @Override
    public E getFirstElemQueue() {return elems.returnFirstElem();}

    @Override
    public E getLastElementQueue() {return elems.returnLastElem();}

    @Override
    public void dequeue() {elems.removeLast();}

    @Override
    public int numOfElems() { return elems.countElements(); }

    @Override
    public E peek() {return elems.returnLastElem();}
}