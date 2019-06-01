package Work1;

import java.util.Scanner;

public class MyPoint extends Point {
  public static void main(String[] args) {
    System.out.print("Введите координаты для точки X1: ");
    Scanner sс = new Scanner(System.in);
    double coordinateX1 = sс.nextDouble();

    System.out.print("Введите координаты для точки Y1: ");
    sс = new Scanner(System.in);
    double coordinateY1 = sс.nextDouble();

    System.out.print("Введите координаты для точки X2: ");
    sс = new Scanner(System.in);
    double coordinateX2 = sс.nextDouble();

    System.out.print("Введите координаты для точки Y2: ");
    sс = new Scanner(System.in);
    double coordinateY2 = sс.nextDouble();
    double distance = theDistanceBetweenTwoPoints(coordinateX1, coordinateY1, coordinateX2, coordinateY2);
    System.out.println("The distance between two points = " + distance);

  }
}