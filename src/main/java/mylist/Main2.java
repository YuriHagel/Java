package mylist;

public class Main2 {
  /**
   * Хранит в себе массив объектов любых типов данных.
   * @param args  argument.
   */
  public static void main(String[] args) {
    MyList<Object> ml = new MyList<>();
    ml.add(1.0);
    ml.add(2);
    ml.add("brrr");
    ml.add(6);
    ml.printList();
    System.out.println("Значение: " + ml.getToIndex().data);
  }
}
