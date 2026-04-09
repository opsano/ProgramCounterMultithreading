import java.util.concurrent.atomic.*;
public class DisplayThread implements Runnable{
    AtomicInteger programsRanPerSecond = new AtomicInteger();
    AtomicInteger totalProgramsToRun = new AtomicInteger();
    AtomicInteger totalProgramsRan = new AtomicInteger();
    public void run(){
        try {
            while(true){
                Thread.sleep(1000);
                System.out.printf("|%d - Operations Per Second|\n|%d - Total Operations Performed|\n",programsRanPerSecond.get(),totalProgramsRan.get());
                programsRanPerSecond.set(0);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
