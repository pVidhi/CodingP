package com.vidhi.ReEntrantLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * Created by vidhip on 5/1/17.
 */
public class Counter {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int[] count = new int[8];


    public int getApproxCount() {
        return IntStream.of(count).sum();
    }

    public int getExactCount(){
        return IntStream.of(count).sum();
    }

    /**
     * Acquires the read lock.
     *
     * <p>Acquires the read lock if the write lock is not held by
     * another thread and returns immediately.
     *
     * <p>If the write lock is held by another thread then
     * the current thread becomes disabled for thread scheduling
     * purposes and lies dormant until the read lock has been acquired.
     */
    /**
     * Acquires the write lock.
     *
     * <p>Acquires the write lock if neither the read nor write lock
     * are held by another thread
     * and returns immediately, setting the write lock hold count to
     * one.
     *
     * <p>If the current thread already holds the write lock then the
     * hold count is incremented by one and the method returns
     * immediately.
     *
     * <p>If the lock is held by another thread then the current
     * thread becomes disabled for thread scheduling purposes and
     * lies dormant until the write lock has been acquired, at which
     * time the write lock hold count is set to one.
     */
    public void incrementCounter(int threadId){
        lock.readLock().lock();
        count[threadId]++;
        lock.readLock().unlock();
    }
}
