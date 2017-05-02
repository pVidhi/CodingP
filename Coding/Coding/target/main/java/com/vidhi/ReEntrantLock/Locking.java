package com.vidhi.ReEntrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vidhip on 5/1/17.
 */
public class Locking {

    static Counter counter = new Counter();
    static int maxThreads = 8;

    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);

        for(int i =0; i < maxThreads; i++){
            WorkerThread thread = new WorkerThread(i, counter);
            executor.execute(thread);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            System.out.println(counter.getApproxCount());
            System.out.println(counter.getExactCount());
        }
        System.out.println(counter.getApproxCount());
        System.out.println(counter.getExactCount());
    }

    public static class WorkerThread implements Runnable {

        private int threadId;
        private Counter counter;

        public WorkerThread(int id, Counter c){
            threadId = id;
            counter = c;
        }

        @Override
        public void run(){
            processCommand();
        }

        private void processCommand(){
            try {
                System.out.println("Thread" + threadId + "started");
                Thread.sleep(8000);
                counter.incrementCounter(threadId);
                System.out.println("Thread" + threadId + "done");
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }

    }
}
