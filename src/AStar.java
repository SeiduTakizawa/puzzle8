import java.util.List;

public class AStar {
    Node startNode;
    public AStar(Node node){
        startNode = node;
        run();
    }
    public void run(){
        PossibleStates possibleStates = new PossibleStates(startNode);
        createHashMap(startNode);
        //while h not zero possible states me mikrotero h
        String smallestKey = null;
        for (String key : startNode.keySet()) {
            if (smallestKey == null || key.compareTo(smallestKey) < 0) {
                smallestKey = key;
            }
        }
    }

    public void createHashMap(Node node){
        List<Node> children = node.getChildren();
        for(int i = 0;i<children.size();i++){
            Calculate_h calculate_h = new Calculate_h(children.get(i).getState());
            startNode.addChildrenMap(children.get(i),calculate_h.getH());
        }
        System.out.println();
    }
}
