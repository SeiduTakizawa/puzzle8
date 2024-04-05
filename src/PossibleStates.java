public class PossibleStates {
    public PossibleStates(Node node){
        MovableElement movableElement = new MovableElement(node.getState());

        for(int i=0;i<8;i++){
            if(movableElement.move(movableElement.getDirections().get(i))){
                System.out.println("nigger");
            }
        }
        node.printChildren();
    }
}
