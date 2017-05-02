package com.vidhi.RateLimiter;

/**
 * Created by vidhip on 4/26/17.
 */
public class Node {

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private Node next;
    private long time;

}
