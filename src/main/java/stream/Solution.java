package stream;

import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;
import one.util.streamex.IntStreamEx;
import one.util.streamex.StreamEx;
import org.junit.Assert;

import java.util.*;
import java.util.stream.Collectors;


public class Solution {

  /**
   * Дан список целых чисел.
   * Найти среднее всех нечётных чисел, делящихся на 5.
   */
  public static double averageDivisibleByOddAndFive(List<Integer> list) {
    return list
            .stream()
            .filter(integer -> integer % 5 == 0)
            .filter(integer -> integer % 2 != 0)
            .mapToInt(Integer::intValue)
            .average()
            .getAsDouble();
  }

  /*Дан список строк. Найти количество уникальных строк длиной более 8 символов. */
  public static long countOfUniqueLinesLengthLesEight(List<String> list) {
    return list
            .stream()
            .filter(s -> s.length() <= 8)
            .distinct()
            .count();
  }

  /*Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов. */
  public static long sumOfValue(Map<String, Integer> map) {
    return map
            .entrySet()
            .stream()
            .filter(m -> m.getKey().length() < 7)
            .mapToInt(Map.Entry::getValue)
            .sum();
  }

  public static String concatenation(List<Integer> list) {
    return list
            .stream()
            .map(Object::toString)
            .reduce("", (base, element) -> base + element);

  }

  /*Дан класс Person с полями firstName, lastName, age.
    Вывести полное имя самого старшего человека, у которого длина этого имени не превышает 15 символов. */
  public static String getOlderPersonName(List<Person> people) {
    return people.stream()
            .filter(person -> person.getFirstName().length() + person.getLastName().length() < 15)
            .sorted((person1, person2) -> Integer.compare(person2.getAge(), person1.getAge()))
            .map(person -> person.getFirstName() + " " + person.getLastName())
            .findFirst()
            .get();
  }

  /*Разделить массив по 5 пачек и прибавить массив */
  public static void list() {
    List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "j", "k");
    List<Integer> input = IntStreamEx.range(12).boxed().toList();
    System.out.println(StreamEx.ofSubLists(input, 5).joining("-").concat("-").concat(list.toString()));
  }

  public static String getNotDublicat(List<Human> people) {
    Optional.ofNullable(people).ifPresent(data -> {
      mergeList(data);
      data.forEach(i -> {
//        i.getBalanceSheets().removeIf(x -> Objects.isNull(x.getBalanceTypeId()));
      });
    });
    return String.valueOf(people);
  }

  private static void mergeList(List<Human>  people) {
    List<Human> inList = people.stream()
            .filter(f -> f.firstName != null)
            .collect(Collectors.toList());
    people.removeIf(inList::contains);

    List<Human> list2 = people.stream()
            .filter(f -> f.firstName != null)
            .collect(Collectors.toList());
    people.removeIf(list2::contains);

    Map<Human, List<Human>> inOutPairs = list2.stream()
            .collect(Collectors.toMap(out -> out, out -> inList.stream()
                    .filter(in -> StringUtils.right(in.age(), 2).equals(StringUtils.right(out.age(), 2)))
//                            && (in.getEventDt().equals(out.getEventDt()) || in.getEventDt().before(out.getEventDt())))
                    .collect(Collectors.toList())));

    Set<String> excludeInList = new HashSet<>();
    inOutPairs.entrySet().stream().filter(f -> !f.getValue().isEmpty()).forEach(a ->
            a.getValue().stream().max(Comparator.comparing(Human::getAge)).ifPresent(inWithMaxDate -> {
              excludeInList.add(inWithMaxDate.getFirstName());
              inWithMaxDate.setAge(a.getKey().getAge());
              people.add(inWithMaxDate);
            }));

    inList.removeIf(a -> excludeInList.contains(a.getFirstName()));
    people.addAll(inList);
  }
}
