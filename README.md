# Kontroldarbs Nr.1. 

## Funkcijas. Masīvi. Simbolu virknes

1.  Uzrakstīt Java programmu, kas ļauj lietotājam ievadīt naturālu skaitli un izrēķina cik vieninieki ir šī skaitļa pierakstā. Skaitļa viennieku skaita aprēķināšanai jāizveido funkcija. Pielietojiet operatoru try iznēmumsituācijas apstrādei

```java
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

    return strNum.split("1").length - 1;
  }

  public static void main(String[] args) {
    System.out.print("Enter a natural number: ");

    int num = input();

    int oneCount = countOnes(num);

    System.out.println("There are " + oneCount + " 1 in " + num);
  }
}
```

2. Uzrakstīt  Java  programmu,  kas  paredzēta  divu  dimensiju  masīva  apstrādei.  Masīvu  aizpildīt  ar nejaušiem veseliem skaitļiem diapazonā -20...20. Kolonnu  un  rindu  skaitu  ievada lietotājs. Masīvu nodod  funkcijai, kas paredzēta masīva apstrādei.  Ar  funkciju  visus  divu  dimensiju masīva negatīvus elementus  saglabāt  viendimensījas  masīvā   un  sakārtot  viendimensijas  masīva  elementus  dilstošā secībā un izvadīt tos uz ekrānu.

```java
import java.util.Random;
import java.util.Scanner;

public class second {

  public static Scanner in = new Scanner(System.in);

  public static int rand(int min, int max) {
    Random random = new Random();

    return random.nextInt(max - min) + min;
  }

  public static int input() {
    try {
      int inp = in.nextInt();

      if (inp <= 0) {
        throw new Error("Input must be greater than 0");
      }

      return inp;
    } catch (Exception ex) {
      throw new Error("Input must be a number");
    }
  }

  public static int[][] gen_arr(int cols, int rows) {
    int[][] arr = new int[rows][cols];

    for (int i = 0; i < arr.length; i++) {
      int[] row = new int[rows];

      for (int j = 0; j < row.length; j++) {
        row[j] = rand(-20, 20);
      }

      arr[i] = row;
    }

    return arr;
  }

  public static void print_arr(int[] arr) {
    String prnt = "";

    for (int i = 0; i < arr.length; i++) {
      prnt += arr[i];
      prnt += ", ";
    }

    System.out.println(prnt);
  }

  public static int[] get_negative(int[][] arr) {
    int negative_count = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] < 0) {
          negative_count++;
        }
      }
    }

    int[] negative = new int[negative_count];

    int counter = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] < 0) {
          negative[counter] = arr[i][j];
          counter++;
        }
      }
    }

    return negative;
  }

  public static int[] select_sort(int[] arr) {
    int indexor = 0;

    while (indexor < arr.length) {
      int smallest_el = arr[indexor], smallest_index = indexor;
      int idx_el = arr[indexor];

      for (int i = indexor; i < arr.length; i++) {
        int el = arr[i];

        if (el < smallest_el) {
          smallest_el = el;
          smallest_index = i;
        }
      }

      arr[indexor] = smallest_el;
      arr[smallest_index] = idx_el;

      indexor++;
    }

    return arr;
  }

  public static void main(String[] args) {
    System.out.print("Enter column count: ");
    int cols = input();

    System.out.print("Enter row count: ");
    int rows = input();

    int[][] arr = gen_arr(cols, rows);

    int[] negative = get_negative(arr);

    int[] sorted = select_sort(negative);

    System.out.print("Sorted array: ");
    print_arr(sorted);
  }
}
```

3. Uzrakstīt Java  programmu, kas paredzēta simbolu virkņu apstrādei. Sākumdatus ievada lietotājs. Tekstu nodod funkcijai, kas noteic vai teksts sākās ar vārdu "Latvija". Ar izveidotu funkcij show(str) izprintēt visus teikuma vārdus

```java
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
```