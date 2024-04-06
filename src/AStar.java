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
        int position = 0;
        for(int i = 1; i < node.gethList().size(); i++){

        }
    }
    public void run(){
        Node currNode = startNode;
        boolean loop = true;
        while (loop){
            PossibleStates possibleStates = new PossibleStates(currNode);
            createHList(currNode);
            int min = currNode.gethList().get(0);
            int position = 0;
            for(int i = 1; i < currNode.gethList().size(); i++){

                if(!currNode.getParent().isDupe(currNode.getChildren().get(i))){
                    if(currNode.gethList().get(i) < min){
                        min = currNode.gethList().get(i);
                        position = i;
                    } else if (currNode.gethList().get(i) == min) {
                        min = currNode.gethList().get(i);
                    }
                }

            }
            if(currNode.getParent() == null){
                currNode = currNode.getChildren().get(position);
                Board board = new Board(currNode.getState());
                System.out.println("CHOSEN BOARD");
                board.display();
                System.out.println("BASTARD=========================================");
            } else if (currNode.getParent().isDupe(currNode.getChildren().get(position))){
                currNode = currNode.getChildren().get(position + 1);
                Board board = new Board(currNode.getState());
                System.out.println("CHOSEN BOARD");
                board.display();
                System.out.println("=========================================");
            } else {
                currNode = currNode.getChildren().get(position);
                Board board = new Board(currNode.getState());
                System.out.println("CHOSEN BOARD");
                board.display();
                System.out.println("=========================================");
            }
            if(min == 0){
                loop = false;
            }
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
