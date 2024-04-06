import java.util.HashMap;

public class PossibleStates {
    public PossibleStates(Node node){
        Board puzzle8=new Board(3,3);
        puzzle8.initializePuzzle();

        for(int i=0;i<8;i++){
            MovableElement movableElement = new MovableElement(node.getState());
            if(movableElement.canMove(movableElement.getDirections().get(i))){
                Node childNode = new Node(movableElement.move(movableElement.getDirections().get(i)));
                childNode.setParent(node);
                node.addChildren(childNode);
                
            }
        }
        node.printChildren();
    }
}
