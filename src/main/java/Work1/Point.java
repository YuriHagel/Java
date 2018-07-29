package Work1;

import java.util.Scanner;

public class Point {
  public static double theDistanceBetweenTwoPoints(double coordinateX1, double coordinateY1,
                                                    double coordinateX2, double coordinateY2 ) {
    return Math.pow(Math.pow(coordinateX1-coordinateX2, 2) + Math.pow(coordinateY1-coordinateY2, 2), 0.5);
  }


}