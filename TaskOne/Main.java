package TaskOne;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Hanna", "Ivan", "Dmytro", "Anton", "Iryna", "Vasyl");

        System.out.println(names.stream().map(String::length).collect(Collectors.toList()));

        System.out.println(getOddIndexNames(names));
        System.out.println(getNamesInUpperCase(names));
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

}
