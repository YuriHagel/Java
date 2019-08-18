package generic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Необходимо посчитать сумму чисел различного типа,
 * которые хранятся в одном списке.
 */
public class GenericMethod {
  private static Double sum(List<? extends Number> numList) {
    double result = 0.0;
    for (Number num : numList) {
      result += num.doubleValue();
    }
    return result;
  }

  /**
   * Использует параметр типа с верхней границей для поддержки различных типов чисел.
   *
   * @param numList numList.
   * @param <T>     Number.
   * @return Double.
   */
  private static <T extends Number> double sumList2(List<T> numList) {
    return numList.stream().mapToDouble(Number::doubleValue).sum();
  }

  /**
   * Выполнить запуск.
   *
   * @param args argument.
   */
  public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(1, 2, 3, 4);
    List<Number> doubled = Collections.singletonList(sum(ints));
    List<Number> doubled2 = Collections.singletonList(sumList2(ints));
    System.out.println("doubled sum=" + doubled);
    System.out.println("doubled sum=" + doubled2);
  }
}
