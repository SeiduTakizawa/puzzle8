import com.sun.source.tree.UsesTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    private int[][] state;
    private List<Node> children;
    private Node parent;
    private int cost;
    private int depth;

    public Node (int[][] state){
        this.state = deepCopy(state);
        this.children = new ArrayList<Node>();
        this.parent = null;
        this.cost = 0;
        this.depth = 1;

    }
    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    public void printChildren() {
        String string = null;
        for (Node child : children) {
            for (int i = 0; i < child.getState().length; i++) {
                for (int j = 0; j < child.getState().length; j++) {
                    System.out.print(child.getState()[i][j] + " " );
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDepth() {
        return depth;
    }

    public void addDepth() {
        this.depth += 1;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void addChildren(Node childNode) {
        children.add(childNode);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }


    public int[][] getState() {
        return state;
    }

    public void setState(int[][] state) {
        this.state = state;
    }
}
