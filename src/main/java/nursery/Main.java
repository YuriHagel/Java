package nursery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static List<Cat> catsAll = new ArrayList<>();
  private static List<Cat> catsForSale = new ArrayList<>();
  private static final Gson gson = new GsonBuilder()
          .setPrettyPrinting()
          .create();
  private static java.lang.reflect.Type typeOfHashMap = new TypeToken<List<Cat>>() {
  }.getType();


  public static void main(String[] args) throws IOException {

    String menu = "  _ __ ___   ___ _ __  _   _ \n" +
            " | '_ ` _ \\ / _ \\ '_ \\| | | |\n" +
            " | | | | | |  __/ | | | |_| |\n" +
            " |_| |_| |_|\\___|_| |_|\\__,_|\n"
            + "\n1. Все котята\n2. Котята выставленные на продажу\n---------------------------------\n3. Добавить\n4. Изменить\n5. Выставить на продажу\n6. Продать\n0. Выйти";
    System.out.println(menu);

    //загрузим данные из файла
    try (JsonReader readerAll = new JsonReader(new FileReader("d:/catsAll.txt"))) {
      catsAll = gson.fromJson(readerAll, typeOfHashMap);
    } catch (IOException ex) {
      System.out.println("Ошибка чтения файла.\n" + ex.getLocalizedMessage());
    }

    try (JsonReader readerToBay = new JsonReader(new FileReader("d:/catsToBay.txt"))) {
      catsForSale = gson.fromJson(readerToBay, typeOfHashMap);
    } catch (IOException ex) {
      System.out.println("Ошибка чтения файла.\n" + ex.getLocalizedMessage());
    }

    Scanner sc = new Scanner(new InputStreamReader(System.in, "UTF-8"));

    while (sc.hasNext() == true) {
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
          cat.setKey(new Date().getTime());
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
          if (found == false) {
            System.out.println("Котенок с таким номером не найден");
            break;
          }
          for (Cat c : catsForSale) {
            if (foundCat != null && c.getKey().equals(foundCat.getKey())) {
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
          if (isAdded) break; //если был добавлен выходим
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
      }
      System.out.println(menu);
      if (s1.equals("0")) {
        try (Writer writer = new FileWriter("d:/catsAll.txt")) {
          gson.toJson(catsAll, writer);
        }
        try (Writer writer = new FileWriter("d:/catsToBay.txt")) {
          gson.toJson(catsForSale, writer);
        }
        break;
      }
    }
  }
}
