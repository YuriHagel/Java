package nursery;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

class JsonPath {
  static final String CATS = getPath() + "cats.json";
  static final String CATS_SALES = getPath() + "catsToBuy.json";
  static java.lang.reflect.Type CAT = new TypeToken<List<Cat>>() {
  }.getType();

  private static String getPath() {
    String path;
    try {
      path = Paths.get(".")
              .resolve("../jsons/")
              .toFile()
              .getCanonicalPath();
    } catch (IOException ignored) {

    }
    path = "src/main/java/nursery/jsons/";
    return path;
  }
}
