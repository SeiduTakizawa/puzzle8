public class PossibleStates {
    public PossibleStates(Node node){

        for(int i=0;i<8;i++){
            Board puzzle8=new Board(3,3);
            puzzle8.initializePuzzle();
            MovableElement movableElement = new MovableElement(puzzle8.getArray());
            if(movableElement.move(movableElement.getDirections().get(i))){
                Node childNode = new Node(movableElement.getBoard());
                node.addChildren(childNode);
            }
        }
        node.printChildren();
    }
}
