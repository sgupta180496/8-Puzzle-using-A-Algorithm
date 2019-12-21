
import java.util.Scanner;

//Main class for choosing a Heuristic function
public class ChooseAHeuristic{



    public static void main(String args[])
    {


        System.out.println("Choose a Heuristic: \n 1. Misplaced Tiles \n 2. Manhattan Distance");
        Scanner scan= new Scanner(System.in);
        int i=scan.nextInt();

        int initialBoard[]= new int[9];
        int finalBoard[]=new int[9];
        System.out.println("Enter the 8 puzzle problem: \n");

        for(int j=0; j<9; j++)
        {
            initialBoard[j]=scan.nextInt();
        }
        System.out.println("Enter the final board: \n");

        for(int j=0; j<9; j++)
        {
            finalBoard[j]=scan.nextInt();
        }


        pass(initialBoard, finalBoard, i);


    }


    //i= choice of heuristic

    public static void pass(int initialBoard[], int finalBoard[], int i){


        if(i==1)
        {
            AStarSearch.search(initialBoard, finalBoard, 1);

        }
        else if(i==2)
        {
            AStarSearch.search(initialBoard, finalBoard, 2);

        }

        else
        {
            System.out.println("Wrong input!");

        }

    }


}