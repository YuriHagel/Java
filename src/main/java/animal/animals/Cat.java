package animal.animals;

import animal.Feline;
import animal.Pet;

import javax.naming.Name;

public  class Cat extends Feline implements Pet {
  private final static String NAME = "Markiz";
  private String food = "Meat";
  private String breed = "Siamse";
  private String type = "cat";


  public Cat() {
    setBreed(breed);
    setFoodEaten(food);
    setAnimalType(type);
    setLocation("Home");
    setPower(10);
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
  public void eat() {
    System.out.println(getClass().getSimpleName() + " eats " + food + " Cats are obligate carnivores, in other words, meat eaters");
  }
  public void eat(String meat) {
    System.out.println(getClass().getSimpleName() + " eats " + meat);
  }
  public void eat(int meat, String food) {
    System.out.println(getClass().getSimpleName() + " eats " + meat + " " + food);

  }
  public void eat(String meat,short cycle) {
    System.out.println(getClass().getSimpleName() + " eats " + meat + "to " + cycle);
  }
  @Override
  public void sleep() {
    System.out.println(this.type + " sleeps in a cloud");
  }
  @Override
  public void makeNoise() {
    System.out.println(this.type + " say meow, may be hungry ");

  }

  public void infoCat() {
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
    System.out.println(NAME
            + ": I'm friendly!");
  }
  @Override
  public String getName() {
    return NAME;
  }

}
