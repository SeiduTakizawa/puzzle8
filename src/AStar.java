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
    public void run(){
        Node currNode= startNode;
        boolean loop = true;
        while (loop){
            PossibleStates possibleStates = new PossibleStates(currNode);
            createHList(currNode);
            int min = currNode.gethList().get(0);
            int position = 0;
            for(int i = 1; i < currNode.gethList().size(); i++){
                if(currNode.gethList().get(i) < min){
                    min = currNode.gethList().get(i);
                    position = i;

                }
            }
            currNode = currNode.getChildren().get(position);
            if(min == 0){
                loop = false;
            }
        }
    }


    public void createHList(Node node){
        List<Node> children = node.getChildren();
        for(int i = 0;i<children.size();i++){
            Calculate_h calculate_h = new Calculate_h(children.get(i).getState());
            startNode.addHList(calculate_h.getH());
        }
        System.out.println();
    }
}
