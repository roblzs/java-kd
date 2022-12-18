import java.util.Scanner;

class pirmais {

  public static void oneCount(int number) {
    String numberAsString = String.valueOf(number);

    int wordWithoutOnes = numberAsString.replace("1", "").length();
    int wordWithOnes = numberAsString.length();

    int difference = wordWithOnes - wordWithoutOnes;

    System.out.println("Kopa " + difference + " vieninieki skaitli" + number);
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Ievadi naturalu skaitli: ");

    int number = -1;

    try {
      number = input.nextInt();

      if (number <= 0) {
        input.close();
        throw new Error("Ievadi naturalu skaitli");
      }
    } catch (Exception ex) {
      input.close();
      throw new Error("Ievadi naturalu skaitli");
    }

    input.close();

    oneCount(number);
  }
}
