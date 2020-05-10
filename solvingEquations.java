/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblytest;

import java.util.Scanner;

/**
 *
 * @author gavis
 */
public class ass3ques1 {
    static String msg1="Enter a number for P:";
    static String msg2="Enter a number for Q:";
    static String msg3="Enter a number for R:";
    static String msg4="Enter a number for S:";
    static String msg5="Enter a number for T:";
    
    static int P,Q,R,S,T;
    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print(msg1);
        P=in.nextInt();
        System.out.print(msg2);
        Q=in.nextInt();
        System.out.print(msg3);
        R=in.nextInt();
        System.out.print(msg4);
        S=in.nextInt();
        System.out.print(msg5);
        T=in.nextInt();
        
        System.out.print("(2P+R)-(Q-S)-3T = ");
        System.out.println((2*P+R)-(Q-S)-(3*T));
        
        System.out.print("(2P+4R)-(S+Q)+2T = ");
        System.out.println((2*P+4*R)-(S+Q)+(2*T));
        
        System.out.print("8*R-(S+Q)-(3T+P) = ");
        System.out.print((8*R)-(S+Q)-(3*T+P));
        
    }
    
}
