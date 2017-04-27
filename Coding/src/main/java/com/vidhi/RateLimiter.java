package com.vidhi.RateLimiter;

import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by vidhip on 4/26/17.
 */
public class RateLimiter {


    static final ReentrantLock lock = new ReentrantLock();
    static SingleLinkedList linkedList = new SingleLinkedList();
    static int maxRequestsPerSecond = 4;

    public static void main(String[] args){

        System.out.println("Test Started");

        int count = 0;
        int maxCount = 10;

        while(count < maxCount){
            count++;
            try {
                Thread.sleep(10000);
                process();
            } catch(Exception e){
            }

        }

        linkedList.display();;

        System.out.println("Test Ended");
    }

    private static void process() throws ThrottleException {

        lock.lock();  // block until condition holds

        try {
            long currentTime = System.currentTimeMillis();
            System.out.println(currentTime);

            Node n = new Node();
            n.setTime(currentTime);

            if (linkedList.size() < maxRequestsPerSecond) {
                linkedList.insert(n);
            } else {

                long timeAtTail = linkedList.getTail().getTime();

                if (currentTime - timeAtTail < 60000) {
                    System.out.println("EXCEPTION");
                    throw new ThrottleException();
                } else {
                    linkedList.removeFirst();
                    linkedList.insert(n);
                }
            }
        }finally {
            lock.unlock();
        }

    }

    public static class ThrottleException extends RuntimeException {
        public ThrottleException(){
            super();
        }
    }

}
