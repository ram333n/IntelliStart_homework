package org.example.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    @Test
    void testHashMap() {
        System.out.println("HashMap");
        MyHashMap<Integer, Integer> map = new MyHashMap<>(5);

        System.out.println(map);
        assertEquals(0, map.size());

        for(int i = 0; i < 10; i++) {
            assertTrue(map.put(i, i * 10));
        }

        assertEquals(10, map.size());
        System.out.println(map);

        assertFalse(map.put(1, 0));
        assertFalse(map.put(2, 0));

        assertEquals(50, map.remove(5));
        assertEquals(0, map.remove(0));
        assertEquals(70, map.remove(7));
        assertNull(map.remove(42));
        assertEquals(7, map.size());

        System.out.println(map);

        assertEquals(10, map.get(1));
        assertEquals(60, map.get(6));
        assertEquals(40, map.get(4));
        assertNull(map.get(5));
        assertNull(map.get(0));
        assertNull(map.get(7));

        map.clear();

        System.out.println(map);
        assertEquals(0, map.size());
        assertNull(map.get(1));
        assertNull(map.get(6));
        assertNull(map.get(4));
        assertNull(map.get(4));
    }
}