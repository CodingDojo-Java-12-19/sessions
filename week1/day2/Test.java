public class Test {
  public static void main(String[] args) {
    Horse horse = new Horse();
    Cat cat = new Cat();
    Fox fox = new Fox();
    Human human = new Human();

    // horse.numberOfLegs = 9;
    horse.setNumberOfLegs(-1);

    System.out.println(cat.getType());

    cat.run();
    // horse.run();

    // cat.makeSound();
    // horse.makeSound();

    Trainer.train(cat);
    Trainer.train(horse);
    Trainer.train(fox);
    Trainer.train(human);
    System.out.println(horse.getNumberOfLegs());
  }
}