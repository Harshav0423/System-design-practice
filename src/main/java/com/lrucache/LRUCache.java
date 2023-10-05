package com.lrucache;

import java.util.HashMap;

// least recently used,
// func - top element - get , set - value func.
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node (int key, int value ) {
        this.key = key;
        this.value = value;
    }
}
class LinkedList {
    Node head;
    Node tail;
    public LinkedList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void moveToHead(Node node) {
        System.out.println(node.next);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }
    public void addToHead(Node node) {
        Node tmp = head.next;
        head.next.prev = node;
        node.prev = head;
        node.next = tmp;
        tmp.prev = node;
    }
    void removeFromTail() {
        Node tmp = tail.prev.prev;
        tmp.next = tail;
        tail.prev = tmp;
    }
    Node getTail() {
        return tail.prev;
    }

}

public class LRUCache {
int MAX_SIZE = 100;
Integer size;
LinkedList list;
HashMap<Integer, Node> map;

public LRUCache(Integer cap) {
    this.size = cap;
    this.list = new LinkedList();
    this.map = new HashMap(cap);
}

public int get(int key) {

    Node node = map.get(key);
    if (node == null) {
        return -1;
    }
    list.moveToHead(node);
    return node.value;
}

public void put(int key, int value) {
    Node node = map.get(key);
    // if already exists
    if(node != null) {
        list.moveToHead(node);
        node.value = value;
    }
    else {
        Node newNode = new Node(key, value);

        // if cap reaches, remove the least used one
        if(map.size() == size) {
            Node tail = list.getTail();
            list.removeFromTail();
            map.remove(tail.key);
        }

        list.addToHead(newNode);
        map.put(key, newNode);
    }
}

}
