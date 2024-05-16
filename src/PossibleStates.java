import java.util.HashMap;

public class PossibleStates {
    public PossibleStates(Node node){
        for(int i=0;i<8;i++){
             Board movableElement = new Board(node.getState());
            if(movableElement.canMove(movableElement.getDirections().get(i))){
                movableElement.move(movableElement.getDirections().get(i));
                Node childNode = new Node(movableElement.getBoard());
                childNode.setParent(node);
                node.addChildren(childNode);
                
            }
        }
    }
}
