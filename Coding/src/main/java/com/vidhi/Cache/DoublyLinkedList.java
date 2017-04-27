package com.vidhi.Cache;

/**
 * Created by vidhip on 4/25/17.
 */


public class DoublyLinkedList {

    private Node head, tail = null;

    public void moveToHead(Node n){
        deleteNode(n);
        add(n);
    }

    public void add(Node n){
        n.setNextNode(head);
        n.setPreviousNode(null);

        if(head != null) {
            head.setPreviousNode(n);
        }

        head = n;

        if(tail == null)
            tail = head;
    }

    public void deleteNode(Node n){
        if(n.getPreviousNode() != null){
            n.getPreviousNode().setNextNode(n.getNextNode());
        }else{
            head = n.getNextNode();
        }

        if(n.getNextNode() != null){
            n.getNextNode().setPreviousNode(n.getPreviousNode());
        }else{
            tail = n.getPreviousNode();
        }
    }

    public String toString() {
        String result = "";
        Node current = head;
        while (current.getNextNode() != null) {
            result += current.getPerson().getId() + ", ";
            current = current.getNextNode();
        }
        result += current.getPerson().getId() + ", ";
        return "List: " + result;
    }
}