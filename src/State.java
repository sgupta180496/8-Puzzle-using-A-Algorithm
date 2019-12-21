import java.util.ArrayList;


public interface State
{
    boolean checkIfEqual(State s);
    boolean isGoal();
    ArrayList<State> generateSuc();
    void printState();

}

