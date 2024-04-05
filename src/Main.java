public class Main {
        public static void main(String[] args) {
            Board puzzle8= new Board(3, 3);
            puzzle8.initializePuzzle();
            Node node = new Node(puzzle8.getArray());
            MovableElement movableElement = new MovableElement(puzzle8.getArray());
            if(movableElement.move(MovableElement.Direction.RIGHT)){
                puzzle8.display();
            }
            puzzle8.display();
            PossibleStates possibleStates = new PossibleStates(node);
            /*puzzle8.initializePuzzle();
            puzzle8.display();
            Calculate_h h=new Calculate_h(puzzle8.getArray());
            System.out.println(h.getH());
            MovableElement move=new MovableElement(puzzle8.getArray());
            if(move.move(MovableElement.Direction.DOWN)){
                puzzle8.display();
                System.out.println(h.getH());
            }
            if(move.move(MovableElement.Direction.DOWN)){
                puzzle8.display();
            }
            else {
                System.out.println("cant do it");
            }
            */
        }
    }

