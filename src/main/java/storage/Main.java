package storage;

import java.time.LocalDate;

import static storage.KeyStorage.newKey;
import static storage.KeyStorage.oldKey;

public class Main {

  public static void main(String[] args) {
    keys();
    keys();

  }

  private static LocalDate actualKey() {
   return (LocalDate) newKey.get("date");
  }

  public static void keys() {
    GetFreeKey getFreeKey = new GetFreeKey();
    if(actualKey() == null) {
      getFreeKey.getKey();
      System.out.println("Первый шаг когда ключа нет " + newKey.values());
    } else if (LocalDate.now().isAfter(actualKey())) {
      getFreeKey.getOldKey();
      System.out.println("Когда ключ протух " + oldKey.values());
      getFreeKey.getKey();
      System.out.println("новый ключ " + newKey.values());

    }
  }
}
