import java.util.*;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char [][] board = {{'_' , '_' , '_'},
                               {'_' , '_' , '_'},
                               {'_' , '_' , '_'}};

            


            
          

            printBoard(board);

         
              for(int i=0; i<9; i++){
                if(i%2==0){
                  System.out.println("X's turn");
                  int [] spot = askUser(board);
                  board[spot[0]][spot[1]] = 'X';
                }
                else{
                  System.out.println("O's turn");
                  int [] spot = askUser(board);
                  board[spot[0]][spot[1]] = 'O';
                }
                printBoard(board);
                
                
                if(checkWin(board) == 3){
                  System.out.println("X wins!");
                  break;
                }
                else if(checkWin(board) == -3){
                  System.out.println("O wins!");
                  break;
                }
                else if (i == 8) {
                  System.out.println("It's a tie!");
                }
              }
                
              }

              
            
              

         
                  }

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
            
         
        

        public static void printBoard(char[][] brd){
          System.out.print("\n");
          for(int i=0; i<brd.length; i++){
            System.out.print("\t");
            for(int j=0; j<brd[i].length; j++){
              
              System.out.print(brd[i][j] + " ");
            }
            System.out.print("\n\n");
          }
        }
  
    
     
     
    public static int[] askUser(char[][] board){
      System.out.print(" - Pick a row and column number: ");
      int row = scan.nextInt();
      int column = scan.nextInt();
      
      while(board[row][column] != '_'){
        System.out.println("Spot already taken, pick another spot");
         row = scan.nextInt();
         column = scan.nextInt();
      } 
      return new int[] {row,column};
    }
  
  
  

  
       
        
      
    public static int checkWin(char [][] board){
      int count = 0;
      for(int i=0; i<board.length; i++){
        for(int j=0; j<board[i].length; j++){
            if(board[i][j] == 'X'){
              count++;

            }
            else if(board[i][j] == 'O'){
              count--;
            }
        }
        
        if(count == 3 || count == -3){
          return count;
        }
        else{
          count = 0;
        }
      }

      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            if(board[j][i] == 'X'){
              count++;

            }
            else if(board[j][i] == 'O'){
              count--;
            }
        }
        
        if(count == 3 || count == -3){
          return count;
        }
        else{
          count = 0;
        }
      }

      for(int i=0; i<3; i++){
        if(board[i][i] == 'X'){
          count++;

        }
        else if(board[i][i] == 'O'){
          count--;
        }

        

      }
      
      if (count == 3 || count == -3) {
        return count;
        } 
        else {
        count = 0;
    }
    for (int i = 0; i < 3; i++) {
      if (board[i][2-i] == 'X') {
          count++; //count each X as +1
      } else if (board[i][2-i] == 'O') { 
          count--; //count each O as -1. 
      }
  }

     
       
      return count;

    }
    

   

  }

