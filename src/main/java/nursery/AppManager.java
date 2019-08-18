package nursery;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static nursery.JsonManager.catsAll;

/**
 * Пульт управления.
 */
class AppManager {
  private static final Scanner SC = new Scanner(new InputStreamReader(System.in,
          StandardCharsets.UTF_8));

  //Шлобальная переменная МЕНЮ.
  static final String MENU = "  _ __ ___   ___ _ __  _   _ \n"
          + " | '_ ` _ \\ / _ \\ '_ \\| | | |\n"
          + " | | | | | |  __/ | | | |_| |\n"
          + " |_| |_| |_|\\___|_| |_|\\__,_|\n"
          + "\n1. Все котята\n"
          + "2. Котята выставленные на продажу\n"
          + "---------------------------------\n"
          + "3. Добавить\n"
          + "4. Изменить\n"
          + "5. Выставить на продажу\n"
          + "6. Продать\n"
          + "0. Выйти";

  //№3.
  static void choice3() {
    Cat cat = new Cat();
    cat.setKey((long) (catsAll.size() + 1));
    System.out.println("Введите кличку:");
    cat.setNickname(SC.next());
    System.out.println("Введите рост:");
    cat.setHeight(Float.parseFloat(SC.next()));
    System.out.println("Введите вес:");
    cat.setWeight(Float.parseFloat(SC.next()));
    System.out.println("Введите возраст:");
    cat.setAge(Integer.parseInt(SC.next()));
    catsAll.add(cat);
    System.out.println("Котенок успешно добавлен: " + cat.toString());
  }
}
