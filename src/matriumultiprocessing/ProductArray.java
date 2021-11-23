package matriumultiprocessing;

public class ProductArray {
    
    private int[][] arrayData;

    public ProductArray( int xSize, int ySize ){
        arrayData = new int[xSize][ySize];
    }
    
    public void printArray() {
    
        for (int x = 0 ; x < arrayData.length ; x++ ) {
            for ( int y = 0 ; y < arrayData[x].length ; y++ ) {
                System.out.print("[" + x + "][" + y + "] = " + arrayData[x][y] + "    ");
            }
            System.out.println();
        }
    
    }
    
    public void setField (int x, int  y, int value) {
        this.arrayData[x][y] = value;
    }
    
}
