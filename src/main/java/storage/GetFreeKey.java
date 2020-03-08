package storage;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Random;

import static storage.KeyStorage.*;

public class GetFreeKey {
  private static Random random = new Random(5);

public void getKey() {
  newKey.put("base", getRandomString());
  newKey.put("date", LocalDate.now().minusMonths(1));
  newKey.put("keyId", getRandomString());
}

  public void getOldKey() {
    oldKey.put("base", newKey.get("base"));
    oldKey.put("date", newKey.get("date"));
    oldKey.put("keyId", newKey.get("keyId"));
  }

  private static String getRandomString(){
    byte[] array = new byte[7]; // length is bounded by 7
    new Random().nextBytes(array);
    return new String(array, StandardCharsets.UTF_8);
  }

}
