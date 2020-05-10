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
public class AssemblyTest {

    /**
     * @param args the command line arguments
     */
        static int x=-1;
        static int n=5;
        static int j;
        static int y;
    public static void main(String[] args) {
        // TODO code application logic here
        
        for(int i=n;i>0;i--){
            y=i;
            for(int t=y;t>0;t--){
            System.out.print(" ");
            }
            x++;
            j=2*x+1;
            
            for(int k=0;k<j;k++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    
}
