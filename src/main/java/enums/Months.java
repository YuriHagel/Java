package enums;

/**
 * Создать перечисление(enum) месяцев,
 * в котором будут храниться данный формата February - Февраль.
 */
public class Months {
  public static void main(String[] args) {
    for (Month month : Month.values()) {
      System.out.println(month + " - " + month.getValue());
    }
  }
}
