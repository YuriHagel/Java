package Sandbox;

/**
 * Java. My first program
 * @author Yuri Hagel
 * @version  dated Jul 29, 2018
 */
public class First {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Yuri");
    double len = 5;
    System.out.println("Площадь квадрата со стороной " + len + "=" + area(len));

    double a = 4;
    double b = 6;
    System.out.println("Площадь прямоугольника со стороной " + a + " и " + b + "=" + area(a,b));
  }
  public static void hello (String somebody){
    System.out.println("Hello, " + somebody + "!");
  }
  public static double area(double l){
    return l * l;
  }

  public static double area(double a, double b){
    return a *b;

  }

}
