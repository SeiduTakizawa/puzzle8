public class Main {
        public static void main(String[] args) {

            Board puzzle8= new Board(3, 3);
            puzzle8.initializePuzzle();
            puzzle8.display();
            Node node = new Node(puzzle8.getArray());
            //ucs ucs = new ucs(node);
            //ucs.solve();
            System.out.println("astar");
            astar_new aStar = new astar_new(node);
            aStar.solve();
            /*
            Board testBoard1 = new Board(3,3);
            testBoard1.initializePuzzle();
            testBoard1.setPossibleMoves();
            testBoard1.display();
            testBoard1.move(Board.Direction.DOWN_RIGHT);
            testBoard1.display();



             */
            //AStar aStar = new AStar(node);
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

