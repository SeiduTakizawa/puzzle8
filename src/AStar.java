import java.util.*;

public class AStar {
    Node startNode;
    private List<Node> visitedList = new ArrayList<Node>();
    public AStar(Node node){
        startNode = node;
        run();
    }
    public Node getMinHNode(Node node){
        int min = node.gethList().get(0);
        int position = 0;
        for(int i = 0; i < node.gethList().size(); i++){
            if(node.getParent() == null){
                if(node.gethList().get(i) < min) {
                    min = node.gethList().get(i);
                    position = i;
                }
            }
            else if(!node.getParent().isDupe(node.getChildren().get(i))){ //Check if parent is same as a children
                if(deepContains(node)){
                    if(node.gethList().get(i) < min) {  //Check if it is smaller than then current min
                        min = node.gethList().get(i);
                        position = i;
                    } else if (node.gethList().get(i) == min){ //Check if it is equal to the current min
                        position = i;
                    }
                }
            }
        }
        return node.getChildren().get(position);
    }

    public boolean deepContains(Node node) {
        for (Node element : visitedList) {
            if (Arrays.deepEquals(element.getState(), node.getState()))
                return true;
        }
        return false;
    }
    public void run(){
        Node currNode = startNode;
        boolean loop = true;
        while (loop){
            PossibleStates possibleStates = new PossibleStates(currNode);
            createHList(currNode); //create the h for each child
            currNode = getMinHNode(currNode); //move the current node based on the h values
            visitedList.add(currNode);
            Board board = new Board(currNode.getState());
            System.out.println("CHOSEN BOARD");
            board.display();
            Calculate_h h = new Calculate_h(board.getArray());
            System.out.println(h.getH());
            System.out.println("=========================================");
        }
    }


    public void createHList(Node node){
        List<Node> children = node.getChildren();
        for(int i = 0;i<children.size();i++){
            Calculate_h calculate_h = new Calculate_h(children.get(i).getState());
            node.addHList(calculate_h.getH());
        }
        System.out.println();
    }
}
