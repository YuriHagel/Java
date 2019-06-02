package algorithm;

/**
 * Shell sort.
 */
class SortShell {
  static void sort() {
    int[] mas = new int[10];
    for (int i = 0; i < mas.length; i++) {
      mas[i] = (int) Math.round(Math.random() * 100);
      System.out.print(mas[i] + " ");
    }
    System.out.println();

    //Algorithm
    int d = mas.length / 2;
    while (d > 0) {
      for (int i = 0; i < (mas.length - d); i++) {
        int j = i;
        while ((j >= 0) && (mas[j] > mas[j + d])) {
          int temp = mas[j];
          mas[j] = mas[j + d];
          mas[j + d] = temp;
          j--;
        }
      }
      System.out.println(" d = " + d);
      d = d / 2;
    }
    //outpute date
    System.out.println();
    for (int ma : mas) System.out.print(ma + " ");
  }
}
