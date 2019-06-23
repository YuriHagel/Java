package animal;

import animal.animals.Bug;
import animal.animals.Cat;
import animal.animals.Dog;
import animal.animals.Wolf;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {
  private static final Logger LOG = Logger.getLogger(Main.class);

  public static void main(String[] args) {
    overload();
    System.out.println("...............");

    //Polymorphism array
    Animal[] animals = new Animal[7];
    animals[0] = new Cat();
    animals[1] = new Wolf();
    animals[2] = new Dog();
    animals[3] = new Bug();
    feedAllAnimals(animals);

    try {
      Scanner in = new Scanner(System.in);
      System.out.println("If you want more information about animals, select the number.\n"
              + "   \"Enter number of animal :\n"
              + "                don't choose - 0\n"
              + "                animal(Cat) - 1\n"
              + "                animal(Dog) - 2\n"
              + "                animal(Wolf) -3\n"
              + "                animal(Bug) - 4\n");
      short animal = in.nextShort();
      if (animal == 1) {
        // Так как нестатичный,пришлось создать объект.
        Cat cat = new Cat();
        cat.infoCat();
      }
      if (animal == 2) {
        Dog dog = new Dog();
        dog.infoDog();
      } else if (animal == 3) {
        Wolf wolf = new Wolf();
        wolf.infoWolf();
      } else if (animal == 4) {
        Bug bug = new Bug();
        bug.infoBug();
      } else if (animal == 0) {
        in.close();
      } else {
        System.err.println("error: not valid");
      }
      in.close();
    } catch (Exception e) {
      LOG.error("Enter the number of animals to display.", e);
    }
  }

  private static void feedAllAnimals(Animal[] animals) {
    for (Animal animal : animals) {
      if (animal != null) {
        animal.eat();
        animal.makeNoise();
        animal.sleep();
        animal.roam();
      }
    }
  }

  private static void overload() {
    //Перегрузка методов.
    Cat exam = new Cat();
    exam.eat();
    exam.eat("fish");
    exam.eat(6, "whiskas");
    exam.eat("kitekat", (short) 3);
  }
}