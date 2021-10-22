package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    @BeforeEach
    void setUp() {
        stackOfInts.push(3);
        stackOfInts.push(2);
        stackOfInts.push(1);
    }

    @Test
    void pop(){
        stackOfInts.pop();
        Assertions.assertEquals(2,stackOfInts.firstElemStack());
    }

    @Test
    void push()
    {
        stackOfInts.push(37);
        Assertions.assertEquals(37, stackOfInts.firstElemStack());
    }

    @Test
    void numOfElems()
    {
        Assertions.assertEquals(3, stackOfInts.numOfElems());
    }

    @Test
    void peek()
    {
        Assertions.assertEquals(1, stackOfInts.firstElemStack());
    }

    @AfterEach
    void tearDown() {
    }
}