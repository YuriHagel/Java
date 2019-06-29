package animal;

/**
 * Abstract class animal.
 */
public abstract class Animal implements Creator {
  private double animalHeight;
  private double animalWeight;
  private String foodEaten;
  private String animalType;
  private int power;
  private String location;
  private double speed;

  protected int getPower() {
    return power;
  }

  protected void setPower(int power) {
    this.power = power;
  }

  protected  double getAnimalHeight() {
    return animalHeight;
  }

  protected void setAnimalHeight(double AnimalHeight) {
    this.animalHeight = AnimalHeight;
  }

  protected double getSpeed() {
    return speed;
  }

  protected void setSpeed(double speed) {
    this.speed = speed;
  }


  protected double getAnimalWeight() {
    return animalWeight;
  }

  protected void setAnimalWeight(double newWeight) {
    if (newWeight > 0) {
      this.animalWeight = newWeight;
    } else {
      System.out.println("Вес должен быть > 0 , retry please ");
      System.exit(0);
    }
  }

  protected String getFoodEaten() {
    return foodEaten;
  }

  protected void setFoodEaten(String foodEaten) {
    this.foodEaten = foodEaten;
  }

  protected String getAnimalType() {
    return animalType;
  }

  protected void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  protected String getLocation() {
    return location;
  }

  protected void setLocation(String location) {
    this.location = location;
  }

  protected abstract void eat();

  protected abstract void sleep();

  protected abstract void makeNoise();

  protected abstract void roam();

  @Override
  public void live() {
    System.out.println("I can live");
  }
}
