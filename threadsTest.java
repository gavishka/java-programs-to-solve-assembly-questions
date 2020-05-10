/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package assemblytest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author gavis
 */
class myInt{
    private int num;
    
    public int getnum(){
        return num;
    }
    public void setnum(int num){
        this.num=num;
    }
}

public class threadsTest {
    public static void main(String[] args){
        myInt intobj1=new myInt();
        myInt intobj2=new myInt();
        int upper1=0;
        int upper2=0;
        
        Scanner var=new Scanner(System.in);
        System.out.println("Enter a number for summation: ");
        upper1=var.nextInt();
        
        System.out.println("Enter a number for Fibonacci: ");
        upper2=var.nextInt();
        
        Thread[] thrd=new Thread[2];
        
        thrd[0]=new Thread(new Summation(upper1,intobj1));
        thrd[1]=new Thread(new Fibonacci(upper2,intobj2));
        
        thrd[0].start();
        thrd[1].start();
        
        try{
            thrd[0].join();
            thrd[1].join();
            System.out.println("The sum of "+upper1+"is "+intobj1.getnum());
            System.out.println("The Fibonacci of "+upper2+"is "+intobj2.getnum());
        }
        catch(InterruptedException ie){
        
        }
    }
}

class Summation implements Runnable{
    private int upper;
    private myInt sumValue;
    
    public Summation(int upper,myInt sumValue){
        this.upper=upper;
        this.sumValue=sumValue;
    }
    public void run(){
        int sum=0;
        for(int i=0;i<=upper;i++)
            sum+=i;
        sumValue.setnum(sum);
    }
}

class Fibonacci implements Runnable{
    private int first=0;
    private int second=1;
    private myInt result;
    private int element;
    private int next=0;
    
    public Fibonacci(int e, myInt r){
        this.element=e;
        this.result=r;
    }
    public void run(){
        for(int i=0;i<element;i++){
            if(i<=1)
                next=i;
            else{
                next=first+second;
                first=second;
                second=next;
            }
        }
        result.setnum(next);
    }
}
