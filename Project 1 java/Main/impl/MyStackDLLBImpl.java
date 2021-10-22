package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

//%--------------------------------------------------------------------------------------------%
//All the description about the different methods is in the MyStack interface
//%--------------------------------------------------------------------------------------------%

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems;
    public MyStackDLLBImpl() {this.elems=new DLinkList<>();}


    @Override
    public void pop() {elems.removeFirst();}

    @Override
    public E firstElemStack() {return elems.returnFirstElem();}

    @Override
    public void push(E x) { elems.addFirst(x);}

    @Override
    public int numOfElems() { return elems.countElements();}

    @Override
    public E peek() {return elems.returnFirstElem();}
}
