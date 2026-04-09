import java.util.concurrent.atomic.*;
public class DisplayThread implements Runnable{
    AtomicInteger programsRanPerSecond = new AtomicInteger();
    AtomicInteger timeRan = new AtomicInteger();
    AtomicInteger totalProgramsRan = new AtomicInteger();
    public void run(){
        try {
            while(true){
                Thread.sleep(1000);
                timeRan.incrementAndGet();
                System.out.printf("------------------------------\n" +
                                "|%d - Operations Per Second\n|%d - Total Operations Performed\n|%s" +
                                "\n------------------------------\n",
                        programsRanPerSecond.get(),totalProgramsRan.get(),getFormattedTime());
                programsRanPerSecond.set(0);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private String getFormattedTime(){
        int hours, minutes, seconds;
        hours = minutes = 0;
        seconds = timeRan.get();
        while (seconds >= 60){
            seconds -= 60;
            minutes++;
        }
        while (minutes >= 60){
            minutes -= 60;
            hours++;
        }
        return String.format("%02d:%02d:%02d - Total Time Elapsed",hours, minutes, seconds);
    }
}
