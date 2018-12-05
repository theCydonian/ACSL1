import java.math.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Acsl {

  /***
   * Returns the BigInteger representation of the sum of all non-overlapping n-long substrings of number once converted to StringBuilder.
   * @param number number that is divided into n-long pieces
   * @param n length of substring
   * @return the BigInteger representation of the sum of all non-overlapping n-long substrings of number once converted to StringBuilder.
   */
  public static BigInteger process (StringBuilder number, int n) {
    while (number.length()%n != 0) {
      number = number.append('0');
    }
    ArrayList<String> toSum = new ArrayList<String>();
    int i = 1;
    while (i*n <= number.length()) {
      String num = number.substring((i-1)*n, i*n);
      toSum.add(num);
      i++;
    }
    
    BigInteger result = new BigInteger("0");
    
    for (String str : toSum) {
      result = result.add(new BigInteger(str));
    }
    return result;
  }
  
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scan = new Scanner(new FileReader(args[0]));
    
    ArrayList<StringBuilder> numberList = new ArrayList<StringBuilder>();
    ArrayList<Integer> nList = new ArrayList<Integer>();
    
    while (scan.hasNextLine()) {
      String[] line = scan.nextLine().split(" ");
      StringBuilder number = new StringBuilder(line[0]);
      int n = new Integer(line[1]);
      numberList.add(number);
      nList.add(n);
    }
    scan.close();
    
    int i = 0;
    for (StringBuilder number : numberList) {
      System.out.println(i+1 + ". " + process(number, nList.get(i)));
      i++;
    }
  }

}
