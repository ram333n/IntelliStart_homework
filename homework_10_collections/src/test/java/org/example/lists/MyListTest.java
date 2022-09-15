package org.example.lists;

import org.example.lists.array_list.MyArrayList;
import org.example.lists.linked_list.MyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    private void testList(MyList<Integer> list) {
        assertEquals(0, list.size());

        System.out.println(list);

        for(int i = 0; i < 9; i++) {
            list.add(i);
        }

        System.out.println(list);

        assertEquals(9, list.size());
        assertEquals(0, list.get(0));
        assertEquals(5, list.get(5));
        assertEquals(8, list.get(8));

        list.add(42);
        list.add(32);

        System.out.println(list);

        assertEquals(11, list.size());
        assertEquals(0, list.get(0));
        assertEquals(5, list.get(5));
        assertEquals(42, list.get(9));
        assertEquals(32, list.get(10));

        list.remove(0);
        list.remove(5);
        list.remove(list.size() - 1);

        System.out.println(list);

        assertEquals(8, list.size());
        assertEquals(1, list.get(0));
        assertEquals(7, list.get(5));
        assertEquals(42, list.get(list.size() - 1));

        list.clear();
        assertEquals(0, list.size());

        System.out.println(list);

        try {
            list.get(0);
            fail();
        } catch (IndexOutOfBoundsException e) {}
    }

    @Test
    void testArrayList() {
        testList(new MyArrayList<>());
    }

    @Test
    void testLinkedList() {
        testList(new MyLinkedList<>());
    }
}