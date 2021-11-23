package matriumultiprocessing;

import java.util.ArrayList;
public class SolutionPrinter implements Runnable{
    
    private ArrayList<Thread> processingUnits;
    private ProductArray C;
    
    public SolutionPrinter ( ArrayList<Thread> processingUnits, int[][] A, int[][] B, ProductArray C ) {
        this.processingUnits = processingUnits;
        this.C = C;
    }    
   
    @Override
    public void run() {
        //WAIT FOR CALCULATIONS
        processingUnits.forEach((pUnit) -> {
            try {
                pUnit.join();
            } catch (Exception e) {
                System.out.println("Thread join error: " + e);
           }
        });
        System.out.println("ELEMENT RESULTANT");
        //C.printArray();
    }
}
