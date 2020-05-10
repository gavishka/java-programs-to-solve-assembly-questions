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
public class fibonacci {
    static int num1=1;
    static int num2=1;
    static int num3;
    public static void main(String[] args) {
        System.out.print(num1+","+num2);
        
        for(int i=2;i<30;i++){
            num3=num1+num2;
            System.out.print(","+num3);
            num1=num2;
            num2=num3;
        }
    }
}
