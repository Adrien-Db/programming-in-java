package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    DLinkList<Integer> dLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
        dLinkList.addFirst(3);
        dLinkList.addFirst(2);
        dLinkList.addFirst(1);
        System.out.print(dLinkList);
    }

    @Test
    void addFirst(){
        dLinkList.addFirst(45);
        Assertions.assertEquals(45, dLinkList.returnFirstElem());
    }

    @Test
    void addLast(){
        dLinkList.addLast(45);
        Assertions.assertEquals(45, dLinkList.returnLastElem());
    }

    @Test
    void removeFirst(){
        dLinkList.removeFirst();
        Assertions.assertEquals(2, dLinkList.returnFirstElem());
    }

    @Test
    void removeLast(){
        dLinkList.removeLast();
        Assertions.assertEquals(2, dLinkList.returnLastElem());
    }

    @AfterEach
    void tearDown() {
    }
}