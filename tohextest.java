/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblytest;

/**
 *
 * @author gavis
 */
public class tohextest {
    public static void main(String[] args) {

      int i = 100;
      System.out.println("Number = " + i);

      /* returns the string representation of the unsigned integer value
         represented by the argument in hexadecimal (base 16) */
      System.out.println("Hex = " + Integer.toHexString(i));
   }  
}
