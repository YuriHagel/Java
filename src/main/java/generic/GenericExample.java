package generic;

/**
 * Вопрос Николая.
 */
public class GenericExample {
  /**
   * Метод принимает два объекта и возвращает double.
   *
   * @param a   Integer.
   * @param b   Integer.
   * @param <E> Object.
   * @return Double.
   */
  private static <E extends Number> double add(E a, E b) {
    double sum = 0;
    sum = a.intValue() + b.intValue();
    return sum;
  }

  public static void main(String[] args) {
    double genericValue = GenericExample.add(23, 44);
    System.out.println("result: " + genericValue);
  }
}
