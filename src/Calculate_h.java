public class Calculate_h {
    private int[][] myArray;
    private int targetArray[][] = {{6, 5, 4}, {7, 0, 3}, {8, 1, 2}}; // Predefined target

    public Calculate_h(int[][] myArray) {
        this.myArray = myArray;
    }

    public int getH() {
        int h = 0;

        // Iterate through the arrays
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (myArray[i][j] != targetArray[i][j]) {
                    h++; // Count mismatched tiles
                }
            }
        }

        return h;
    }
}
