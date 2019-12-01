package lambda;

import java.util.*;
import java.util.function.Predicate;

/**
 * Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение.
 * Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает true если переданное число
 * делится без остатка на 13.
 */
public class PredicateSample {
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(10, 20, 26, 36, 44, 88, 13, 69, 100);

    Predicate<Integer> predicate = integer -> integer % 13 == 0;
    System.out.println("Print even numbers in Java 7 style:");
    for (Integer n : list) {
      if (predicate.test(n)) {
        System.out.println(n);
      }
    }

    Predicate<Integer> predicateForEvenNumbers = n -> n % 13 == 0;
    System.out.println("Print even numbers:");
    eval(list, predicateForEvenNumbers);

    Predicate<Integer> predicateGreaterThanTwenty = n -> n > 20;
    System.out.println("Print even numbers greater than 20:");
    eval(list, predicateForEvenNumbers.and(predicateGreaterThanTwenty));
    System.out.println("Print the same:");
    eval(list, n -> n % 13 == 0 && n > 20);

    System.out.println("Print uneven numbers:");
    eval(list, predicateForEvenNumbers.negate());

    System.out.println("Print all even numbers or uneven numbers greater than 20:");
    eval(list, predicateForEvenNumbers.or(predicateForEvenNumbers.negate().and(predicateGreaterThanTwenty)));

    System.out.println("Print test for method isEqual:");
    Predicate<String> sample = Predicate.isEqual("one");
    System.out.println(sample.test("another"));

    System.out.println("Print second test for method isEqual:");
    list.stream().filter(Predicate.isEqual(20)).forEach(System.out::println);

    System.out.println("Print names:");
    List<Person> names = new ArrayList<>();
    names.add(new Person("Richard", "Dawkins"));
    names.add(new Person("Richard", "Feynman"));
    names.add(new Person("Douglas", "Hofstadter"));
    names.add(new Person("Martin", "Odersky"));
    Predicate<Person> pred1 = name -> "Richard".equals(name.getFirstName()); // Все совпадения с именем "Richard"
    Predicate<Person> pred2 = name -> "Odersky".equals(name.getLastName()); // Все совпадения с фамилией "Odersky"
    names.removeIf(pred1.or(pred2)); // Удалим из списка имён все совпадения с уловиями наших предикатов
    names.forEach(System.out::println);
  }

  private static void eval(List<Integer> list, Predicate<Integer> predicate) {
    list.stream()
            .filter(predicate)
            .forEach(System.out::println);
  }
}
