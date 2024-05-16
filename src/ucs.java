import java.util.*;
import java.util.Comparator;


public class ucs {

    private Node initialState;

    public ucs(Node initialState) {
        this.initialState = initialState;
    }
    private class gComparator implements Comparator<Node>{

        public int compare(Node a, Node b) {
            return a.getMaxCost() - b.getMaxCost();
        }
    }
    public boolean solve() {

        int i=0;
        PriorityQueue<Node> queue = new PriorityQueue<>(new gComparator());
        initialState.setCost(0); // Initial state cost is 0 moves
        queue.add(initialState);
        HashMap<Integer, Node> visited = new HashMap<Integer,Node>();
        while (!queue.isEmpty()) {

            i++;
            Node currentNode = queue.poll();
            Board board = new Board(currentNode.getState());
            board.display();
            System.out.println(i);
            visited.put(currentNode.hashCode(), currentNode); // Mark current state as visited

            if (currentNode.isGoal()) {
                System.out.println("Solution Found!");
                printPath(currentNode);
                return true;
            }

            List<Node> successors = generateSuccessors(currentNode);
            for (Node child : successors) {
                if (!visited.containsKey(child.hashCode())) {
                    queue.add(child);
                }
            }
        }

        System.out.println("No solution found.");
        return false;
    }

    private List<Node> generateSuccessors(Node node) {

        Board board = new Board(node.getState());
        board.getPossibleMoves();
        for (Board.Direction direction : board.getPossibleMoves()){
            int cost = board.move(direction);
            Node childNode = new Node(board.getBoard());
            childNode.setCost(cost);
            childNode.setParent(node);
            childNode.setDepth(node.getDepth() + 1);
            node.addChildren(childNode);
            board.setBoard(node);
        }
        /*
        for(int i=0;i<8;i++){
            Board movableElement = new Board(node.getState());
            if(movableElement.canMove(movableElement.getDirections().get(i))){
                int cost = movableElement.move(movableElement.getDirections().get(i));
                Node childNode = new Node(movableElement.getBoard());
                childNode.setParent(node);
                childNode.setCost(cost);
                childNode.setDepth(node.getDepth() + 1);
                node.addChildren(childNode);
            }
        }

         */
        return node.getChildren();
    }

    private void printPath(Node node) {
        if (node == null) {
            return;
        }
        printPath(node.getParent()); // Recursive call to print parent's path

        System.out.println(node.getStateString());
    }
}
