package enums;

/**
 * Создать перечисление(enum) месяцев,
 * в котором будут храниться данный формата February - Февраль.
 */
public class Months {
  /**
   * Выполнить запуск.
   *
   * @param args argument.
   */
  public static void main(String[] args) {
    for (Month month : Month.values()) {
      System.out.println(month + " - " + month.getValue());
    }
  }
}
