package matriumultiprocessing;

public class ProcessingUnit implements Runnable {

    int cX;
    int cY;
    int[][] A;
    int[][] B;
    ProductArray C;

    //cX && cY == CELL TO CALCULATE
    //A && B && C == REQUIRED ELEMENTS
    public ProcessingUnit(int cX, int cY, int[][] A, int[][] B, ProductArray C) {
        this.cX = cX;
        this.cY = cY;
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    @Override
    public void run() {
        
        int valuesToCalculate = A[0].length;
        int value = 0;
        
        for (int i = 0 ; i < valuesToCalculate ; i++) {
            value += A[cX][i] * B[i][cY];
        }
        
        C.setField(cX, cY, value);
    }
}

