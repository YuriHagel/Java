package nursery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static nursery.JsonPath.CAT;
import static nursery.JsonPath.CATS;
import static nursery.JsonPath.CATS_SALES;

@SuppressWarnings("DM_DEFAULT_ENCODING")
class JsonManager {
  static List<Cat> catsAll = new ArrayList<>();
  static List<Cat> catsForSale = new ArrayList<>();
  private static final Gson gson = new GsonBuilder()
          .setPrettyPrinting()
          .create();

  private JsonManager() {
  }

  static List<Cat> getCatList() {
    List<Cat> catList = null;
    try {
      FileReader fileReader = new FileReader(CATS);
      JsonReader jsonReader = new JsonReader(fileReader);
      Type catType = CAT;
      catList = gson.fromJson(jsonReader, catType);
      jsonReader.close();
      fileReader.close();
    } catch (IOException e) {
      System.out.println("Ошибка чтения файла.\n" + e.getLocalizedMessage());
    }
    return catList;
  }

  static List<Cat> getCatListSales() {
    List<Cat> catList = null;
    try {
      FileReader fileReader = new FileReader(CATS_SALES);
      JsonReader jsonReader = new JsonReader(fileReader);
      Type catType = CAT;
      catList = gson.fromJson(jsonReader, catType);
      jsonReader.close();
      fileReader.close();
    } catch (IOException e) {
      System.out.println("Ошибка чтения файла.\n" + e.getLocalizedMessage());
    }
    return catList;
  }

  @SuppressWarnings("RV_RETURN_VALUE_IGNORED_BAD_PRACTICE")
  static void generateCatsJson() {
    try {
      File jsonFile = new File(CATS);
      jsonFile.createNewFile();
      FileWriter fileWriter = new FileWriter(jsonFile);
      JsonWriter jsonWriter = gson.newJsonWriter(fileWriter);
      Type type = CAT;
      gson.toJson(catsAll, type, jsonWriter);
      jsonWriter.flush();
      jsonWriter.close();
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("Ошибка чтения файла.\n" + e.getLocalizedMessage());
    }
  }

  static void salesCats() {
    try {
      File jsonFile = new File(CATS_SALES);
      jsonFile.createNewFile();
      FileWriter fileWriter = new FileWriter(jsonFile);
      JsonWriter jsonWriter = gson.newJsonWriter(fileWriter);
      Type type = CAT;
      gson.toJson(catsForSale, type, jsonWriter);
      jsonWriter.flush();
      jsonWriter.close();
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("Ошибка чтения файла.\n" + e.getLocalizedMessage());
    }
  }
}
