package animal;

import animal.animals.Bug;
import animal.animals.Cat;
import animal.animals.Dog;
import animal.animals.Wolf;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

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
      System.out.println("Enter the number of animals to display.");
      e.printStackTrace();
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
}