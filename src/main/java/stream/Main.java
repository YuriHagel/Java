package stream;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static stream.Solution.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("taks: \n");
    int task = in.nextInt();
    if (task == 1) {
      Random random = new Random();
      List<Integer> list = Stream.generate(() -> random.nextInt(20))
              .limit(10)
              .collect(Collectors.toList());
      try {
        String formattedDouble = new DecimalFormat("#0.00").format(averageDivisibleByOddAndFive(list));
        System.out.println(formattedDouble);
      } catch (Exception e) {
        System.err.println("error=" + e);
      }
    } else if (task == 2) {
      Solution.countOfUniqueLinesLengthLesEight(Arrays.asList("pass", "apple", "qwertyui111", "as", "as", "as"));
    } else if (task == 3) {
      Map<String, Integer> map = new HashMap<>();
      map.put("as", 1);
      map.put("131", 3);
      map.put("as1313131313", 5);
      map.put("132", 1);
      map.put("111111111111131", 3);
      map.put("as131313131313", 5);
      System.out.println("task 3 \n" + sumOfValue(map));
    } else if (task == 4) {
      Random random = new Random();
      List<Integer> list = Stream.generate(() -> random.nextInt(20))
              .limit(10)
              .collect(Collectors.toList());
      System.out.println(concatenation(list));
    } else if (task == 5) {
      Person p1 = new Person("ivan", "ivanov", 22);
      Person p2 = new Person("kate", "smith", 25);
      Person p3 = new Person("asdsadsa", "ivaasdsadasnov", 30);
      Person p4 = new Person("vasia", "ivanov", 40);
      System.out.println("task 5 \n" + getOlderPersonName(Arrays.asList(p1, p2, p3, p4)));

    } else if (task == 6) {
      Solution.list();
    }else if (task ==7) {
      Human p1 = new Human("ivan", "ivanov", 22, Collections.singletonList("internet"));
      Human p2 = new Human("yuri", "sdfsd", 22, Collections.singletonList("internet"));
      Human p3 = new Human("david", "dfss", 22, Collections.singletonList("internet"));
      Human p4 = new Human("ivan", "ddd", 22, Collections.singletonList("internet"));
      Human p5 = new Human("ivan", "ff", 22, Collections.singletonList("internet"));
      Human p6 = new Human("ivan", "df", 22, Collections.singletonList("internet"));
      Human p7 = new Human("ivan", "df", 22, Collections.singletonList("internet"));
      Human p8 = new Human("ivan", "vvvv", 22, Collections.singletonList("internet"));
      List<Human> list = Arrays.asList(p1, p2, p3, p4,p5,p6,p7,p8);
      System.out.println("task 7 \n" + getNotDublicat(list));
    }
  }
}
