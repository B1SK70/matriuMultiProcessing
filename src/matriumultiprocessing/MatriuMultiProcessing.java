package matriumultiprocessing;

import java.util.ArrayList;

public class MatriuMultiProcessing {

    private ArrayList<ProcessingUnit> processingUnits = new ArrayList<ProcessingUnit>();

    int[][] A;
    int[][] B;
       
    public MatriuMultiProcessing() {

        //MULTIPLICATION FACTORS
        A = new int[1000][500];
        fillArray(A);
        
        B = new int[500][1200];
        fillArray(B);
        
        //MULTIPLICATION PRODUCT
        ProductArray C = new ProductArray(A.length, B[0].length);

        //PRODUCT CELLS CALCULATORS
        for (int cX = 0; cX < A.length; cX++) {
            for (int cY = 0; cY < B[0].length; cY++) {
                processingUnits.add( new ProcessingUnit(cX, cY, A, B, C) );
            }
        }

        //START CALCULATION
        ArrayList<Thread> pUnitThreads = new ArrayList<Thread>();
        
        long startTime = System.nanoTime();
        
        processingUnits.forEach((pUnit) -> {
            Thread pUnitThread = new Thread(pUnit);
            pUnitThread.start();
            
            pUnitThreads.add(pUnitThread);
        });

        
        //printAandB();
               
        //DISPLAY ON FINISH
        Thread solutionPrinter = new Thread(new SolutionPrinter(pUnitThreads, A, B, C));
        solutionPrinter.start();
        
        try {
            solutionPrinter.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        long endTime = System.nanoTime();
        
        System.out.println("");
        System.out.println("Start time \t" + startTime);
        System.out.println("End time \t" + endTime);
        System.out.println("Execution time \t" + (endTime - startTime));
        
    }
    
    private void fillArray(int[][] toFill) {
        for (int x = 0 ; x < toFill.length ; x++) {
            for ( int y = 0 ; y < toFill[x].length ; y++) {
                toFill[x][y] = (int) (Math.random() * 20);
            }
        }
    }
    
    private void printAandB() {
        System.out.println("ELEMENT A");
        printArray(A);
        System.out.println("--------------");
        
        System.out.println("ELEMENT B");
        printArray(B);
        System.out.println("--------------");
    }
    
    private void printArray(int[][] arrayData) {
        for (int x = 0 ; x < arrayData.length ; x++ ) {
            for ( int y = 0 ; y < arrayData[x].length ; y++ ) {
                System.out.print("[" + x + "][" + y + "] = " + arrayData[x][y] + "    ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        new MatriuMultiProcessing();
    }

}
