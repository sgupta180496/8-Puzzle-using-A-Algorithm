# Solving the 8 puzzle using A* Algorithm

## 1. 8 Puzzle
The 8-puzzle problem involves a set of eight numbered movable tiles in a 3x3 frame. One cell of the frame is kept blank, thus allowing the adjacent tiles to change their location. The program is to change the initial configuration into the goal configuration. A solution to the problem is an appropriate sequence of moves, such as “move tiles 5 to the right, move tile 7 to the left, move tile 6 to the down, etc”.

#### Problem Formulation:
**Goal:** pieces should end up in order shown as goal state

**States:** integer locations of tiles

**Actions:** move blank left, right, up, down

**Path cost:** 1 per move

**Performance measure:** minimize total moves

**Solution:** sequence of pieces moved


## 2. Program Structure
The programming language used for this project was Java. We’ve divided the program into four classes and one interface.

**1. State:** Interface - Contains methods that needs to be implemented.
		
		**Functions:**
		
		1. checkIfEquals : needs to be implemented
		
		2. generateSuccessors: needs to be implemented
		
		3. isGoal: needs to be implemented
		
		4. printState: needs to be implemented
		
		**Global Variables:** None

**2. ChooseAHeuristic:** Class - Contains main method
		
		**Functions:**
		
		1. Main : To give user inputs for initial and final board of 8 puzzle.
		
		2. pass: gets initial and final board and a heuristic choice by user and calls the AstarSearch class’ search function.
		
		**Global Variables:** None
		
**3. Node:** Class- handles nodes for a current state
		
		**Functions:**
		
		1. Two Node constructors: one stores root and second stores nodes other than root.
		
		2. getGn: returns g(n) cost.
		
		3. getFn: returns f(n) cost.
		
		4. getHn: returns H(n) cost i.e. heuristic’s cost.
		
		5. getParent: returns current node’s parent.
		
		6. getCurrentState: returns child of current node.
		
		**Global Variables:**
		
		gn: path cost to get to this node.
		
		hn: heuristic cost for the state.
		
		fn: total cost for the state.
		
		child: stores current state’s child.
		
		parent: stores the current node’s parent.
		
**4. Puzzle:** Class - This class implements the State interface
		
		**Functions:**
		
		1. Puzzle: A constructor that calls manhattanDist() and totalTiles() to calculate the cost and stores the initial and final board.
		
		2. totalTiles(): calculates number of misplaced tiles.
		
		3. manhattanDist(): calculates the manhattan distance.
		
		4. getZero(): gives the index of the zero from the board.
		
		5. getOutOfPlace: returns the total number of tiles that are misplaced.
		
		6. getCurrentBoard: returns an array of current board.
		
		7. copyBoard(): copies a single dimension array of board from one to other.
		
		8. generateSuc(): generates ArrayList of successors for current state.
		
		9. isGoal: overrides this function to check if it’s a goal state.
		
		10. checkIfEquals: checks if the current node is equal to the previous.
		
		11. printState: prints the state.
		
		**Global Variables:**
		
		12. totalTiles: stores total number of misplaced tiles
		
		13. mDist: Manhattan distance
		
		14. goalBoard: This contains the goal board
		
		15. cBoard: This contains current board

**5. AStarSearch:** Class- This class implements A star search algorithm
		
		**Functions:**
		
		1. search(): maintains a queue of Nodes and an ArrayList of temporary successor of a state . It also contains ArrayList of Nodes that contains all the successors for a node. It also prints the cost of the path, the number of nodes expanded and the number of nodes generated.
		
		2. checkRepeats(): Takes a node and checks if a node has been repeated.
		
		**Global Variables:** None

### 2.1. User Input

The user is expected to give three inputs:

• The first input should be the heuristic to choose.

• The second input should be the initial board.

• The third input should be the final board.

### 2.2. Functionality

Program comprises of an interface which has some functions implemented by the puzzle class. It has a main class responsible for taking user input for choice of heuristic, initial state board and final state board of 8-puzzle. Then it passes both the states and the choice of heuristic to a function ‘pass’ which calls the A* search. There are two constructors, one accepting a single state, used for storing the root node. Other used to store nodes apart from root node. There is a class ‘node’ which has 5 global variables. Node also has 5 functions. Function, getCurrentState returns the child of current state and getParent returns parent node. getGn, getFn, getHn return the value of gn, fn and hn respectively. Puzzle is a class which implements interface state and calculates manhattan distance and number of misplaced tiles. It checks if the goal state is reached and prints the current states. It is also responsible for generating array list of successors.getOutOfPlace returns the number of out of place tiles and getZero function determines the index of 0 in the board.

The A* search function will create a root node, object of Node class and a queue which consists of nodes. Till the queue is non-empty, a while loop is used to pull out first element of queue and place in a temporary node. The node is checked for goal state, if it is not a goal state, its successors will be generated using generated successor function and these successors will be stores in an array list of state. fn of all the expanded nodes is calculated and compared and the one with least fn is used for further expansion. CheckRepeats function is used on these temporary nodes to check if the nodes exist in ArrayList or not. If two or more successors have same fn, both will be added in the queue and a searchCount will be incremented for number of explored nodes. Else if the goal state is reached, a stack of nodes is created and push the temporary node. getParent is used to access the parent node and it is then stored in temporary node. Similarly, all the parents are achieved till the root node is pushed into the stack and the path to the goal state is identified. These states will be printed one by one by popping them out until the stack is empty. temporaryNode.getGn prints the cost of implementation.
