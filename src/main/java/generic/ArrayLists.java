package generic;

import java.util.ArrayList;

public class ArrayLists {
  static void main(String[] args) {
    ArrayList<Object> arrayList = new ArrayList<>();
    arrayList.add("good");
    arrayList.add(4);
    arrayList.add(4.67);
    arrayList.add("bad");
    for (Object object : arrayList) {
      System.out.println(arrayList.indexOf(object));
    }
  }
}
