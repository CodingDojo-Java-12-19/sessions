public class Cat extends Animal implements IAnimal {

  public Cat(int legs) {
    super("Cat", legs);
  }

  public Cat() {
    super("Cat", 4);
  }

  public void run() {
    System.out.println("The cat is running!!!");
  }

  public void makeSound() {
    System.out.println("Meow");
  }
}
