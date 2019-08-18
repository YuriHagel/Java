package nursery;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static nursery.AppManager.*;
import static nursery.JsonManager.*;

@SuppressWarnings("SF_SWITCH_FALLTHROUGH")
public class Main {
  /**
   * Cats nursery.
   *
   * @param args argument.
   */
  public static void main(String[] args) {
    try {
      System.out.println(AppManager.MENU);
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
            choice3();
            break;
          case "4":
            choice4();
          case "5":
            numberFive();
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
            System.out.println(AppManager.MENU);
            generateCatsJson();
            salesCats();
            break;
          default:
            System.err.println("You did not enter a valid option. Please enter a valid option");
        }
      }
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }
}
