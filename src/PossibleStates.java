public class PossibleStates {
    public PossibleStates(Node node){
        MovableElement movableElement = new MovableElement(node.getState());

        for(int i=0;i<8;i++){
            if(movableElement.move(movableElement.getDirections().get(i))){
                Node childNode = new Node(movableElement.getBoard());
                node.addChildren(childNode);
            }
        }
        node.printChildren();
    }
}
