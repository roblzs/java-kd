import java.util.Scanner;

public class third {

  public static Scanner in = new Scanner(System.in);

  public static boolean check_start(String txt) {
    String first_word = txt.split(" ")[0].replace(" ", "");

    if (first_word.toLowerCase().equals("latvija")) {
      return true;
    }

    return false;
  }

  public static void show(String txt) {
    String[] words = txt.split(" ");

    System.out.println("Words: ");
    for (int i = 0; i < words.length; i++) {
      System.out.println(words[i].replace(" ", ""));
    }
  }

  public static void main(String[] args) {
    System.out.println("Enter text...");
    String text = in.nextLine();

    boolean starts_with_lv = check_start(text);

    if (starts_with_lv) {
      System.out.println("Text starts with 'Latvija'");
    }

    show(text);
  }
}
