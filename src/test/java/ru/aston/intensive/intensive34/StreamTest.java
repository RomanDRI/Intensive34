package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamTest {

    @Test
    void multiplierStream(){
        //Умножить каждое число в массиве [1, 2, 3, 4, 5] на 2,
        int[] array = {1,2,3,4,5};
        int multiplier = 2;
        IntStream.range(0, array.length).map(i-> array[i]*multiplier).forEach(System.out::println);
    }

    @Test
    void reduce(){
        //Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()
        int[] array = {1,2,3,4,5};
        int sum = Arrays.stream(array).reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    void firstTen(){
        //Вывести первые 10 чисел в списке [0, 1, 2, … 99]
        IntStream.range(0,99).limit(10).forEach(System.out::println);

    }

    @Test
    void evenNumber() {
        //Проверить, есть ли четное число в списке [0, 1, 2, 3],
        int[] array = {1,2,3};
        IntStream.range(0, array.length).filter(i -> i%2!=0).map(i -> array[i]).forEach(System.out::println);
    }

    @Test
    void streamUnion() {
        //Создать два стрима: один из чисел от 0 до 10, другой из чисел от 10 до 20.
        // Объединить их в один стрим и вывести на экран числа больше 10.
        Stream<Integer> zeroToTen = Stream.of(0,1,2,3,4,5,6,7,8,9);
        Stream<Integer> tenToTwenty = Stream.of(10,11,12,13,14,15,16,17,18,19,20);

        Stream.concat(zeroToTen, tenToTwenty).filter(i -> i>10).forEach(System.out::println);
    }

    @Test
    void streamUnionFive(){
        //Создать три стрима из массивов чисел от 1 до 10, от 10 до 20 и от 20 до 30 соответственно.
        // Объединить их в один стрим и вывести числа, которые кратны 5.
        Stream<Integer> zeroToTen = Stream.of(0,1,2,3,4,5,6,7,8,9);
        Stream<Integer> tenToTwenty = Stream.of(10,11,12,13,14,15,16,17,18,19);
        Stream<Integer> twentyToThirty = Stream.of(20,21,22,23,24,25,26,27,28,29);

        Stream<Integer> zeroToTwenty = Stream.concat(zeroToTen,tenToTwenty);

        Stream.concat(zeroToTwenty, twentyToThirty).filter(i -> i%5==0).forEach(System.out::println);
    }

    @Test
    void numbersFromTenToTwenty(){
        //Создать стрим из массива чисел и вывести на экран только числа, которые больше 10 и меньше 20.

        IntStream.range(0,60).filter(i -> i>10).filter(j -> j<20).forEach(System.out::println);
    }

    @Test
    void distinctStream(){
        //Выведите только те элементы коллекции, которые удовлетворяют определенному условию, например, являются уникальными или имеют определенный формат.
        Stream<String> patStream = Stream.of("Cat", "Dog", "mouse", "Dog", "mouse", "Cat", "Bird", "Mouse", "Cat", "bird");
        patStream.distinct().forEach(System.out::println);

    }

    @Test
    void groupInt(){
        //Разделить элементы Stream на две группы: четные и нечетные, посчитать сумму в каждой группе вывести результаты.
        int[] array = {1,2,3,4,5};
        Map<Boolean, Integer> collect = IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> i % 2 == 0 ,Collectors.summingInt(i -> array[i])));

        System.out.println(collect);
    }

    @Test
    void groupString(){
        //Собрать все уникальные элементы Stream в список и отсортировать их.
        String[] strings = {"b","c","a","d", "h"};
        List<String> stringList = Arrays.stream(strings).distinct().sorted().collect(Collectors.toList());
        System.out.println(stringList);
    }

}
