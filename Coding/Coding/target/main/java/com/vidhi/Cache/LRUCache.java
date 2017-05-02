package com.vidhi.Cache;

import java.util.HashMap;

/**
 * Created by vidhip on 4/25/17.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 *                   it should invalidate the least recently used item before inserting a new item.
 *
 * 1.The key to solve this problem is using a double linked list which enables us to quickly move nodes.
 * 2.The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get() to be O(1).
 *   The list of double linked nodes make the nodes adding/removal operations O(1).
 */
public class LRUCache {

    private static HashMap<Integer, Node> cache  = new HashMap<Integer, Node>();
    private static DoublyLinkedList dll = new DoublyLinkedList();

    public static void main(String[] args){
        System.out.println("Test started");

        Person p1 = new Person(1, "jimit");
        put(p1.getId(), p1);

        Person p2 = new Person(2, "vidhi");
        put(p2.getId(), p2);

        Person p3 = new Person(3, "abc");
        put(p3.getId(), p3);

        get(2);
        System.out.println(dll.toString());
    }

    public static Person get(int id){
        if(cache.containsKey(id)){
            Node n =  cache.get(id);
            dll.moveToHead(n);
            return n.getPerson();
        } else {
            return null;
        }
    }

    public static void put(int id, Person p){
        Node personNode = new Node();
        personNode.setPerson(p);

        dll.add(personNode);
        cache.put(id,personNode);
    }

}
