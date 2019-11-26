public class Animal {
  private int numberOfLegs;
  protected String type;

  public Animal(String type, int legs) {
    this.numberOfLegs = legs;
    this.type = type;
  }

  public Animal(int legs) {
    this.numberOfLegs = legs;
  }

  public Animal(String animalType) {
    type = animalType;
  }

  public Animal() {

  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public int getNumberOfLegs() {
    return this.numberOfLegs;
  }

  public void setNumberOfLegs(int legs) {
    if (legs < 0) {
      legs = 0;
    }
    this.numberOfLegs = legs;
  }
}