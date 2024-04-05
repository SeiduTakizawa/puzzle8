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
        PossibleStates possibleStates = new PossibleStates(startNode);
        createHList(startNode);
        //while h not zero possible states me mikrotero h
        boolean loop = true;
        while (loop){
            for(int i = 0;i<startNode.gethList().size();i++){
                if
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
