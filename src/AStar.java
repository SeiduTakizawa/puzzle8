import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AStar {
    Node startNode;
    public AStar(Node node){
        startNode = node;
        run();
    }
    public Node getMinHNode(Node node){
        int min = node.gethList().get(0);
        int position = 1;
        for(int i = 0; i < node.gethList().size(); i++){
            if(node.getParent() == null){
                if(node.gethList().get(i) < min) {
                    min = node.gethList().get(i);
                    position = i;
                }
            }
            else if(!node.getParent().isDupe(node.getChildren().get(i))){
                if(node.gethList().get(i) < min) {
                    min = node.gethList().get(i);
                    position = i;
                }
            }
        }
        return node.getChildren().get(position);
    }
    public void run(){
        Node currNode = startNode;
        boolean loop = true;
        while (loop){
            PossibleStates possibleStates = new PossibleStates(currNode);
            createHList(currNode);
            currNode = getMinHNode(currNode);
            Board board = new Board(currNode.getState());
            System.out.println("CHOSEN BOARD");
            board.display();
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
