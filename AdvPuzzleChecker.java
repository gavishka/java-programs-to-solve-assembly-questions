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
public class AdvPuzzleChecker {
    public static final char[][] puzzle={
                        { 'A','E','F',1,9,2,'D',8,'B','G',6,'C',5,3,7,4 },
		{ 3,7,'G',2,1,'E','A',6,'F',9,5,4,8,'D','C','B'},
		{ 'B',9,8,5,4,'C','F',7,'D',3,1,'E',6,'A','G',2 },
		{ 'D',4,6,'C',3,'B',5,'G',8,'A',7,2,'F','E',1,9 },
		{ 5,'D','A',8,'B','G','E',4,'C',6,9,1,7,'F',2,3},
		{ 2,6,9,3,'A',7,'C',1,5,'F',4,'G','D',8,'B','E'},
		{ 1,'C',7,'E',2,'F',9,5,3,'D','B',8,'A',6,4,'G'},
		{ 4,'G','B','F',8,6,3,'D',7,'E',2,'A','C',9,5,1 },
		{ 'C','A',1,4,'F',5,8,'E',2,'B','G',9,3,7,6,'D' },
	{ 'F','B',5,'G','D',3,7,2,'E','C',8,6,4,1,9,'A' },
	{ 8,3,'E',7,'G',1,6,9,'A',4,'D',5,'B',2,'F','C' },
	{ 9,2,'D',6,'C',4,'B','A',1,7,'F',3,'E','G',8,5 },
	{ 'E',1,4,'A',5,'D',2,'F','G',8,'C',7,9,'B',3,6 },
	{ 7,'F',2,'D',6,'A','G','C',9,5,3,'B',1,4,'E',8 },
	{ 6,8,'C','B','E',9,1,3,4,2,'A','F','G',5,'D',7 },
	{ 'G',5,3,9,7,8,4,'B',6,1,'E','D',2,'C','A','F'}

    };
    private static int row_status=0;
    private static int col_status=0;
    private static int[] squareStatus=new int[17];
    
    
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
            
