package com.vidhi.RateLimiter;

/**
 * Created by vidhip on 4/26/17.
 */
public class SingleLinkedList {

    private Node head, tail = null;
    private int count = 0;

    public void insert(Node n){
        count++;

        n.setNext(head);
        head = n;

        if(tail == null)
            tail = head;
    }

    public void removeFirst(){
        count--;

        Node current = head;
        while(current != null && current.getNext() != null){
            if(current.getNext().getNext() == null){
                current.setNext(null);
                tail = current;
            } else {
                current = current.getNext();
            }
        }
    }

    public Node getTail(){
        return tail;
    }

    public int size(){
        return count;
    }

    public void display(){
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            String result = "head -> ";
            while (current.getNext() != null) {
                result += current.getTime() + " -> ";
                current = current.getNext();
            }
            result += current.getTime() + " -> tail";
            System.out.println("List looks like \n" + result);
        }
    }
}
