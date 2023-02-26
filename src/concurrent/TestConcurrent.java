package concurrent;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestConcurrent {
    private ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(10);
    public void schedule(Runnable event, long delay){
        poolExecutor.schedule(event,delay,TimeUnit.MILLISECONDS);
    }
    public void repeat(Runnable event, long delay, long period){
        poolExecutor.scheduleAtFixedRate(event,delay,period,TimeUnit.MILLISECONDS);
    }
}
class TestSchedule {
    private ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(10);
    public void schedule(Runnable event, long delay){
        poolExecutor.schedule(event,delay,TimeUnit.MILLISECONDS);
    }
    public void repeat(Runnable event, long delay, long period){
        poolExecutor.scheduleAtFixedRate(event,delay,period,TimeUnit.MILLISECONDS);
    }
}
class AAA implements Runnable{
    public void run() { throw new RuntimeException();}
}

class BBB implements Callable<String>{
    public String call() throws Exception {return null;}
}

class ccc {
    private int count = 0;
    public synchronized int next(){return ++count;}
}
class ddd {
    private int count = 0;
    private Lock lock = new ReentrantLock();
    public  int next(){
        lock.lock();
        try{
            return ++count;
        }finally {
            lock.unlock();
        }
    }
}

class TaskPortion implements Runnable{
    private final CountDownLatch latch = new CountDownLatch(100);
    public void run() {
        try{
            Thread.sleep(100);
            latch.countDown();
        }catch (InterruptedException e){}
    }
}
class WaitingTask implements Runnable{
    private final CountDownLatch latch;
    public WaitingTask(CountDownLatch latch){
        this.latch = latch;
    }
    public void run() {
        try{
            latch.await();
        }catch (InterruptedException e){}
    }
}