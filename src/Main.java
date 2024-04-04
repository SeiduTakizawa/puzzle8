public class Main {
        public static void main(String[] args) {
            Board puzzle8= new Board(3, 3);
            puzzle8.display();
            Calculate_h h=new Calculate_h(puzzle8.getArray());
            System.out.println(h.getH());
            MovableElement move=new MovableElement(puzzle8.getArray());
            if(move.move(0,1, MovableElement.Direction.DOWN)){
                puzzle8.display();
            }
        }
    }

