public class Test {
  public static void main(String[] args) {
    Animal animal = new Animal(3);
    Cat cat = new Cat();

    // animal.numberOfLegs = 9;
    animal.setNumberOfLegs(-1);

    System.out.println(cat.getType());

    cat.run();
    // animal.run();

    System.out.println(animal.getNumberOfLegs());
  }
}