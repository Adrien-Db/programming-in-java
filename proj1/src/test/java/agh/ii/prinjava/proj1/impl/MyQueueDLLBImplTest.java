package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts = MyQueue.create();

    @BeforeEach
    void setUp() {
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(1);
    }

    @Test
    void enqueue()
    {
        queueOfInts.enqueue(45);
        Assertions.assertEquals(45, queueOfInts.getFirstElemQueue());
    }

    @Test
    void dequeue()
    {
        queueOfInts.dequeue();
        Assertions.assertEquals(2, queueOfInts.getLastElementQueue());
    }

    @Test
    void numOfElems()
    {
        Assertions.assertEquals(3,queueOfInts.numOfElems());
    }

    @Test
    void peek()
    {
        Assertions.assertEquals(3, queueOfInts.getLastElementQueue());
    }

    @AfterEach
    void tearDown() {
    }

}