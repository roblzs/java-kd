import java.util.Arrays;
import java.util.Collections;
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
