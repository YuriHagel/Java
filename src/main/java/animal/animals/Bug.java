package animal.animals;

import animal.Insect;

/**
 * Class dog.
 */
public class Bug extends Insect {
  private String food = "Human";
  private String breed = "klopp";
  private String type = "bug";

  public Bug() {
    setBreed(breed);
    setFoodEaten(food);
    setAnimalType(type);
    setLocation("Home");
    setPower(1);
    setSpeed(2);
    setAnimalWeight(0.1);
    setAnimalHeight(0.1);
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  @Override
  public void makeNoise() {
    System.out.println(getClass().getSimpleName() + "soundless");
  }

  @Override
  public void eat() {
    System.out.println(getClass().getSimpleName() + food);
  }

  @Override
  public void sleep() {
    System.out.println(getClass().getSimpleName() + "sleep at day");
  }

  public void infoBug() {
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
