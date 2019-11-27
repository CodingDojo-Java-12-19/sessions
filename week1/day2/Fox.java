public class Fox extends Animal implements IAnimal {
  public Fox() {
    super("Fox", 4);
  }

  public void makeSound() {
    System.out.println("What does a fox say?");
  }
}