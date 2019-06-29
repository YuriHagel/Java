package animal.animals;

import animal.Canine;

public class Wolf extends Canine {
  private String food = "Meat";
  private String breed = "Canadian wolf";
  private String type = "wolf";

  public Wolf() {
    setBreed(breed);
    setFoodEaten(food);
    setAnimalType(type);
    setLocation("Wood");
    setPower(60);
    setSpeed(70);
    setAnimalWeight(30);
    setAnimalHeight(100);
  }

  private String getBreed() {
    return breed;
  }

  private void setBreed(String breed) {
    this.breed = breed;
  }

  @Override
  public void makeNoise() {
    System.out.println(this.type + " say woooo");
  }

  @Override
  public void eat() {
    System.out.println(getClass().getSimpleName() + " eats " + food + " Wolves are carnivores, and their\n"
            + " diet consists primarily of ungulates (hoofed mammals) such as deer, moose and wild boar.\n"
            + " These large animals are supplemented with a number of small animals, such as beavers, rabbits,\n"
            + " rodents, birds, reptiles, and even insects.");
  }

  @Override
  public void sleep() {
    System.out.println(this.type + "wolves sleep right out in the open in a circle.");
  }

  public void infoWolf() {
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
}
