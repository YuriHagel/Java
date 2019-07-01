package animal.animals;

import animal.Canine;
import animal.Pet;

/**
 * Class dog.
 */
public class Dog extends Canine implements Pet {
  private final static String NAME = "Lucky";
  private String food = "Meat";
  private String breed = "poodle";
  private String type = "dog";

  //Constructor
  public Dog() {
    setBreed(breed);
    setFoodEaten(food);
    setAnimalType(type);
    setLocation("Home");
    setPower(20);
    setSpeed(33.3);
    setAnimalWeight(5.5);
    setAnimalHeight(20.2);
  }

  private String getBreed() {
    return breed;
  }

  private void setBreed(String breed) {
    this.breed = breed;
  }

  @Override
  public void makeNoise() {
    System.out.println(this.type + " say bark, may be angry");
  }

  @Override
  public void eat() {
    System.out.println(getClass().getSimpleName() + " eats " + food + " Dogs are obligate carnivores, in other words, meat eaters");
  }

  @Override
  public void sleep() {
    System.out.println(this.type + " sleeps in a cloud");
  }

  public void infoDog() {
    System.out.println(getClass().getSimpleName() + " info \n"
            + "speed \"" + getSpeed() + "\" км/ч \n"
            + "breed \"" + getBreed() + "\" \n"
            + "food  \"" + getFoodEaten() + "\" 5 count\n"
            + "type  \"" + getAnimalType() + "\"\n"
            + "weight \"" + getAnimalWeight() + "\"kg\n"
            + "height \"" + getAnimalHeight() + "\"см\n"
            + "location \"" + getLocation() + "\"\n"
            + "power \"" + getPower() + "\"\n");
  }

  @Override
  public void beFriendly() {
    System.out.println(getClass().getSimpleName() + NAME
            + ": I'm friendly!");
  }

  @Override
  public String getName() {
    return NAME;
  }
}
