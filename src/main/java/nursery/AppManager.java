package nursery;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static nursery.JsonManager.*;

/**
 * Пульт управления AppManager.
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

  //№4.
  static void choice4() {
    System.out.println("Введите номер котенка:");
    Long key = Long.parseLong(SC.next());

    Cat foundCat = null;
    boolean found = false;
    for (Cat c : catsAll) {
      if (c.getKey().equals(key)) {
        found = true;
        foundCat = c;
        System.out.println("Редактирование данных котенка: " + c.toString());
        System.out.println("Введите кличку:");
        c.setNickname(SC.next());
        System.out.println("Введите рост:");
        c.setHeight(Float.parseFloat(SC.next()));
        System.out.println("Введите вес:");
        c.setWeight(Float.parseFloat(SC.next()));
        System.out.println("Введите возраст:");
        c.setAge(Integer.parseInt(SC.next()));
      }
    }
    if (!found) {
      System.out.println("Котенок с таким номером не найден");
      return;
    }
    for (Cat c : catsForSale) {
      if (c.getKey().equals(foundCat.getKey())) {
        c.setNickname(foundCat.getNickname());
        c.setHeight(foundCat.getHeight());
        c.setWeight(foundCat.getWeight());
        c.setAge(foundCat.getAge());
      }
    }
    System.out.println("Успешно редактирован: " + foundCat.toString());
    System.exit(0);
  }

  //№4.
  static void numberFive() {
    System.out.println("Введите номер котенка:");
    Long key1 = Long.parseLong(SC.next());

    boolean isAdded = false;
    for (Cat c : catsForSale) {
      if (c.getKey().equals(key1)) {
        System.out.println("Котенок уже выставлен на продажу.");
        isAdded = true;
      }
    }
    //если был добавлен выходим.
    if (isAdded) {
      return;
    }
    for (Cat c : catsAll) {
      if (c.getKey().equals(key1)) {
        if (c.getAge() >= 2) {
          catsForSale.add(c);
          System.out.println("Котенок выставлен на продажу: " + c.toString());
        } else {
          System.out.println("Котенок еще слишком мал.");
        }
      }
    }
    System.exit(0);
  }
}
