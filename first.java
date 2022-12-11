import java.util.Scanner;

public class first {

  public static Scanner in = new Scanner(System.in);

  public static int input() {
    try {
      int inp = in.nextInt();

      if (inp <= 0) {
        throw new Error("Enter a natural number");
      }

      return inp;
    } catch (Exception ex) {
      throw new Error("Enter a natural number");
    }
  }

  public static int countOnes(int num) {
    String strNum = String.valueOf(num);

    int wo1 = strNum.replace("1", "").length();
    int w1 = strNum.length();

    return w1 - wo1;
  }

  public static void main(String[] args) {
    System.out.print("Enter a natural number: ");

    int num = input();

    int oneCount = countOnes(num);

    System.out.println("There are " + oneCount + " 1 in " + num);
  }
}
