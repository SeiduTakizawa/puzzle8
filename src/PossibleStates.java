import java.util.HashMap;

public class PossibleStates {
    public PossibleStates(Node node){

        for(int i=0;i<8;i++){
            MovableElement movableElement = new MovableElement(node.getState());
            if(movableElement.canMove(movableElement.getDirections().get(i))){
                Node childNode = new Node(movableElement.move(movableElement.getDirections().get(i)));
                childNode.setParent(node);
                node.addChildren(childNode);
                
            }
        }
    }
}
