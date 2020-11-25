package strings;

import sun.rmi.runtime.Log;

public class StringToNumber {
    public static void main(String[] args) {

        StringToNumber stringToNumber = new StringToNumber();

        int first = stringToNumber.convertStringToNumber("123");
        int second = stringToNumber.convertStringToNumber("-123");
        int third = stringToNumber.convertStringToNumber("+123");

        System.out.println("Finished converting string to number");
    }
    /*
        * Having a string representation of a number ("123") return the value as an int
        * If the string is signed ("+123" or "-123") the returned int should respond accordingly
     */
    public int convertStringToNumber(String s){
     if (s.charAt(0) == '+'){
         return sumOfChars(s.substring(1));
     }

     if (s.charAt(0) == '-'){
         return sumOfChars(s.substring(1)) * (-1);
     }

     return sumOfChars(s);
    }

    private int sumOfChars(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++){
            int newValue = string.charAt(i) - '0';
            int coefficient = string.length() - 1 - i;
            int multiplier =(int) Math.pow(10,coefficient);
            sum += newValue*multiplier;
        }

        return sum;
    }
}
