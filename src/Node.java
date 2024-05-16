import com.sun.source.tree.UsesTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Node {

    private int[][] state;
    private List<Node> children;
    private List<Integer> hList;
    private Node parent;
    private int cost;
    private int depth;
    private List<Integer> fList = new ArrayList<>();
    private String stringState;
    private Integer maxCost;

    public Node (int[][] state){
        this.state =state;
        this.children = new ArrayList<Node>();
        this.hList = new ArrayList<>();
        this.parent = null;
        this.cost = 0;
        this.depth = 1;
        this.stringState = stringBuilder();
        this.maxCost = 0;
    }

    public String stringBuilder(){
        StringBuilder str = new StringBuilder();
        for (int i =0; i<state.length; i++) {
            for(int j = 0; j<state[i].length;j++ ) {
                str.append(state[i][j]);
            }
        }
        return str.toString();
    }
    public String getStateString(){
        return stringState;
    }
    public int hashCode(){
        return this.getStateString().hashCode();
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
    public boolean isGoal(){

        boolean result = false;
        int [][] goal = {{6, 5, 4}, {7, 0, 3}, {8, 1, 2}};
        Node goalNode = new Node(goal);
        result = this.stringState.equals(goalNode.stringState);
        return result;

    }
    public boolean isDupe(Node node){
        for (int i = 0; i < node.getState().length; i++) {
            for (int j = 0; j < node.getState().length; j++) {
                if (this.getState()[i][j] != node.getState()[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public List<Integer> gethList() {
        return hList;
    }

    public void addHList(Integer h) {
        hList.add(h);
    }

    public int getCost() {
        return cost;
    }
    public void setMaxCost(int i) {
        this.maxCost = this.getParent().getMaxCost() + i;
    }

    public Integer getMaxCost() {
        return maxCost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth){
        this.depth = depth;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void addChildren(Node childNode) {
        childNode.setMaxCost(childNode.getCost() + this.getMaxCost());
        this.children.add(childNode);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void addFList(int f) {
        this.fList.add(f);
    }
    public List<Integer> getFList() {
        return this.fList;
    }
    public int[][] getState() {
        return state;
    }

    public void setState(int[][] state) {
        this.state = state;
    }
}
