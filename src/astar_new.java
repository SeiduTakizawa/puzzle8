import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class astar_new {

    private Node initialState;

    public astar_new(Node initialState) {
        this.initialState = initialState;
    }
    private class gComparator implements Comparator<Node> {

        public int compare(Node a, Node b) {
            return a.getF() - b.getF();
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
        board.setPossibleMoves();
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
        Board board = new Board(node.getState());
        board.display();
    }
}
