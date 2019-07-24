package nursery;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static nursery.JsonManager.*;

public class Main {
  /**
   * Cats nursery.
   *
   * @param args argument.
   */
  public static void main(String[] args) {
    try {
      String menu = "  _ __ ___   ___ _ __  _   _ \n"
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
      System.out.println(menu);
//      System.out.println(new File(".").getAbsolutePath());
      getCatList();
      getCatListSales();

      Scanner sc = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));

      while (sc.hasNext()) {
        String s1 = sc.next();

        switch (s1) {
          case "1":
            catsAll.forEach(cat -> System.out.println(cat.toString()));
            break;
          case "2":
            catsForSale.forEach(cat -> System.out.println(cat.toString()));
            break;
          case "3":
            Cat cat = new Cat();
            cat.setKey((long) (catsAll.size() + 1));
            System.out.println("Введите кличку:");
            cat.setNickname(sc.next());
            System.out.println("Введите рост:");
            cat.setHeight(Float.parseFloat(sc.next()));
            System.out.println("Введите вес:");
            cat.setWeight(Float.parseFloat(sc.next()));
            System.out.println("Введите возраст:");
            cat.setAge(Integer.parseInt(sc.next()));
            catsAll.add(cat);
            System.out.println("Котенок успешно добавлен: " + cat.toString());
            break;
          case "4":
            System.out.println("Введите номер котенка:");
            Long key = Long.parseLong(sc.next());

            Cat foundCat = null;
            boolean found = false;

            for (Cat c : catsAll) {
              if (c.getKey().equals(key)) {
                found = true;
                foundCat = c;
                System.out.println("Редактирование данных котенка: " + c.toString());
                System.out.println("Введите кличку:");
                c.setNickname(sc.next());
                System.out.println("Введите рост:");
                c.setHeight(Float.parseFloat(sc.next()));
                System.out.println("Введите вес:");
                c.setWeight(Float.parseFloat(sc.next()));
                System.out.println("Введите возраст:");
                c.setAge(Integer.parseInt(sc.next()));
              }
            }
            if (!found) {
              System.out.println("Котенок с таким номером не найден");
              break;
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
            break;
          case "5":
            System.out.println("Введите номер котенка:");
            Long key1 = Long.parseLong(sc.next());

            boolean isAdded = false;
            for (Cat c : catsForSale) {
              if (c.getKey().equals(key1)) {
                System.out.println("Котенок уже выставлен на продажу.");
                isAdded = true;
              }
            }
            //если был добавлен выходим.
            if (isAdded) {
              break;
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
            break;
          case "6":
            System.out.println("Введите номер котенка:");
            Long key2 = Long.parseLong(sc.next());

            Cat delCat = new Cat();
            for (Cat c : catsForSale) {
              if (c.getKey().equals(key2)) {
                delCat = c;
              }
            }
            catsForSale.remove(delCat);
            catsAll.remove(delCat);

            System.out.println("Котенок " + delCat.toString() + " продан!");
            break;
          case "0":
            System.out.println(menu);
            generateCatsJson();
            salesCats();
            break;
          default:
            System.err.println("Enter valid");
        }
      }
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }
}
