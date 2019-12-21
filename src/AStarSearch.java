import java.util.*;

public class AStarSearch
{

    public static void search(int[] board, int finalBoard[], int heuristic)
    {
        Puzzle eight=new Puzzle(board,finalBoard);
        Node root = new Node(eight);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        ArrayList<Node> nodeCal=new ArrayList<>();

        double cost=0;
        int sum=0;

        int searchCount = 1;

        while (!q.isEmpty())
        {
            Node tempNode = q.poll();
            //Queue dequeue



            // if the tempNode is not the goal state
            if (!tempNode.getCurrentState().isGoal())
            {
                ArrayList<Node> nodeSuccessors = new ArrayList<>();

                ArrayList<State> tempSuccessors = tempNode.getCurrentState().generateSuc();

                sum=sum+tempSuccessors.size();

                for (int i = 0; i < tempSuccessors.size(); i++)
                {
                    Node checkedNode;
                    // make the node
                    if (heuristic == 1)
                    {
                        double hcost=((Puzzle)tempSuccessors.get(i)).getOutOfPlace();

                        checkedNode = new Node(tempNode,
                                tempSuccessors.get(i), tempNode.getGn()+1 ,hcost);
                    }
                    else
                    {
                        double hcost=((Puzzle)tempSuccessors.get(i)).manhattanDist();

                        checkedNode = new Node(tempNode,
                                tempSuccessors.get(i), tempNode.getGn() + 1,hcost);
                    }

                    // Check for repeats before adding the new node
                    if (!checkRepeats(checkedNode))
                    {
                        nodeSuccessors.add(checkedNode);
                    }
                }

                if (nodeSuccessors.size() == 0)
                    continue;

                Node lowestNode = nodeSuccessors.get(0);

                //set lowest f(n) wala node
                for (int i = 0; i < nodeSuccessors.size(); i++)
                {
                    if (lowestNode.getFn() > nodeSuccessors.get(i)
                            .getFn())
                    {
                        lowestNode = nodeSuccessors.get(i);
                    }
                }

                int lowestValue = (int) lowestNode.getFn();

                // if value kam add to queue
                for (int i = 0; i < nodeSuccessors.size(); i++)
                {
                    if (nodeSuccessors.get(i).getFn() == lowestValue)
                    {
                        q.add(nodeSuccessors.get(i));
                    }
                }

                searchCount++;
            }
            else
            //Goal state!!!! :3
            {
                // stack path from the start to the goal
                Stack<Node> stackOfNodes = new Stack<>();
                stackOfNodes.push(tempNode);
                tempNode = tempNode.getParent();

                while (tempNode.getParent() != null)
                {
                    stackOfNodes.push(tempNode);
                    tempNode = tempNode.getParent();
                }
                stackOfNodes.push(tempNode);

                int loopSize = stackOfNodes.size();

                for (int i = 0; i < loopSize; i++)
                {
                    tempNode = stackOfNodes.pop();

                    tempNode.getCurrentState().printState();
                    System.out.println();
                    System.out.println();
                }

                cost=tempNode.getGn();
                System.out.println("Cost : " + cost);

                System.out.println("The number of nodes expanded: "
                            + searchCount);
                System.out.println("The number of nodes generated: "
                        + sum);

                //System.out.println("The number of nodes expanded: " + expanded);

                System.exit(0);
            }
        }


        //No solution
        System.out.println("No solution");

    }


    private static boolean checkRepeats(Node n)
    {
        Node node = n;
        boolean x = false;

        while (n.getParent() != null && !x)
        {
            if (n.getParent().getCurrentState().checkIfEqual(node.getCurrentState()))
            {
                x = true;
            }
            n = n.getParent();
        }

        return x;
    }

}