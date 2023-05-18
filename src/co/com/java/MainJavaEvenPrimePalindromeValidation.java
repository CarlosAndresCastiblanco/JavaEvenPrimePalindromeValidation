/**
 * 
 */
package co.com.java;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;
/**
 * @author carlos.castiblanco
 *
 */
public class MainJavaEvenPrimePalindromeValidation {

	/**
	 * @param args
	 */
    private static final String EVEN = "EVEN";
    private static final String PRIME = "PRIME";
    private static final String PALINDROME = "PALINDROME";
    private static final String NO_PALINDROME = "NOT PALINDROME";
    private static final String ODD = "ODD";
    private static final String COMPOSITE = "COMPOSITE";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        while(scanner.hasNext()) {
            String in = scanner.nextLine();
            String[] numbers = in.split(SPACE);
            switch(Integer.valueOf(numbers[0])) {
                case 1:
                    isOdd(Integer.valueOf(numbers[1]));
                    break;
                case 2:
                    isPrime(Integer.valueOf(numbers[1]));
                    break;
                case 3:
                    isPalindrome(numbers[1]);
                    break;
            }
        }
    }
    
    public static void isOdd(int arg){
        if(arg % 2 == 0)
            print(EVEN);
        else
            print(ODD);
    }
    
    public static void isPrime(int arg){
        boolean flag = Stream
        					.iterate(2, a -> a <= arg / 2, a -> ++a)
        					.anyMatch(i -> arg % i == 0);
        if (!flag)
            print(PRIME);
        else
            print(COMPOSITE);
    }
    
    public static void isPalindrome(String arg){
        String reverse = new StringBuilder(arg)
        									.reverse()
        									.toString();
        if (arg.equals(reverse))
           print(PALINDROME);
        else
           print(NO_PALINDROME);
    }

    public static void print(String val){
        System.out.println(val);
    }
}
