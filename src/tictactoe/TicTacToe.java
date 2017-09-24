/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author KriLak
 */
class Game{
    static int g=-1;   
}

public class TicTacToe extends Game {

    /**
     * @param args the command line arguments
     */
    
    //INITIALIZE THE BOARD
    static void initializeBoard(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j] = '-';
            }
        }
    }
    
    //DISPLAY BOARD
    static void displayBoard(char[][] board)
    {
        System.out.println("Board: ");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    //CHANGE USER
    static void changeUser(char[][] board, boolean userA)
    {
        while(true)
        {
            if(userA)
            {
                if(winnerGame(board,true))
                {
                    break;
                }
                else if(winnerGame(board,false))
                {
                    break;
                }
                else
                    enterValue(board,'X','A');
            }
            else
            {
                if(winnerGame(board,false))
                {
                    break;
                }
                else if(winnerGame(board,true))
                {
                    break;
                }
                else
                    enterValue(board,'O','B');
            }
        }
    }
    
    
    //ROW WIN
    static boolean rowWin(char[][] board, boolean userA)
    {
        int row=0;
        boolean isRow = false;
        if(userA)
        {
            while(row<3)
            {
                if(board[row][0]=='X'&&board[row][1]=='X'&&board[row][2]=='X')
                {
                    isRow = true;
                    break;
                }
                else
                {
                    row++;
                }
            }
        }
        else
        {
            while(row<3)
            {
                if(board[row][0]=='O'&&board[row][1]=='O'&&board[row][2]=='O')
                {
                    isRow = true;
                    break;
                }
                else
                {
                    row++;
                }
            }
        }
        return isRow;
    }
    
    
    //COLUMN WIN
    static boolean colWin(char[][] board, boolean userA)
    {
        int col=0;
        boolean isCol = false;
        if(userA)
        {
            while(col<3)
            {
                if(board[0][col]=='X'&&board[1][col]=='X'&&board[2][col]=='X')
                {
                    isCol = true;
                    break;
                }
                else
                {
                    col++;
                }
            }
        }
        else
        {
            while(col<3)
            {
                if(board[0][col]=='O'&&board[1][col]=='O'&&board[2][col]=='O')
                {
                    isCol = true;
                    break;
                }
                else
                {
                    col++;
                }
            }
        }
        return isCol;
    }
    
    
    static boolean diagWin(char[][] board, boolean userA)
    {
        if(userA)
        {
            if((board[0][0]=='X'&&board[1][1]=='X'&&board[2][2]=='X')||
                    (board[0][2]=='X'&&board[1][1]=='X'&&board[2][0]=='X'))
                return true;
            else
                return false;
        }
        else
        {
            if((board[0][0]=='O'&&board[1][1]=='O'&&board[2][2]=='O')||
                    (board[0][2]=='O'&&board[1][1]=='O'&&board[2][0]=='O'))
                return true;
            else
                return false;
        }
    }
    
    //WINNER OF GAME
    static boolean winnerGame(char[][] board, boolean userA)
    {
        if(rowWin(board,userA)||colWin(board,userA)||diagWin(board,userA))
        {
            if(userA)
            {
                Game.g=1;
                return true;
            }
            else
            {
                Game.g=2;
                return true;
            }
        }
        return false;
    }
    
    
    //ENTER VALUE INTO THE BOARD
    static void enterValue(char[][] board,char val,char user)
    {
        //displayBoard(board);
        Scanner scan = new Scanner(System.in);
        System.out.println("User "+ user + " enter values");
        System.out.println("Enter row:0-2 ");
        int row = scan.nextInt();
        if(row<0||row>2)
        {
            System.out.println("enter row values between 0 and 2 only.");
            enterValue(board,val,user);
        }
        System.out.println("Enter col:0-2 ");
        int col = scan.nextInt();
        if(col<0||col>2)
        {
            System.out.println("enter column values between 0 and 2 only.");
            enterValue(board,val,user);
        }
        if(user=='A')
        {
            if(board[row][col]!='X'&&board[row][col]!='O')
                board[row][col] = val;
            else
            {
                System.out.println("can't override the existing value. Please enter again");
                changeUser(board,true);
            }
            displayBoard(board);
            changeUser(board,false);
        }
        else
        {
            if(board[row][col]!='X'&&board[row][col]!='O')
                board[row][col] = val;
            else
            {
                System.out.println("can't override the existing value. Please enter again");
                changeUser(board,false);
            }
            displayBoard(board);
            changeUser(board,true);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        char[][] board = new char[3][3];
        initializeBoard(board);
        displayBoard(board);
        
        changeUser(board,true);
        
        if(Game.g==1)
        {
            System.out.println("user A wins");
        }
        else if(Game.g==2)
        {
            System.out.println("user B wins");
        }
        else
        {
            System.out.println("Both the users lost the game");
        }
    }
    
}
