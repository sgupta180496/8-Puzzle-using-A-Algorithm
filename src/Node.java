
public class Node {

    public double gn; // cost to get to this state
    public double hn; // heuristic cost
    public State child;
    public Node parent;
    public double fn; // f(n) cost


    public Node(State s)  //root Node
    {
        child = s;
        parent = null;
        gn = 0;
        hn = 0;
        fn = 0;
    }


    public Node getParent() {
        return parent;
    }


    public double getGn() {
        return gn;
    }


    public State getCurrentState() {
        return child;
    }


    public Node(Node prev, State s, double c, double h) //Other than root nodes
    {
        parent = prev;
        child = s;
        gn = c;
        hn = h;
        fn = gn + hn;
    }


    public double getFn() {
        return fn;
    }


    public double getHn() {
        return hn;
    }

}
