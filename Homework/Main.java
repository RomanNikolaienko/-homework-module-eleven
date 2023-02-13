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
    }

    public static List<String> getOddIndexNames(List<String> names) {
        return IntStream
                .range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(names::get)
                .toList();
    }

    public static List<String> getNamesInUpperCase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<String> sortNumbersInStringList(List<String> list){
        return list.stream()
                .map(s -> List.of(s.split(", ")))
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());
    }

}
