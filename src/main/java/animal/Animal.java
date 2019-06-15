package animal;

/**
 * Abstract class animal.
 */
public abstract class Animal {
  double animalHeight;
  double animalWeight;
  String foodEaten;
  String animalType;
  int power;
  String location;
  double speed;

  public Animal() {
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public double getAnimalHeight() {
    return animalHeight;
  }

  public void setAnimalHeight(double AnimalHeight) {
    this.animalHeight = AnimalHeight;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }


  public double getAnimalWeight() {
    return animalWeight;
  }

  public void setAnimalWeight(double newWeight) {
    if (newWeight > 0) {
      this.animalWeight = newWeight;
    } else {
      System.out.println("Вес должен быть > 0 , retry please ");
      System.exit(0);
    }
  }

  public String getFoodEaten() {
    return foodEaten;
  }

  public void setFoodEaten(String foodEaten) {
    this.foodEaten = foodEaten;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  protected abstract void eat();

  protected abstract void sleep();

  protected abstract void makeNoise();

  protected abstract void roam();
}
