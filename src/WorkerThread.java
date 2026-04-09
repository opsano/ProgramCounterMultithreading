import java.util.concurrent.atomic.*;
public class WorkerThread{
    public static void main(String[] Args){
        DisplayThread counter = new DisplayThread();
        Thread display = new Thread(counter);
        display.setDaemon(true); // stops infinite runtime
        display.start();
        long result = fib(45, counter);
        System.out.println(result);
    }

    public static long fib(int n, DisplayThread display) {
        if (n <= 1) return n;
        display.programsRanPerSecond.incrementAndGet();
        display.totalProgramsRan.incrementAndGet();
        return fib(n - 1, display) + fib(n - 2, display);
    }
}
