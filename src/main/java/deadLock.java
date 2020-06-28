import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class deadLock extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" In Control");
        }
    }
    public static void main(String[] args) {
        deadLock t = new deadLock();
        t.start();
        for(int i=0;i<5;i++){
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+" in control");
        }
        //Fixed Thread Pool
        ExecutorService ex = Executors.newFixedThreadPool(10);
        ex.execute(t);
    }
}
