package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTests {
    Map<String, Integer> map = new HashMap<>(50);
    List<Integer> list = new ArrayList<>(16);
    List<Integer> arrays = new ArrayList<>(list);
    Set<Integer> tree = new TreeSet<>();

    @Test
    void mapTest(){
        map.put("Один", 1);
        map.put("Два", 2);
        int size = map.size();
        Integer i = map.get("Один");
        boolean empty = map.isEmpty();
        Set<String> strings = map.keySet();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(map),
                () -> Assertions.assertEquals(2, size),
                () -> Assertions.assertEquals(1, i),
                () -> Assertions.assertFalse(empty),
                () -> Assertions.assertNotNull(strings),
                () -> Assertions.assertInstanceOf(Set.class, strings)
        );
    }

    @Test
    void listTest(){
        list.add(5);
        list.add(2);
        list.add(3);
        Integer element = list.get(0);
        int sizeList = list.size();
        boolean empty = list.isEmpty();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(list),
                () -> Assertions.assertEquals(5, element),
                () -> Assertions.assertEquals(3, sizeList),
                () -> Assertions.assertFalse(empty)
        );
    }


    @Test
    void setTest(){
        tree.add(3);
        int size = tree.size();
        boolean treeSetEmpty = tree.isEmpty();
        boolean contains = tree.contains(3);
        boolean containsAll = tree.containsAll(list);
        boolean retainAll = tree.retainAll(list);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(tree),
                () -> Assertions.assertEquals(1, size),
                () -> Assertions.assertFalse(treeSetEmpty),
                () -> Assertions.assertTrue(contains),
                () -> Assertions.assertTrue(containsAll),
                () -> Assertions.assertTrue(retainAll)
        );
    }

    @Test
    void methodCollectionsForArrayList(){
        List<Integer> testList1 = new ArrayList<>(20);
        testList1.add(5);
        testList1.add(2);
        testList1.add(3);
        Assertions.assertAll("methodCollectionsForArrayList",
                () -> Collections.sort(testList1),
                () -> Collections.swap(testList1, 0, 2),
                () -> Collections.max(testList1),
                () -> Collections.min(testList1),
                () -> Collections.binarySearch(testList1, 1),
                () -> Collections.copy(testList1, arrays),
                () -> Collections.unmodifiableList(testList1),
                () -> Collections.checkedList(testList1, Integer.class),
                () -> Collections.indexOfSubList(testList1, arrays),
                () -> Collections.fill(testList1, 2),
                () -> Collections.reverse(testList1),
                () -> Collections.rotate(testList1, 2),
                () -> Collections.shuffle(testList1),
                () -> Collections.lastIndexOfSubList(testList1, arrays));
    }
}
