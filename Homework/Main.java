package Homework;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Hanna", "Ivan", "Dmytro", "Anton", "Iryna", "Vasyl");
        List<String> arrayList = List.of("1, 2, 0", "4, 5");

        System.out.println(getOddIndexNames(names));
        System.out.println(getNamesInUpperCase(names));
        System.out.println(sortNumbersInStringList(arrayList));

        Stream<Long> stream = myLinearCongruentGenerator(25214903917L, 11L, 2L,48, 100);

        Stream<String> stream1 = names.stream();
        Stream<String> stream2 = arrayList.stream();

        System.out.println(zip(stream1, stream2).collect(Collectors.toList()));
    }

    //task 1
    public static List<String> getOddIndexNames(List<String> names) {
        return IntStream
                .range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(names::get)
                .toList();
    }

    //task 2
    public static List<String> getNamesInUpperCase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    //task 3
    public static List<String> sortNumbersInStringList(List<String> list) {
        return list.stream()
                .map(s -> List.of(s.split(", ")))
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());
    }

    //task 4
    public static Stream<Long> myLinearCongruentGenerator(long a, long c, long m, int inPower, int numbersLimit) {
        Stream<Long> stream = Stream.iterate(1L, x -> (long) ((a * x + c) % Math.pow(m, inPower)));
        stream.limit(numbersLimit).peek(System.out::println).collect(Collectors.toList());
        return stream;
    }

    //task 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> result = new ArrayList<>();
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        while (firstIterator.hasNext() && secondIterator.hasNext()){
            result.add(firstIterator.next());
            result.add(secondIterator.next());
        }
        return result.stream();
    }

}
