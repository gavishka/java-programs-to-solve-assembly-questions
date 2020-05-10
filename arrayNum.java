/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblytest;
import java.lang.*;
/**
 *
 * @author gavis
 */
public class arrayNum {
    static int sum=0;
    static int myarray[]={566,276,100,400,500,600};
    static int num1=myarray[0];
    public static void main(String[] args) {
        System.out.print(num1);
        for(int i=1;i<myarray.length;i++){
            System.out.print(","+myarray[i]);
            sum=sum+myarray[i];
        }
        
        System.out.print("\n");
        String num1s=Integer.toHexString(num1);
        System.out.print(num1s);
        for(int i=1;i<myarray.length;i++){
            String tempvar=Integer.toHexString(myarray[i]);
            System.out.print(","+tempvar);
        }
        
        sum=sum+myarray[0];
        System.out.print("\n");
        System.out.print("Summation of the values in the array is: "+sum);
    }
    
}
