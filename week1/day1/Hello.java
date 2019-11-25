import java.util.ArrayList;

public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello Java World!");

    int integer = 10;
    Integer int2 = 10;

    System.out.println(integer == int2);

    double pi = 3.14;
    boolean bool = true;

    char c = 'c';

    String myString = "this is string";

    System.out.println(myString);

    // creating an array
    int[] ints = { 1, 2, 3, 4, 5, 56, 76 };
    Object[] strings = { "string1", "string2", 0 };

    System.out.println(ints);

    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }

    // [1, 2, 3, 4, 5];

    ArrayList<Integer> moreInts = new ArrayList<Integer>();

    moreInts.add(10);
    moreInts.add(18);
    moreInts.add(90);

    System.out.println(moreInts);

    for (Integer value : moreInts) {
      System.out.println(value);
    }

    for (int i = 0; i < moreInts.size(); i++) {
      System.out.println(moreInts.get(i));
    }

  }
}