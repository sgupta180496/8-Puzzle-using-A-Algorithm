import java.util.ArrayList;

import java.util.Arrays;



public class Puzzle implements State
{

     int totalTiles = 0;

     int mDist = 0;

     int[] goalBoard;

     int[] cBoard;


    public Puzzle(int[] board, int[] finalBoard)
    {
        cBoard = board;
        goalBoard=finalBoard;
        totalTiles();
        manhattanDist();
    }



    private void totalTiles()
    {
        for (int i = 0; i < cBoard.length; i++)
        {
            if (goalBoard[i] != cBoard[i])
            {
                totalTiles++;
            }
        }
    }


    @Override
    public boolean isGoal()
    {
        if (Arrays.equals(cBoard, goalBoard))
        {
            return true;
        }
        return false;
    }


     int manhattanDist()
    {
        int index = -1;
        for (int j = 0; j < 3; j++)
        {
            for (int k = 0; k < 3; k++)
            {
                index++;

                int value = (cBoard[index] - 1);

                if (value != -1)
                {

                    int vert = value / 3;

                    int horiz = value % 3;


                    mDist += Math.abs(vert - (j)) + Math.abs(horiz - (k));
                }
            }
        }
        return  mDist;
    }


 int getZero()
    {
      int zeroIndex=0;

        for (int i = 0; i < 9; i++)
        {
            if (cBoard[i] == 0)
                zeroIndex = i;
        }
        return zeroIndex;
    }


    public int getOutOfPlace()
    {
        return totalTiles;
    }

    public int[] getCurrentBoard()
    {
        return cBoard;
    }



    /*
     * Makes a copy of the array passed to it
     */
    public int[] copyBoard(int[] state)
    {
        int[] ret = new int[9];
        for (int i = 0; i < 9; i++)
        {
            ret[i] = state[i];
        }
        return ret;
    }


    @Override
    public void printState()
    {
        System.out.println(cBoard[0] + " | " + cBoard[1] + " | "
                + cBoard[2]);
        System.out.println("---------");
        System.out.println(cBoard[3] + " | " + cBoard[4] + " | "
                + cBoard[5]);
        System.out.println("---------");
        System.out.println(cBoard[6] + " | " + cBoard[7] + " | "
                + cBoard[8]);

    }


    public ArrayList<State> generateSuc()
    {
        ArrayList<State> successors = new ArrayList<>();
        int zero = getZero();

        //left
        if (zero != 0 && zero != 3 && zero != 6)
        {


            int[] copyNew = copyBoard(cBoard);
            int temp = copyNew[zero-1];
            copyNew[zero-1] = cBoard[zero];
            copyNew[zero] = temp;
            successors.add((new Puzzle(copyNew, goalBoard)));
        }

        //top
        if (zero != 6 && zero != 7 && zero != 8)
        {
            int[] copyNew = copyBoard(cBoard);
            int temp = copyNew[zero+3];
            copyNew[zero+3] = cBoard[zero];
            copyNew[zero] = temp;
            successors.add((new Puzzle(copyNew, goalBoard)));


        }

        //bottom
        if (zero != 0 && zero != 1 && zero != 2)
        {
            int[] copyNew = copyBoard(cBoard);
            int temp = copyNew[zero-3];
            copyNew[zero-3] = cBoard[zero];
            copyNew[zero] = temp;
            successors.add((new Puzzle(copyNew, goalBoard)));
        }
        //right
        if (zero != 2 && zero != 5 && zero != 8)
        {
            int[] copyNew = copyBoard(cBoard);
            int temp = copyNew[zero+1];
            copyNew[zero+1] = cBoard[zero];
            copyNew[zero] = temp;
            successors.add((new Puzzle(copyNew, goalBoard)));
        }

        return successors;
    }




    @Override
    public boolean checkIfEqual(State s)
    {
        if (Arrays.equals(cBoard, ((Puzzle) s).getCurrentBoard()))
        {
            return true;
        }
        else
            return false;

    }



}