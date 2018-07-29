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

    Square s = new Square(5);


    System.out.println("Площадь квадрата со стороной " + s.len + "=" + s.area());

    Rectangle r = new Rectangle(4,6);

    System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + "=" + r.area());
  }
  public static void hello (String somebody){
    System.out.println("Hello, " + somebody + "!");
  }




}
