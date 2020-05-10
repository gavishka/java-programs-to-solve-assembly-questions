/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblytest;

import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 *
 * @author gavis
 */
public class PuzzleChecker {
    public static final int[][] puzzle={
                        {6, 2, 4, 5, 3, 9, 1, 8, 7},
			{5, 1, 9, 7, 2, 8, 6, 3, 4},
			{8, 3, 7, 6, 1, 4, 2, 9, 5},
			{1, 4, 3, 8, 6, 5, 7, 2, 9},
			{9, 5, 8, 2, 4, 7, 3, 6, 1},
			{7, 6, 2, 3, 9, 1, 4, 5, 8},
			{3, 7, 1, 9, 5, 6, 8, 4, 2},
			{4, 9, 6, 1, 8, 2, 5, 7, 3},
			{2, 8, 5, 4, 7, 3, 9, 1, 6}
    };
    private static int row_status=0;
    private static int col_status=0;
    private static int[] squareStatus=new int[10];
    
    
    public static class Board{
        int row;
        int col;
        
        Board(int row,int column){
            this.row=row;
            this.col=column;
        }
        
        public int getRow(){
            return row;
        }
        public int getCol(){
            return col;
        }
        public void setRow(int row){
            this.row=row;
        }
        public void setCol(int col){
            this.col=col;
        }
    }
    
    public static class check_row implements Runnable{
        private int beginRow;
        private int beginCol;
        private Board board;
        
        public check_row(Board boardobj){
            this.board=boardobj;
        }
        
        public void run(){
            beginRow=board.getRow();
            beginCol=board.getCol();
            
            for(int i=beginRow;i<9;i++){
                int[] checkingArray=new int[10];
                
                for(int j=beginCol;j<9;j++){
                    int val=puzzle[i][j];
                    if(checkingArray[val]!=0){
                        row_status=0;
                        return;
                    }else{
                        checkingArray[val]=1;
                    }
                }
            }
            row_status=1;
        }
    }
    
    public static class check_col implements Runnable{
        private int beginRow;
        private int beginCol;
        private Board board;
        
        public check_col(Board boardobj){
            this.board=boardobj;
        }
        
        public void run(){
            beginRow=board.getRow();
            beginCol=board.getCol();
            
            for(int i=beginCol;i<9;i++){
                int[] checkingArray=new int[10];
                
                for(int j=beginRow;j<9;j++){
                    int val=puzzle[i][j];
                    if(checkingArray[val]!=0){
                        col_status=0;
                        return;
                    }else{
                        checkingArray[val]=1;
                    }
                }
            }
            col_status=1;
        }
    }
    
    public static class check_squares implements Runnable{
       private int beginRow;
        private int beginCol;
        private Board board;
        
        public check_squares(Board boardobj){
            this.board=boardobj;
        }
        
        public void run(){
            beginRow=board.getRow();
            beginCol=board.getCol();
            int[] checkingArray=new int[10];
            
            for(int i=beginRow;i<beginRow+3;i++){
                for(int j=beginCol;j<beginCol+3;j++){
                    int val=puzzle[i][j];
                    if(checkingArray[val]!=0){
                        squareStatus[(i+1)+(j/3)]=0;
                        return;
                    }
                    else{
                        checkingArray[val]=1;
                        
                    }
                }
            }
            squareStatus[(beginRow+1)+(beginCol/3)]=1; 
        }
    }
    
    public static void main(String[] args){
        Board board0=new Board(0,0);
        board0.setRow(0);
        board0.setCol(0);
        
        Board board1=new Board(0,0);
        board1.setRow(0);
        board1.setCol(0);
        
        Board board2=new Board(0,3);
        board2.setRow(0);
        board2.setCol(3);
        
        Board board3=new Board(0,6);
        board3.setRow(0);
        board3.setCol(6);
        
        Board board4=new Board(3,0);
        board4.setRow(3);
        board4.setCol(0);
        
        Board board5=new Board(3,3);
        board5.setRow(3);
        board5.setCol(3);
        
        Board board6=new Board(3,6);
        board6.setRow(3);
        board6.setCol(6);
        
        Board board7=new Board(6,0);
        board7.setRow(6);
        board7.setCol(0);
        
        Board board8=new Board(6,3);
        board8.setRow(6);
        board8.setCol(3);
        
        Board board9=new Board(6,6);
        board9.setRow(6);
        board9.setCol(6);
        
        Thread[] thrds=new Thread[11];
        thrds[0]=new Thread(new check_row(board0));
        thrds[1]=new Thread(new check_col(board0));
        thrds[2]=new Thread(new check_squares(board1));
        thrds[3]=new Thread(new check_squares(board2));
        thrds[4]=new Thread(new check_squares(board3));
        thrds[5]=new Thread(new check_squares(board4));
        thrds[6]=new Thread(new check_squares(board5));
        thrds[7]=new Thread(new check_squares(board6));
        thrds[8]=new Thread(new check_squares(board7));
        thrds[9]=new Thread(new check_squares(board8));
        thrds[10]=new Thread(new check_squares(board9));
        
        for(int i=0;i<thrds.length;i++){
            thrds[i].start();
        }
        
        for(int i=0;i<thrds.length;i++){
            try {
		thrds[i].join();
            } catch (InterruptedException e) {
		e.printStackTrace();
		}
        }
        
         for(int i=1;i<squareStatus.length;i++){
             System.out.println(squareStatus[i]);
         }
        
       for(int i=1;i<squareStatus.length;i++){
           if(squareStatus[i]!=1 && row_status!=1 && col_status!=1){
               System.out.println(" The puzzle solution is wrong.");
               
               return;
           }
       }
       System.out.println("The puzzle solution is Correct!");
      
    }
    
}