            for(int i=beginRow;i<16;i++){
                int[] checkingArray=new int[17];
                
                for(int j=beginCol;j<16;j++){
                    int value=0;
                    boolean isitChar=Character.isAlphabetic(puzzle[i][j]);
                    if(isitChar){
                        char valChar=puzzle[i][j];
                        
                        if(valChar=='A'){
                            value=10;
                        }else if(valChar=='B'){
                            value=11;
                        }else if(valChar=='c'){
                            value=12;
                        }else if(valChar=='D'){
                            value=13;
                        }else if(valChar=='E'){
                            value=14;
                        }else if(valChar=='F'){
                            value=15;
                        }else if(valChar=='G'){
                            value=16;
                        }
                    }else{
                        value=puzzle[i][j];
                    }
                    if(checkingArray[value]!=0){
                        row_status=0;
                        return;
                    }else{
                        checkingArray[value]=1;
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
            
            for(int i=beginCol;i<16;i++){
                int[] checkingArray=new int[17];
                
                for(int j=beginRow;j<16;j++){
                    int value=0;
                    boolean isitChar=Character.isAlphabetic(puzzle[i][j]);
                    if(isitChar){
                        char valChar=puzzle[i][j];
                        
                        if(valChar=='A'){
                            value=10;
                        }else if(valChar=='B'){
                            value=11;
                        }else if(valChar=='c'){
                            value=12;
                        }else if(valChar=='D'){
                            value=13;
                        }else if(valChar=='E'){
                            value=14;
                        }else if(valChar=='F'){
                            value=15;
                        }else if(valChar=='G'){
                            value=16;
                        }
                    }else{
                        value=puzzle[i][j];
                    }
                    
                    if(checkingArray[value]!=0){
                        col_status=0;
                        return;
                    }else{
                        checkingArray[value]=1;
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
            int[] checkingArray=new int[17];
            
            for(int i=beginRow;i<beginRow+4;i++){
                for(int j=beginCol;j<beginCol+4;j++){
                    int value=0;
                    boolean isitChar=Character.isAlphabetic(puzzle[i][j]);
                    if(isitChar){
                        char valChar=puzzle[i][j];
                        
                        if(valChar=='A'){
                            value=10;
                        }else if(valChar=='B'){
                            value=11;
                        }else if(valChar=='c'){
                            value=12;
                        }else if(valChar=='D'){
                            value=13;
                        }else if(valChar=='E'){
                            value=14;
                        }else if(valChar=='F'){
                            value=15;
                        }else if(valChar=='G'){
                            value=16;
                        }
                    }else{
                        value=puzzle[i][j];
                    }
                    if(checkingArray[value]!=0){
                        squareStatus[(i+1)+(j/4)]=0;
                        return;
                    }
                    else{
                        checkingArray[value]=1;
                        
                    }
                }
            }
            squareStatus[(beginRow+1)+(beginCol/4)]=1; 
        }
    }
    
    public static void main(String[] args){
        //parameters for checking all rows and cols
        Board board0=new Board(0,0);
        board0.setRow(0);
        board0.setCol(0);
        
        Board board1=new Board(0,0); //first 4x4
        board1.setRow(0);
        board1.setCol(0);
        
        Board board2=new Board(0,4); //second 4x4
        board2.setRow(0);
        board2.setCol(4);
        
        Board board3=new Board(0,8); //third 4x4
        board3.setRow(0);
        board3.setCol(8);
        
        Board board4=new Board(0,12); //fouth 4x4
        board4.setRow(0);
        board4.setCol(12);
        
        Board board5=new Board(4,0); //fifth 4x4
        board5.setRow(4);
        board5.setCol(0);
        
        Board board6=new Board(4,4); //sixth 4x4
        board6.setRow(4);
        board6.setCol(4);
        
        Board board7=new Board(4,8); //seventh 4x4
        board7.setRow(4);
        board7.setCol(8);
        
        Board board8=new Board(4,12); //Eighth 4x4
        board8.setRow(4);
        board8.setCol(12);
        
        Board board9=new Board(8,0); //Ninth 4x4
        board9.setRow(8);
        board9.setCol(0);
        
        Board board10=new Board(8,4); //Tenth 4x4
        board10.setRow(8);
        board10.setCol(4);
        
        Board board11=new Board(8,8); //Eleventh 4x4
        board11.setRow(8);
        board11.setCol(8);
        
        Board board12=new Board(8,12); //Twelwth 4x4
        board12.setRow(8);
        board12.setCol(12);
        
        Board board13=new Board(12,0); //Thirteenth 4x4
        board13.setRow(12);
        board13.setCol(0);
        
        Board board14=new Board(12,4); //Fourteenth 4x4
        board14.setRow(12);
        board14.setCol(4);
        
        Board board15=new Board(12,8); //Fifteenth 4x4
        board15.setRow(12);
        board15.setCol(8);
        
        Board board16=new Board(12,12); //Sixteenth 4x4
        board16.setRow(12);
        board16.setCol(12);
        
        Thread[] thrds=new Thread[18];
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
        thrds[11]=new Thread(new check_squares(board10));
        thrds[12]=new Thread(new check_squares(board11));
        thrds[13]=new Thread(new check_squares(board12));
        thrds[14]=new Thread(new check_squares(board13));
        thrds[15]=new Thread(new check_squares(board14));
        thrds[16]=new Thread(new check_squares(board15));
        thrds[17]=new Thread(new check_squares(board16));
        
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
             System.out.println("Square "+i+" status: "+squareStatus[i]);
         }
        
       for(int i=1;i<squareStatus.length;i++){
           if(squareStatus[i]!=1 && row_status!=1 && col_status!=1){
               System.out.println(" \nThe puzzle solution is wrong.\n");
               
               return;
           }
       }
       System.out.println("\nThe puzzle solution is Correct!\n");
       
      
    }
}
