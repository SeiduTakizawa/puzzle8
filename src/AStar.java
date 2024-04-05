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
        boolean loop = true;
        while (loop){
            int min = startNode.gethList().get(0);
            int position = 0;
            for(int i = 1; i < startNode.gethList().size(); i++){
                if(startNode.gethList().get(i) < min){
                    min = startNode.gethList().get(i);
                    position = i;
                }
            }
            // Now 'position' is the index of the smallest element
            // Do something with 'position'
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
