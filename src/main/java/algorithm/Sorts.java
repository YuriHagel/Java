package algorithm;

import java.util.Scanner;

/**
 * Selection of sorts.
 */
public class Sorts {
  private static void choseSort() {
    try {
      Scanner in = new Scanner(System.in);
      //Select the sorting option that you want to use.
      System.out.println("HOMEWORK \n"
              + "Enter number of task :\n"
              + "SortShell\n"
              + "   task1(SortShell) - 1\n");

      int task = in.nextInt();
      if (task == 1) {
        SortShell.sort();
      } else {
        System.err.println("Enter valid");
        choseSort();
      }
      in.close();
    } catch (Exception e) {
      System.out.println("Enter the number of tasks to display on each row in the Sorter.");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    choseSort();
  }
}
